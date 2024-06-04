package Practica.MiraiApi.dto;

public class SalarioNetoDto {

    public double gratificacionJD;
    public double bonoGeneral;
    public double bonoAntiguedad;
    public double bonoEdad;
    public double impuesto;
    public double salud;
    public double cts;
    public double neto;
    
    public SalarioNetoDto() {
    }

    public SalarioNetoDto(double gratificacionJD, double bonoGeneral, double bonoAntiguedad, double bonoEdad,
            double impuesto, double salud, double cts, double neto) {
        this.gratificacionJD = gratificacionJD;
        this.bonoGeneral = bonoGeneral;
        this.bonoAntiguedad = bonoAntiguedad;
        this.bonoEdad = bonoEdad;
        this.impuesto = impuesto;
        this.salud = salud;
        this.cts = cts;
        this.neto = neto;
    }

    
}
