package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.repository.IAreaRepository;
import jakarta.transaction.Transactional;

@Service
public class AreaService {
    @Autowired
    IAreaRepository areaRepository;

    public AreaModel create(AreaModel area){
        return areaRepository.save(area);
    }
    
    public Optional<AreaModel> findById(int id){
        return areaRepository.findById(id);
    }

    @Transactional
    public AreaModel update(AreaModel area) {
        return areaRepository.save(area);
    }

    
    public List<AreaModel> findAll() {
        return (List<AreaModel>) areaRepository.findAll();
    }


    public boolean delete(int id){
        try{

            areaRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }
}
