package Practica.MiraiApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Practica.MiraiApi.model.SalarioModel;

@Repository
public interface ISalarioRepository extends CrudRepository<SalarioModel,Integer> {
    
}
