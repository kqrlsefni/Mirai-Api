package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.repository.IJorLaboralRepository;
import jakarta.transaction.Transactional;

@Service
public class JorLaboralService {
    @Autowired
    IJorLaboralRepository jorLaboralRepository;

    public JorLaboralModel create(JorLaboralModel jornada){
        return jorLaboralRepository.save(jornada);
    }
    
    public Optional<JorLaboralModel> findById(int id){
        return jorLaboralRepository.findById(id);
    }

    @Transactional
    public JorLaboralModel update(JorLaboralModel jornada) {
        return jorLaboralRepository.save(jornada);
    }

    
    public List<JorLaboralModel> findAll() {
        return (List<JorLaboralModel>) jorLaboralRepository.findAll();
    }


    public boolean delete(int id){
        try{

            jorLaboralRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }
}
