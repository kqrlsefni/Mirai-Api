package Practica.MiraiApi.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

import Practica.MiraiApi.dto.EmpleadoSalarioDto;
import Practica.MiraiApi.dto.SalarioNetoDto;
import Practica.MiraiApi.model.SalarioModel;
import Practica.MiraiApi.service.SalarioService;
import jakarta.servlet.http.HttpServletResponse;

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

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("/getSalarioNeto/{id}")
    public ResponseEntity<SalarioNetoDto> getSalarioNeto(@PathVariable("id") int id) {
        return new ResponseEntity<SalarioNetoDto>(salarioService.salarioNeto(id),HttpStatus.OK);
    }

    @CrossOrigin(origins = "htto://localhost:4200/")
    @GetMapping("/pagoExcel")
    public ResponseEntity<InputStreamResource> getPagoExcel(HttpServletResponse response) throws Exception{
        ByteArrayInputStream stream = salarioService.exportarExcel();
        response.setContentType("application/octet-stream");
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment; filename=empleados.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
    }
}
