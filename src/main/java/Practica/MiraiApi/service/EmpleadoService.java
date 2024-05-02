package Practica.MiraiApi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
