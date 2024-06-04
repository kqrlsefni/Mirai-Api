package Practica.MiraiApi.dto;

public class EmpleadoSalarioDto {
    public int salId;
    public String fechaInicio;
    public String fechaFin;
    public String fechaNacimiento;
    public EmpleadoSalarioDto() {
    }
    public EmpleadoSalarioDto(int salId, String fechaInicio, String fechaFin, String fechaNacimiento) {
        this.salId = salId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaNacimiento = fechaNacimiento;
    }

    
}
