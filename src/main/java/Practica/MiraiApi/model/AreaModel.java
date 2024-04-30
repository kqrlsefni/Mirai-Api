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
    @Column(name="reid")
    public int id;

    @Column(name="arenombre")    
    public String nombre;

    @Column(name="aresalbasico")
    public String salBasico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalBasico() {
        return salBasico;
    }

    public void setSalBasico(String salBasico) {
        this.salBasico = salBasico;
    }

    
}
