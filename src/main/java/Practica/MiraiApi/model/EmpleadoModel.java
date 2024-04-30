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

    @Column(name="EmpFechIngreso")
    public String fechIngreso;

    @Column(name="empgenero")
    public String genero;

    @Column(name="emparea")
    public int area;

    @Column(name="empmodcontrato")
    public int modContrato;

    @Column(name="empjorlaboral")
    public int jorLaboral;
}
