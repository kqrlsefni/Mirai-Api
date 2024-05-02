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
import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.repository.IAreaRepository;
import Practica.MiraiApi.repository.IEmpleadoRepository;
import Practica.MiraiApi.repository.ISalarioRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Autowired
    IAreaRepository areaRepository;
    @Autowired
    ISalarioRepository salarioRepository;

    EmpleadoModel empleado = new EmpleadoModel();
    SalarioModel salario;
    DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public EmpleadoModel create(EmpleadoModel empleado){
        this.empleado = empleadoRepository.save(empleado);
        Optional<AreaModel> area = areaRepository.findById(empleado.area);
        salario = new SalarioModel(this.empleado.getId(),area.get().getSalBasico());
        salarioRepository.save(salario);
        return this.empleado;
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


    public boolean delete(int id){
        try{

            empleadoRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

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
        long dias = 0;
        LocalDate fechaActual = LocalDate.now();
        List<LocalDate> feriados = new ArrayList<>();
        feriados.add(LocalDate.of(fechaActual.getYear(), 1, 1));
        feriados.add(LocalDate.of(fechaActual.getYear(), 3, 28));
        feriados.add(LocalDate.of(fechaActual.getYear(), 3, 29));
        feriados.add(LocalDate.of(fechaActual.getYear(), 5, 1));
        feriados.add(LocalDate.of(fechaActual.getYear(), 6, 7));
        feriados.add(LocalDate.of(fechaActual.getYear(), 6, 29));
        feriados.add(LocalDate.of(fechaActual.getYear(), 7, 23));
        feriados.add(LocalDate.of(fechaActual.getYear(), 7, 28));
        feriados.add(LocalDate.of(fechaActual.getYear(), 7, 29));
        feriados.add(LocalDate.of(fechaActual.getYear(), 8, 6));
        feriados.add(LocalDate.of(fechaActual.getYear(), 8, 30));
        feriados.add(LocalDate.of(fechaActual.getYear(), 10, 8));
        feriados.add(LocalDate.of(fechaActual.getYear(), 11, 1));
        feriados.add(LocalDate.of(fechaActual.getYear(), 12, 8));
        feriados.add(LocalDate.of(fechaActual.getYear(), 12, 9));
        feriados.add(LocalDate.of(fechaActual.getYear(), 12, 25));
        
        LocalDate fechaIngreso = LocalDate.parse(ingreso, fechaFormato);
        long diasTotales = ChronoUnit.DAYS.between(fechaIngreso, fechaActual) + 1;
        long domingos = ChronoUnit.DAYS.between(fechaIngreso, fechaActual) / 7;
        dias = diasTotales - domingos;
        EmpleadoAntiguedadDto antiguedad = new EmpleadoAntiguedadDto();
        for (LocalDate feriado : feriados) {
            if (feriado.isAfter(fechaIngreso) && feriado.isBefore(fechaActual.plusDays(1))) {
                dias--;
            }
        }
        antiguedad.dias = Optional.of(dias);
        int dia = (int) (dias%30);
        long mes = ChronoUnit.MONTHS.between(fechaIngreso, fechaActual);
        long año = ChronoUnit.YEARS.between(fechaIngreso, fechaActual);
        antiguedad.formato = Optional.of(año + ";" + mes + ";" + dia);
        return antiguedad;
    }

    // public double salarioNeto(){

    // }
}
