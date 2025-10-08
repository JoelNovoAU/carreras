public class Carrera extends Thread {
    String nombre;
    int distanciaRecorrida;
    int distanciaMeta;
    int velocidadMaxima;

    public Carrera(String nombre, int distanciaMeta, int velocidadMaxima) {
        this.nombre = nombre;
        this.distanciaMeta = distanciaMeta;
        this.distanciaRecorrida = 0;
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public void run() {
        System.out.println(nombre + " ha comenzado la carrera.");

        while (distanciaRecorrida < distanciaMeta) {
            try {
                // Velocidad máxima aleatoria para este paso (hasta la velocidad máxima original del coche)
                int maxAvanceAleatorio = (int) (Math.random() * velocidadMaxima);

                // Avance real aleatorio entre 0 y la velocidad máxima aleatoriamente generada
                int avance = (int) (Math.random() * maxAvanceAleatorio);

                distanciaRecorrida += avance;

                // Pausa aleatoria para mayor variedad en la simulación (200 a 800 ms)
                int tiempo = (int) (Math.random() * 600) + 200;
                Thread.sleep(tiempo);

                // Mensaje parcial de progreso (solo cada vez que hay avance >= 5 metros)
                if (avance >= 5) {
                    System.out.println(nombre + ": " + distanciaRecorrida + " metros.");
                }

            } catch (InterruptedException e) {
                System.out.println(nombre + " interrumpido inesperadamente.");
                e.printStackTrace();
            }
        }

        // Mensaje de llegada a meta
        System.out.println("---- " + nombre + " HA LLEGADO A LA META. DISTANCIA RECORRIDA: " +
                distanciaRecorrida + " METROS ----");
    }
}

