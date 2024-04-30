package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.repository.ISalarioRepository;
import jakarta.transaction.Transactional;

@Service
public class SalarioService {
    @Autowired
    ISalarioRepository salarioRepository;

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
}
