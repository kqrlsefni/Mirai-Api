package Practica.MiraiApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Practica.MiraiApi.dto.EmpleadoAntiguedadDto;
import Practica.MiraiApi.dto.EmpleadoEdadDto;
import Practica.MiraiApi.dto.EmpleadoNombreDto;
import Practica.MiraiApi.dto.EmpleadoRegistroDto;
import Practica.MiraiApi.dto.Response.EmpDeleteRes;
import Practica.MiraiApi.dto.Response.EmpleadoRes;
import Practica.MiraiApi.dto.Response.EmpleadoResList;
import Practica.MiraiApi.mapper.EmpleadoMapper;
import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.service.AreaService;
import Practica.MiraiApi.service.EmpleadoService;
import Practica.MiraiApi.service.JorLaboralService;

@CrossOrigin(origins = "htto://localhost:4200")
@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    AreaService areaService;
    @Autowired
    JorLaboralService jorLaboralService;

    @CrossOrigin(origins = "htto://localhost:4200/")
    @PostMapping("/create")
    public EmpleadoModel create(@RequestBody EmpleadoModel empleadoModel) {
        return empleadoService.create(empleadoModel);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("/findById/{id}")
    public Optional<EmpleadoRes> findById(@PathVariable int id) {
        // EmpleadoRes empleado = EmpleadoMapper.INSTANCE.ModelToResDetail(empleadoService.findById(id).get());
        EmpleadoModel mod = empleadoService.findById(id).get();
        AreaModel area = areaService.findById(mod.areaId).get();
        JorLaboralModel jornada = jorLaboralService.findById(mod.jorLaboral).get();

        int edad = empleadoService.edad(mod.fechaNacimiento);
        EmpleadoAntiguedadDto antiguedad = empleadoService.antiguedad(mod.fechaIngreso);
        int antDias = antiguedad.dias.get().intValue();
        String antformato = antiguedad.formato.get();
        EmpleadoNombreDto empleado = new EmpleadoNombreDto(
            mod.nombres,
            mod.apePaterno,
            mod.apeMaterno
        );
        EmpleadoRes res = new EmpleadoRes(
            mod.id,
            mod.codigo,
            mod.dni,
            mod.nombres + " " + mod.apePaterno + " " + mod.apeMaterno,
            empleado,
            area,
            jornada,
            mod.contrato,
            mod.salario,
            mod.genero,
            mod.fechaIngreso,
            mod.fechaNacimiento,
            edad,
            antDias,
            antformato
        );
    
        return Optional.ofNullable(res);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @PutMapping("/update")
    public EmpleadoModel update(@RequestBody EmpleadoModel empleado) {
        return empleadoService.update(empleado);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("/findAll")
    public ResponseEntity<List<EmpleadoRes>> findAll() {
        List<EmpleadoModel> empleados = empleadoService.findAll();
        List<EmpleadoRes> list = new ArrayList<EmpleadoRes>(empleados.size());
        for(EmpleadoModel mod : empleados){
            AreaModel area = areaService.findById(mod.areaId).get();
            JorLaboralModel jornada = jorLaboralService.findById(mod.jorLaboral).get();
    
            int edad = empleadoService.edad(mod.fechaNacimiento);
            EmpleadoAntiguedadDto antiguedad = empleadoService.antiguedad(mod.fechaIngreso);
            int antDias = antiguedad.dias.get().intValue();
            String antformato = antiguedad.formato.get();
            EmpleadoNombreDto empleado = new EmpleadoNombreDto(
                mod.nombres,
                mod.apePaterno,
                mod.apeMaterno
            );
            EmpleadoRes res = new EmpleadoRes(
                mod.id,
                mod.codigo,
                mod.dni,
                mod.nombres + " " + mod.apePaterno + " " + mod.apeMaterno,
                empleado,
                area,
                jornada,
                mod.contrato,
                mod.salario,
                mod.genero,
                mod.fechaIngreso,
                mod.fechaNacimiento,
                edad,
                antDias,
                antformato
            );

            list.add(res);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
        
    }

    
    @CrossOrigin(origins = "htto://localhost:4200/")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmpDeleteRes> delete(@PathVariable("id") int id){
        EmpDeleteRes deleted = empleadoService.delete(id);
        if(deleted.isEliminado()) return new ResponseEntity<EmpDeleteRes>(deleted,HttpStatus.OK);
        else return new ResponseEntity<EmpDeleteRes>(deleted,HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("getEdad")
    public ResponseEntity<String> edad(@RequestBody EmpleadoEdadDto empleadoDto){
        int edad = empleadoService.edad(empleadoDto.fechaNacimiento);
        return new ResponseEntity<>("edad: "+edad, HttpStatus.OK);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("getAntiguedad")
    public ResponseEntity<EmpleadoAntiguedadDto> antiguedad(@RequestBody EmpleadoAntiguedadDto empleadoDto){
        EmpleadoAntiguedadDto antiguedad = empleadoService.antiguedad(empleadoDto.fechaIngreso);
        return new ResponseEntity<>(antiguedad, HttpStatus.OK);
    }
}
