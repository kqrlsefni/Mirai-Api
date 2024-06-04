package Practica.MiraiApi.dto.Response;

public class EmpleadoResList {
    private int id;
    private String codigo;
    private String dni;
    private String empleado;
    private String area;
    private double salario;
    private String fechaIngreso;

    public EmpleadoResList(int id,String codigo, String dni, String empleado, String area, double salario, String fechaIngreso) {
        this.id = id;
        this.codigo = codigo;
        this.dni = dni;
        this.empleado = empleado;
        this.area = area;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    

    
}
