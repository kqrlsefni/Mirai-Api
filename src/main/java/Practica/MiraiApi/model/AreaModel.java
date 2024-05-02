package Practica.MiraiApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Area")
public class AreaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="areid")
    public int id;

    @Column(name="arenombre")    
    public String nombre;

    @Column(name="aresalbasico")
    public double salBasico;
    

    public double getSalBasico() {
        return salBasico;
    }    
    
    
}
