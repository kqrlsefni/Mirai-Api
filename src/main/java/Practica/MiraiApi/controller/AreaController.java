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
    public AreaModel create(@RequestBody AreaModel area) {
        return areaService.create(area);
    }

    @GetMapping("/findById/{id}")
    public Optional<AreaModel> findById(@PathVariable int id) {
        return areaService.findById(id);
    }

    @PutMapping("/update")
    public AreaModel update(@RequestBody AreaModel area) {
        return areaService.update(area);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AreaModel>> findAll() {
        List<AreaModel> areas = areaService.findAll();

        if (!areas.isEmpty()) {
            return new ResponseEntity<>(areas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean ok= this.areaService.delete(id);
        if(ok) return new ResponseEntity<>("eliminado", HttpStatus.OK);
        else return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }
}
