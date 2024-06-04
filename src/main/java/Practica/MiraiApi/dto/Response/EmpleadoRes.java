package Practica.MiraiApi.dto.Response;

import Practica.MiraiApi.dto.EmpleadoNombreDto;
import Practica.MiraiApi.model.AreaModel;
import Practica.MiraiApi.model.JorLaboralModel;
import Practica.MiraiApi.model.ModContratoModel;
import Practica.MiraiApi.model.SalarioModel;

public class EmpleadoRes {
    private int id;
    private String codigo;
    private String dni;
    private String nombreCompleto;
    private EmpleadoNombreDto empleado;
    private AreaModel area;
    private JorLaboralModel jornada;
    private ModContratoModel contrato;
    private SalarioModel salario;
    private String genero;
    private String fechaIngreso;
    private String fechaNacimiento;
    private int edad;
    private int antDias;
    private String antiguedad;

    
    
    public EmpleadoRes() {
    }
    public EmpleadoRes(int id, String codigo, String dni, String nombreCompleto, EmpleadoNombreDto empleado,
            AreaModel area, JorLaboralModel jornada, ModContratoModel contrato, SalarioModel salario, String genero,
            String fechaIngreso, String fechaNacimiento, int edad, int antDias, String antiguedad) {
        this.id = id;
        this.codigo = codigo;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.empleado = empleado;
        this.area = area;
        this.jornada = jornada;
        this.contrato = contrato;
        this.salario = salario;
        this.genero = genero;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.antDias = antDias;
        this.antiguedad = antiguedad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public EmpleadoNombreDto getEmpleado() {
        return empleado;
    }
    public void setEmpleado(EmpleadoNombreDto empleado) {
        this.empleado = empleado;
    }
    public AreaModel getArea() {
        return area;
    }
    public void setArea(AreaModel area) {
        this.area = area;
    }
    public JorLaboralModel getJornada() {
        return jornada;
    }
    public void setJornada(JorLaboralModel jornada) {
        this.jornada = jornada;
    }
    public ModContratoModel getContrato() {
        return contrato;
    }
    public void setContrato(ModContratoModel contrato) {
        this.contrato = contrato;
    }
    public SalarioModel getSalario() {
        return salario;
    }
    public void setSalario(SalarioModel salario) {
        this.salario = salario;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getAntDias() {
        return antDias;
    }
    public void setAntDias(int antDias) {
        this.antDias = antDias;
    }
    public String getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    


}