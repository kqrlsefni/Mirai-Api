package Practica.MiraiApi.dto;

public class RemuneracionesDto {

    //montos
    public double gratificacionJD = 300;
    public double bonoGeneral = 250;
    public double bonoAntiguedad = 150;
    public double bonoEdad = 150;
    public double impuesto = 0.125;
    public double salud = 0.04;
    public double cts = 0;
    //condiciones
    public int edad = 40;
    public int antiguedad = 1;

    public RemuneracionesDto() {
    }

    public RemuneracionesDto(double gratificacionJD, double bonoGeneral, double bonoAntiguedad, double bonoEdad,
            double impuesto, double salud, double cts) {
        this.gratificacionJD = gratificacionJD;
        this.bonoGeneral = bonoGeneral;
        this.bonoAntiguedad = bonoAntiguedad;
        this.bonoEdad = bonoEdad;
        this.impuesto = impuesto;
        this.salud = salud;
        this.cts = cts;
    }

    
    
}
