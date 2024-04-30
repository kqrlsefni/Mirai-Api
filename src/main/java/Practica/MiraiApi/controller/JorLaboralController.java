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

import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.service.JorLaboralService;

@RestController
@RequestMapping("api/jornada")
public class JorLaboralController {
    @Autowired
    JorLaboralService jorLaboralService;

    @PostMapping("/create")
    public JorLaboralModel create(@RequestBody JorLaboralModel jornada) {
        return jorLaboralService.create(jornada);
    }

    @GetMapping("/findById/{id}")
    public Optional<JorLaboralModel> findById(@PathVariable int id) {
        return jorLaboralService.findById(id);
    }

    @PutMapping("/update")
    public JorLaboralModel update(@RequestBody JorLaboralModel jornada) {
        return jorLaboralService.update(jornada);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<JorLaboralModel>> findAll() {
        List<JorLaboralModel> jornadas = jorLaboralService.findAll();

        if (!jornadas.isEmpty()) {
            return new ResponseEntity<>(jornadas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean ok= this.jorLaboralService.delete(id);
        if(ok) return new ResponseEntity<>("eliminado", HttpStatus.OK);
        else return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}
