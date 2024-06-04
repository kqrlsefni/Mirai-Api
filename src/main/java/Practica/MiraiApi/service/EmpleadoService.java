package Practica.MiraiApi.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.dto.EmpleadoAntiguedadDto;
import Practica.MiraiApi.dto.EmpleadoRegistroDto;
import Practica.MiraiApi.dto.Response.EmpDeleteRes;
import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.model.ModContratoModel;
import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.repository.IAreaRepository;
import Practica.MiraiApi.repository.IEmpleadoRepository;
import Practica.MiraiApi.repository.IModContratoRepository;
import Practica.MiraiApi.repository.ISalarioRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Autowired
    IModContratoRepository modContratoRepository;
    @Autowired
    ISalarioRepository salarioRepository;

    EmpleadoModel empleado;
    SalarioModel salario;
    ModContratoModel modContrato;
    DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    EmpDeleteRes deleteRes;

    public EmpleadoModel create(EmpleadoModel empleado){  
        return empleadoRepository.save(empleado);
    }
    
    public Optional<EmpleadoModel> findById(int id){
        return empleadoRepository.findById(id);
    }

    @Transactional
    public EmpleadoModel update(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    
    public List<EmpleadoModel> findAll() {
        return (List<EmpleadoModel>) empleadoRepository.findAll();
    }


    public EmpDeleteRes delete(int id){
        deleteRes = new EmpDeleteRes();
        try{
            empleadoRepository.deleteById(id);
            deleteRes.setEliminado(true);
            return deleteRes;
        }catch(Exception arr){
            deleteRes.setEliminado(false);
            return deleteRes;


        }
    }

    public int edad(String nacimiento){
        int edad = 0;
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.parse(nacimiento, fechaFormato);
        edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaNacimiento.getMonthValue() > fechaActual.getMonthValue() || (fechaNacimiento.getMonthValue() == fechaActual.getMonthValue() && fechaNacimiento.getDayOfMonth() > fechaActual.getDayOfMonth()))
            edad -= 1; 
        return edad;
    }

    public EmpleadoAntiguedadDto antiguedad(String ingreso){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngreso = LocalDate.parse(ingreso, fechaFormato);
        long dias = ChronoUnit.DAYS.between(fechaIngreso, fechaActual);
        long mes = ChronoUnit.MONTHS.between(fechaIngreso, fechaActual);
        long año = ChronoUnit.YEARS.between(fechaIngreso, fechaActual);
        long ajusteDias = ChronoUnit.DAYS.between(fechaIngreso.plusMonths(mes), fechaActual);
        EmpleadoAntiguedadDto antiguedad = new EmpleadoAntiguedadDto();
        long Nmes = mes % 12;
        //Nmes = Nmes - año;
        antiguedad.dias = Optional.of(dias);
        antiguedad.formato = Optional.of(año + " Años   " + Nmes + " Meses   " + ajusteDias + " Días ");
        antiguedad.fechaIngreso = ingreso;
        antiguedad.años = Optional.of(año);
        return antiguedad;
    }

    public long diasLaborables(String ingreso, String fin){
        long diasLaborables = 0;
        LocalDate fechaFin = LocalDate.parse(fin,fechaFormato);
        LocalDate fechaIngreso = LocalDate.parse(ingreso, fechaFormato);
        long mes = ChronoUnit.MONTHS.between(fechaIngreso, fechaFin);
        long ajusteDias = ChronoUnit.DAYS.between(fechaIngreso.plusMonths(mes), fechaFin) + 1;
        long dias = mes*30;
        diasLaborables = dias + ajusteDias;
        return diasLaborables;
    }
}
