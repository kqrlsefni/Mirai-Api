package Practica.MiraiApi.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    // @OneToMany(mappedBy = "area")
    // @JsonManagedReference
    // public List<EmpleadoModel> empleados;

    public double getSalBasico() {
        return salBasico;
    }    
    
    
}
