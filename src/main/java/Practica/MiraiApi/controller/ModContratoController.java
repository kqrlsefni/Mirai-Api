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

import Practica.MiraiApi.model.ModContratoModel;
import Practica.MiraiApi.service.ModContratoService;

@RestController
@RequestMapping("api/contrato")
public class ModContratoController {
    @Autowired
    ModContratoService modContratoService;

    @PostMapping("/create")
    public ModContratoModel create(@RequestBody ModContratoModel contrato) {
        return modContratoService.create(contrato);
    }

    @GetMapping("/findById/{id}")
    public Optional<ModContratoModel> findById(@PathVariable int id) {
        return modContratoService.findById(id);
    }

    @PutMapping("/update")
    public ModContratoModel update(@RequestBody ModContratoModel contrato) {
        return modContratoService.update(contrato);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ModContratoModel>> findAll() {
        List<ModContratoModel> contratos = modContratoService.findAll();

        if (!contratos.isEmpty()) {
            return new ResponseEntity<>(contratos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean ok= this.modContratoService.delete(id);
        if(ok) return new ResponseEntity<>("eliminado", HttpStatus.OK);
        else return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}
