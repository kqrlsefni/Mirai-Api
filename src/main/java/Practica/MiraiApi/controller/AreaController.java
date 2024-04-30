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

import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.service.AreaService;

@RestController
@RequestMapping("api/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    @PostMapping("/create")
    public AreaModel create(@RequestBody AreaModel usuario) {
        return areaService.create(usuario);
    }

    @GetMapping("/getById/{id}")
    public Optional<AreaModel> getById(@PathVariable int id) {
        return areaService.getById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<AreaModel> updateUsuario(@RequestBody AreaModel usuario) {
        AreaModel usuarioActualizado = areaService.update(usuario);

        if (usuarioActualizado != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByAll")
    public ResponseEntity<List<AreaModel>> findByAll() {
        List<AreaModel> usuarios = areaService.findByAll();

        if (!usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") int id){
        boolean ok= this.areaService.eliminarUsuario(id);
        
        if(ok){
            return "Se elimino el usuario con id "+ id;

        }else{
            return "No se pudo eliminar el usuario con id"+ id;
        }
    }
}
