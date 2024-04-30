package Practica.MiraiApi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.repository.IAreaRepository;

@Service
public class AreaService {
    @Autowired
    IAreaRepository areaRepository;

    public AreaModel create(AreaModel usuario){
        return areaRepository.save(usuario);
    }
    
    public Optional<AreaModel> getById(int id){
        return areaRepository.findById(id);
    }

    public AreaModel update(AreaModel usuario) {
        Optional<AreaModel> usuarioExistente = areaRepository.findById(usuario.getId());
    
        if (usuarioExistente.isPresent()) {
            AreaModel usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setSalBasico(usuario.getSalBasico());
            return areaRepository.save(usuarioActualizado);
        } else {
            return null;
        }
    }

    
    public List<AreaModel> findByAll() {
        return (List<AreaModel>) areaRepository.findAll();
    }


    public boolean eliminarUsuario(int id){
        try{

            areaRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }
}
