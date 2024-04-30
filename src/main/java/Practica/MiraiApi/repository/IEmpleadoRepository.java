package Practica.MiraiApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Practica.MiraiApi.model.EmpleadoModel;

@Repository
public interface IEmpleadoRepository extends CrudRepository<EmpleadoModel,Integer> {
    
}
