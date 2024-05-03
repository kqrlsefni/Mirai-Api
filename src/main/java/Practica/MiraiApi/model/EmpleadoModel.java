package Practica.MiraiApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class EmpleadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empid")
    public int id;

    @Column(name="empcodigo")    
    public String codigo;

    @Column(name="empdni")    
    public String dni;

    @Column(name="empnombres")    
    public String nombres;

    @Column(name="empapepaterno")
    public String apePaterno;

    @Column(name="empapematerno")
    public String apeMaterno;

    @Column(name="empfechingreso")
    public String fechaIngreso;

    @Column(name="empfechnacimiento")
    public String fechaNacimiento;

    @Column(name="empgenero")
    public String genero;

    @Column(name="empsalbasico")
    public int salBasico;

    @Column(name="emparea")
    public int area;

    @Column(name="empmodcontrato")
    public int modContrato;

    @Column(name="empjorlaboral")
    public int jorLaboral;

    public int getId() {
        return id;
    }

    public int getArea() {
        return area;
    }

    public EmpleadoModel() {
    }

    public EmpleadoModel(String codigo, String dni, String nombres, String apePaterno, String apeMaterno,
            String fechaIngreso, String fechaNacimiento, String genero, int salBasico, int area, int modContrato,
            int jorLaboral) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.salBasico = salBasico;
        this.area = area;
        this.modContrato = modContrato;
        this.jorLaboral = jorLaboral;
    }

    
    
}
