package Practica.MiraiApi.dto;

public class EmpleadoNombreDto {
    private String nombres;
    private String apePaterno;
    private String apeMaterno;

    

    public EmpleadoNombreDto() {
    }

    
    public EmpleadoNombreDto(String nombres, String apePaterno, String apeMaterno) {
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
    }


    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApePaterno() {
        return apePaterno;
    }
    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }
    public String getApeMaterno() {
        return apeMaterno;
    }
    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    
}
