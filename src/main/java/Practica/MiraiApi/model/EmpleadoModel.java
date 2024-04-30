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
    @Column(name="EmpCodigo")
    public int codigo;

    @Column(name="Empnombres")    
    public String nombres;

    @Column(name="EmpApePaterno")
    public String apePaterno;
    @Column(name="EmpApeMaterno")
    public String apeMaterno;
    @Column(name="EmpSalBasico")
    public String salBasico;
    @Column(name="EmpFechIngreso")
    public String fechIngreso;
}
