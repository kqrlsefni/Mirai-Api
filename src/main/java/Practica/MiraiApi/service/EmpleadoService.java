package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.repository.IEmpleadoRepository;
import Practica.MiraiApi.repository.ISalarioRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {
    @Autowired
    IEmpleadoRepository empleadoRepository;
    SalarioService salarioService;
    EmpleadoModel empleado;
    SalarioModel salario;

    public EmpleadoModel create(EmpleadoModel empleado){
        empleado = empleadoRepository.save(empleado);
        
        return empleado;
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
}
