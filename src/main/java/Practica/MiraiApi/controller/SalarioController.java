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

import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.service.SalarioService;

@RestController
@RequestMapping("api/salario")
public class SalarioController {
    @Autowired
    SalarioService salarioService;

    @GetMapping("/findById/{id}")
    public Optional<SalarioModel> findById(@PathVariable int id) {
        return salarioService.findById(id);
    }

    @PutMapping("/update")
    public SalarioModel update(@RequestBody SalarioModel area) {
        return salarioService.update(area);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<SalarioModel>> findAll() {
        List<SalarioModel> areas = salarioService.findAll();

        if (!areas.isEmpty()) {
            return new ResponseEntity<>(areas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean ok= this.salarioService.delete(id);
        if(ok) return new ResponseEntity<>("eliminado", HttpStatus.OK);
        else return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}
