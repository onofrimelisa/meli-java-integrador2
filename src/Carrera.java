import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera (double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto(370, 240, 50, "FKL876", 1000, 4);
        this.socorristaMoto = new SocorristaMoto(350, 220, 50, "PIO826", 1000, 4);
    }

    private void agregarVehiculo (Vehiculo vehiculo) {
        int vehiculosActuales = listaDeVehiculos.size() ;
        if (vehiculosActuales < cantidadDeVehiculosPermitidos) {
            this.listaDeVehiculos.add(vehiculosActuales, vehiculo);
            System.out.println("Hay cupo: el vehículo se agregó a la carrera con éxito.");
        }else{
            System.out.println("No hay cupo: el vehículo no se pudo agregar a la carrera.");
        }
    }

    public void darDeAltaAuto (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.agregarVehiculo(auto);
    }

    public void darDeAltaMoto (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        this.agregarVehiculo(moto);
    }

    public void mostrarVehiculos () {
        System.out.println(this.listaDeVehiculos.toString());
    }

    public Vehiculo obtenerVehiculoConPatente(String patente) {
        for (Vehiculo v: listaDeVehiculos) {
            if (v.getPatente().equals(patente)) {
                return v;
            }
        }
        return null;
    }

    public void eliminarVehiculo (Vehiculo vehículo) {
        Vehiculo vehiculoObtenido = obtenerVehiculoConPatente(vehículo.getPatente());
        this.listaDeVehiculos.remove(vehiculoObtenido);
    }

    public void eliminarVehiculoConPatente (String unaPatente) {
        listaDeVehiculos.remove(obtenerVehiculoConPatente(unaPatente));
    }

    public Vehiculo ganadorDeLaCarrera() {
        double max = 0;
        Vehiculo vehiculoMax = null;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            double posibilidadDeGanar = vehiculo.calcularPosibilidadDeGanar();
            if (posibilidadDeGanar > max) {
                max = posibilidadDeGanar;
                vehiculoMax = vehiculo;
            }
        }

        return vehiculoMax;
    }

    public void socorrerAuto(String unaPatente) {
        Auto auto = (Auto) obtenerVehiculoConPatente(unaPatente);
        if (auto != null) {
            socorristaAuto.socorrer(auto);
        }
    }

    public void socorrerMoto(String unaPatente) {
        Moto moto = (Moto) obtenerVehiculoConPatente(unaPatente);
        if (moto != null) {
            socorristaMoto.socorrer(moto);
        }
    }
}
