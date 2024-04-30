package Practica.MiraiApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jorlaboral")
public class JorLaboralModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jorlabid")
    public int id;

    @Column(name="jorlabnombre")    
    public String nombre;

    @Column(name="jorlabhoras")
    public int horas;
}
