package Practica.MiraiApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="modcontrato")
public class ModContratoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="modconid")
    public int id;

    @Column(name="modconnombre")    
    public String nombre;

    @Column(name="modconfechinicio")
    public String fechaInicio;

    @Column(name="modconfechfin")
    public String fechaFin;
}
