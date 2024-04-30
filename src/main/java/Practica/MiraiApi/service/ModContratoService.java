package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.ModContratoModel;
import Practica.MiraiApi.repository.IModContratoRepository;
import jakarta.transaction.Transactional;

@Service
public class ModContratoService {
    @Autowired
    IModContratoRepository modContratoRepository;

    public ModContratoModel create(ModContratoModel contrato){
        return modContratoRepository.save(contrato);
    }
    
    public Optional<ModContratoModel> findById(int id){
        return modContratoRepository.findById(id);
    }

    @Transactional
    public ModContratoModel update(ModContratoModel contrato) {
        return modContratoRepository.save(contrato);
    }

    
    public List<ModContratoModel> findAll() {
        return (List<ModContratoModel>) modContratoRepository.findAll();
    }


    public boolean delete(int id){
        try{

            modContratoRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }
}
