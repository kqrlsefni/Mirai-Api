package Practica.MiraiApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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

    @Column(name="empfechingreso")
    public String fechaIngreso;

    @Column(name="empfechnacimiento")
    public String fechaNacimiento;

    @Column(name="empgenero")
    public String genero;

     // @Column(name="empsalbasico")
    // public int salBasico;

    // @Column(name="empmodcontrato")
    // public int modContrato;

    @Column(name="empjorlaboral")
    public int jorLaboral;

    @Column(name="emparea")
    public int areaId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="empsalbasico", referencedColumnName = "salid")
    public SalarioModel salario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="empmodcontrato", referencedColumnName = "modconid")
    public ModContratoModel contrato;

    // @ManyToOne
    // @JoinColumn(name="emparea")
    // @JsonBackReference
    // public AreaModel area;

    // @ManyToOne
    // @JoinColumn(name = "empjorlaboral")
    // @JsonBackReference
    // public JorLaboralModel jornada;

    public EmpleadoModel() {
    }
 
}
