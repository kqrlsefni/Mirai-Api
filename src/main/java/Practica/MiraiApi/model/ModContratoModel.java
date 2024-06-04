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

    // @OneToOne(cascade = CascadeType.ALL)
    // public EmpleadoModel empleado;

    public ModContratoModel(String nombre, String fechaInicio, String fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ModContratoModel() {
    }

    
}
