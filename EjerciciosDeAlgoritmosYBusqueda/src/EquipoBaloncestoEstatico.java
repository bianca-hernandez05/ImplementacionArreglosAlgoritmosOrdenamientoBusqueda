public class EquipoBaloncestoEstatico {

    public static void main(String[] args){
        

        String[] nombres = {"Josué Mojica", "Hollman Vargas", "Fernando Mendoza", "Juan Martínez", "Neffer Cano"};
        int[] estaturas = {185, 192, 188, 196, 205};
        int[] velocidades = {31, 28, 30, 33, 15};
        int[] alcances = {102, 110, 100, 98, 40};
        int[] pesos = {86, 90, 85, 100, 120};
        int[] envergaduras = {192, 192, 195, 210, 211};

        // 1. Listado de los nombres de los jugadores ordenados por velocidad 
        quicksortPorVelocidad(nombres, velocidades, 0, nombres.length - 1);

        System.out.println("Listado de jugadores ordenados por velocidad:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " - Velocidad: " + velocidades[i] + " km/h");
        }
        System.out.println();

        // 5. Ordenar y listar jugadores por índice de masa corporal (IMC) (Quicksort)
        quicksortPorIMC(nombres, pesos, estaturas, 0, nombres.length - 1);

        System.out.println("Listado de jugadores ordenados por IMC:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " - IMC: " + calcularIMC(pesos[i], estaturas[i]));
        }

    }

    // Método Quicksort para ordenar por velocidad
    private static void quicksortPorVelocidad(String[] nombres, int[] velocidades, int inicio, int fin){
        if (inicio < fin) {
            int pivote = particionPorVelocidad(nombres, velocidades, inicio, fin);
            quicksortPorVelocidad(nombres, velocidades, inicio, pivote - 1);
            quicksortPorVelocidad(nombres, velocidades, pivote + 1, fin);
        }
    }

    private static int particionPorVelocidad(String[] nombres, int[] velocidades, int inicio, int fin){
        int pivote = velocidades[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++){
            if (velocidades[j] >= pivote){
                i++;
                intercambiar(nombres, i, j);
                intercambiar(velocidades, i, j);
            }
        }

        intercambiar(nombres, i + 1, fin);
        intercambiar(velocidades, i + 1, fin);

        return i + 1;
    }

    // Método Quicksort para ordenar por IMC
    private static void quicksortPorIMC(String[] nombres, int[] pesos, int[] estaturas, int inicio, int fin) {
        if (inicio < fin) {
            int pivote = particionPorIMC(nombres, pesos, estaturas, inicio, fin);
            quicksortPorIMC(nombres, pesos, estaturas, inicio, pivote - 1);
            quicksortPorIMC(nombres, pesos, estaturas, pivote + 1, fin);
        }
    }

    private static int particionPorIMC(String[] nombres, int[] pesos, int[] estaturas, int inicio, int fin) {
        double pivote = calcularIMC(pesos[fin], estaturas[fin]);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (calcularIMC(pesos[j], estaturas[j]) <= pivote){
                i++;
                intercambiar(nombres, i, j);
                intercambiar(pesos, i, j);
                intercambiar(estaturas, i, j);
            }
        }

        intercambiar(nombres, i + 1, fin);
        intercambiar(pesos, i + 1, fin);
        intercambiar(estaturas, i + 1, fin);

        return i + 1;
    }

    private static void intercambiar(String[] array, int i, int j){
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void intercambiar(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static double calcularIMC(int peso, int estatura){
        double estaturaMetros = estatura / 100.0;
        return peso / (estaturaMetros * estaturaMetros);
    }
}