package Practica.MiraiApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public SalarioModel(double salBasico) {
        this.salBasico = salBasico;
    }

    public SalarioModel() {
    }

    
    
}
