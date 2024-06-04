package Practica.MiraiApi.mapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.List;
import Practica.MiraiApi.dto.EmpleadoAntiguedadDto;
import Practica.MiraiApi.dto.Response.EmpleadoRes;
import Practica.MiraiApi.dto.Response.EmpleadoResList;
import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.service.AreaService;
import Practica.MiraiApi.service.EmpleadoService;
import Practica.MiraiApi.service.JorLaboralService;

public class EmpleadoMapperImpl implements EmpleadoMapper{

    SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    SimpleDateFormat formatoDeseado = new SimpleDateFormat("dd/MM/yyyy");
    LocalDate fecha, fnac, finicio, ffin;
    String fechaIngresoFormateada, fnacformat, finicioformat,ffinformat;
    EmpleadoService empleadoService = new EmpleadoService();
    AreaService areaService = new AreaService();
    JorLaboralService jorLaboralService = new JorLaboralService();

    @Override
    public EmpleadoRes ModelToResDetail(EmpleadoModel mod) {
            return null;
    }

    @Override
    public EmpleadoResList ModelToRes(EmpleadoModel empleadoModel) {
        if(empleadoModel == null){
            return null;
        }
        AreaModel area = areaService.findById(empleadoModel.areaId).get();
        EmpleadoResList reslist= new EmpleadoResList(
            empleadoModel.id,
            empleadoModel.codigo,
            empleadoModel.dni,
            empleadoModel.nombres + " " + empleadoModel.apePaterno + " " + empleadoModel.apeMaterno,
            area.nombre,
            empleadoModel.salario.salBasico,
            empleadoModel.fechaIngreso
            );
            return reslist;
    }
    
    @Override
    public List<EmpleadoResList> ListModelToRes(List<EmpleadoModel> mod) {
        if(mod == null){
            return null;
        }
        List<EmpleadoResList> list = new ArrayList<EmpleadoResList>(mod.size());
        for(EmpleadoModel m : mod){
            list.add(ModelToRes(m));
        }

        return list;
    }

    
    }

