package Practica.MiraiApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Practica.MiraiApi.model.JorLaboralModel;

@Repository
public interface IJorLaboralRepository extends CrudRepository<JorLaboralModel,Integer> {
    
}
