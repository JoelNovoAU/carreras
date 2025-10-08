public class Main {
    public static void main(String[] args) {
        // Meta de la carrera (ajustable)
        int distanciaMeta = 600;

        // Lista de coches con nombre y velocidad máxima (original)
        Carrera[] coches = {
                new Carrera("Ferrari", distanciaMeta, 20),
                new Carrera("Lamborghini", distanciaMeta, 30),
                new Carrera("Tesla", distanciaMeta, 25),
                new Carrera("Ford", distanciaMeta, 15)
        };

        // Iniciar la carrera de cada coche
        for (Carrera coche : coches) {
            coche.start();
        }

        // Esperar a que todos los hilos terminen y finalizar programa cuando lo hagan
        for (Carrera coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mensaje final de conclusión
        System.out.println("---- TODOS LOS COCHES HAN COMPLETADO LA CARRERA ----");
    }
}

