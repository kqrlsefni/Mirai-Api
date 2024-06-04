package Practica.MiraiApi.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Practica.MiraiApi.dto.Response.EmpleadoRes;
import Practica.MiraiApi.dto.Response.EmpleadoResList;
import Practica.MiraiApi.model.EmpleadoModel;

@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper( EmpleadoMapper.class );

    // PlatilloModel RequestToModel(PlatilloRequest req);
    EmpleadoRes ModelToResDetail(EmpleadoModel mod);
    EmpleadoResList ModelToRes(EmpleadoModel empleadoModel);
    List<EmpleadoResList> ListModelToRes(List<EmpleadoModel> mod);
}
