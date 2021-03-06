public class SocorristaMoto extends Vehiculo implements Socorrista<Moto> {
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto con patente " + moto.getPatente());
    }
}
