public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public String toString () {
        return "patente: " +
                patente +
                ", velocidad " +
                velocidad;
    }

    public double calcularPosibilidadDeGanar(){
        return velocidad * (aceleracion / 2) / (anguloDeGiro * (peso - ruedas * 100));
    }
}
