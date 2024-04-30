package Practica.MiraiApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Practica.MiraiApi.model.AreaModel;

@Repository
public interface IAreaRepository extends CrudRepository<AreaModel,Integer> {
    
}
