package Practica.MiraiApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Practica.MiraiApi.model.ModContratoModel;

@Repository
public interface IModContratoRepository extends CrudRepository<ModContratoModel,Integer> {
    
}
