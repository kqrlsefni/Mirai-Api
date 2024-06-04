package Practica.MiraiApi.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.dto.EmpleadoAntiguedadDto;
import Practica.MiraiApi.dto.EmpleadoSalarioDto;
import Practica.MiraiApi.dto.RemuneracionesDto;
import Practica.MiraiApi.dto.SalarioNetoDto;
import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.repository.IEmpleadoRepository;
import Practica.MiraiApi.repository.ISalarioRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@Service
public class SalarioService {
    @Autowired
    ISalarioRepository salarioRepository;
    @Autowired
    IEmpleadoRepository empleadoRepository;
    RemuneracionesDto remuneracionesDto = new RemuneracionesDto();
    EmpleadoService empleadoService = new EmpleadoService();
    DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public SalarioModel create(SalarioModel salario){
        return salarioRepository.save(salario);
    }
    
    public Optional<SalarioModel> findById(int id){
        return salarioRepository.findById(id);
    }

    @Transactional
    public SalarioModel update(SalarioModel salario) {
        return salarioRepository.save(salario);
    }

    
    public List<SalarioModel> findAll() {
        return (List<SalarioModel>) salarioRepository.findAll();
    }


    public boolean delete(int id){
        try{

            salarioRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }

    public SalarioNetoDto salarioNeto(int id){
        EmpleadoModel salarioModel = empleadoRepository.findById(id).get();
        EmpleadoSalarioDto salarioDto = new EmpleadoSalarioDto(
            salarioModel.salario.id,
            salarioModel.contrato.fechaInicio,
            salarioModel.contrato.fechaFin,
            salarioModel.fechaNacimiento
        );
        LocalDate fechaFin = LocalDate.parse(salarioDto.fechaFin,fechaFormato);
        double  salarioNeto = 0, impuesto=0,salud=0, cts=0,jd=0,edad=0,antiguedad=0,general=0;
        SalarioModel salario = salarioRepository.findById(salarioDto.salId).get();
        int edadEmpleado = empleadoService.edad(salarioDto.fechaNacimiento);
        long antiguedadEmpleado = empleadoService.antiguedad(salarioDto.fechaInicio).años.get();
        salarioNeto = salario.salBasico;
        impuesto = salarioNeto * remuneracionesDto.impuesto;
        salud = salarioNeto * remuneracionesDto.salud;
        LocalDate fechaActual = LocalDate.now();
        salarioNeto += remuneracionesDto.bonoGeneral;
        general = remuneracionesDto.bonoGeneral;
        if(fechaActual.getMonthValue() == 6 || fechaActual.getMonthValue() == 12){
            salarioNeto += remuneracionesDto.gratificacionJD;
            jd = remuneracionesDto.gratificacionJD;
        }      
        if(edadEmpleado >= remuneracionesDto.edad){
            salarioNeto += remuneracionesDto.bonoEdad;
            edad = remuneracionesDto.bonoEdad;
        }  
        if((int) antiguedadEmpleado >= remuneracionesDto.antiguedad){
            salarioNeto += remuneracionesDto.bonoAntiguedad;
            antiguedad = remuneracionesDto.bonoAntiguedad;
        }
        salarioNeto = salarioNeto - impuesto - salud;
        if(fechaFin.isEqual(fechaActual)){
            cts = liquidacion(salarioDto);
        }
        salarioNeto += cts;
        SalarioNetoDto netoDto = new SalarioNetoDto(
            jd,general,antiguedad,edad,impuesto,salud,cts,salarioNeto
        );
        return netoDto;
    }

    public double liquidacion(EmpleadoSalarioDto salarioDto){
        LocalDate fechaFin = LocalDate.parse(salarioDto.fechaFin,fechaFormato);
        LocalDate fechaInicio = LocalDate.parse(salarioDto.fechaInicio, fechaFormato);
        long dias = empleadoService.diasLaborables(salarioDto.fechaInicio,salarioDto.fechaFin);
        long mes = ChronoUnit.MONTHS.between(fechaInicio,fechaFin);
        SalarioModel salario = salarioRepository.findById(salarioDto.salId).get();
        double gratificacion = (salario.salBasico/6 * mes)/360 * dias; 
        double cts = salario.salBasico + gratificacion/6;
        return cts;
    }

    public ByteArrayInputStream exportarExcel() throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        HSSFSheet sheet = workbook.createSheet("Empleado Pago");

        HSSFRow row = sheet.createRow(1);
        sheet.addMergedRegion(CellRangeAddress.valueOf("A2:Q2"));
		row.createCell(0).setCellValue("BOLETA DE PAGO");

		int dataRowIndex = 1;

		workbook.write(stream);
		workbook.close();
		//ops.close();
        return new ByteArrayInputStream(stream.toByteArray());
    }

}
