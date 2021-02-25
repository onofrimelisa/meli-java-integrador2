public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 50000, "Dakar", 5);

        System.out.println("Agregando vehiculos a la carrera...");
        carrera.darDeAltaAuto(300, 250.5, 95.6, "OGB789");
        carrera.darDeAltaAuto(320, 270.5, 85.6, "XDB702");
        carrera.darDeAltaAuto(290, 265.5, 97.6, "JQU962");
        carrera.darDeAltaMoto(250, 250, 50.2, "POL856");
        carrera.darDeAltaMoto(230, 250, 50.2, "LKI465");
        carrera.darDeAltaMoto(247, 230, 50.2, "TGU547");

        System.out.println();
        System.out.println("Lista de vehiculos: ");
        carrera.mostrarVehiculos();
        System.out.println();

        System.out.println("ELimino primer vehiculo insertado");
        carrera.eliminarVehiculoConPatente("OGB789");

        System.out.println();
        System.out.println("Lista de vehiculos: ");
        carrera.mostrarVehiculos();
        System.out.println();

        System.out.println("El vehiculo con mayor posibilidad de ganar la carrera es: " + carrera.ganadorDeLaCarrera().toString());
        System.out.println();

        System.out.println("Se socorren los vehiculos con patente XDB702 y LKI465: ");
        carrera.socorrerAuto("XDB702");
        carrera.socorrerMoto("LKI465");
    }
}
