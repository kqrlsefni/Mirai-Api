package Practica.MiraiApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Practica.MiraiApi.model.EmpleadoModel;
import Practica.MiraiApi.service.EmpleadoService;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/create")
    public EmpleadoModel create(@RequestBody EmpleadoModel empleado) {
        return empleadoService.create(empleado);
    }

    @GetMapping("/findById/{id}")
    public Optional<EmpleadoModel> findById(@PathVariable int id) {
        return empleadoService.findById(id);
    }

    @PutMapping("/update")
    public EmpleadoModel update(@RequestBody EmpleadoModel empleado) {
        return empleadoService.update(empleado);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EmpleadoModel>> findAll() {
        List<EmpleadoModel> empleados = empleadoService.findAll();

        if (!empleados.isEmpty()) {
            return new ResponseEntity<>(empleados, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean ok= this.empleadoService.delete(id);
        if(ok) return new ResponseEntity<>("eliminado", HttpStatus.OK);
        else return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}
