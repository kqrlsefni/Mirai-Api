package Practica.MiraiApi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Salario")
public class SalarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salid")
    public int id;

    @Column(name = "salbasico")
    public double salBasico;

    @Column(name = "salneto")
    public double salNeto;

    @Column(name = "salnetofecha")
    public String salNetoFecha;

    // @OneToOne(cascade = CascadeType.ALL)
    // public EmpleadoModel empleado;

    public SalarioModel(double salBasico) {
        this.salBasico = salBasico;
    }

    public SalarioModel() {
    }

    public SalarioModel(int id, double salBasico, double salNeto, String salNetoFecha) {
        this.id = id;
        this.salBasico = salBasico;
        this.salNeto = salNeto;
        this.salNetoFecha = salNetoFecha;
    }

    

    
    
}
