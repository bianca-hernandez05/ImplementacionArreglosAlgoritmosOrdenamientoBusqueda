import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.InputMismatchException;

public class hojaDeMatricula {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Este programa se creó con el fin de realizar una hoja de matricula");
        System.out.println("Se le pedirán los siguientes datos a continuacion:\nNumero de inscripcion\n" + //
                "• Nombres y apellidos\n" + //
                "• Numero de carnet\n" + //
                "• Carrera\n" + //
                "• Turno\n" + //
                "• Plan de estudio\n" + //
                "• Semestre\n" + //
                "• Fecha de matricula");

        Date fechaActual = new Date();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        String fechaFormateada = formatoFecha.format(fechaActual);

        double numeroInscripcion = Math.abs(Math.random());
        double carnet = Math.abs(Math.random());

        System.out.println("Cuales son sus nombres y apellidos");
        String nombre = leer.nextLine();

        System.out.println("En que recinto se encuentra? 1-RUPAP o 2-RUSB");
        String carrera = null;

       
        System.out.println("Cual es su carrera?");
        carrera = leer.nextLine();
        if(carrera.equalsIgnoreCase("Sistemas") || carrera.equalsIgnoreCase("Agricola") || carrera.equalsIgnoreCase("Industrial") || carrera.equalsIgnoreCase("Civil") || carrera.equalsIgnoreCase("Mecanica") || carrera.equalsIgnoreCase("Computacion") || carrera.equalsIgnoreCase("Elcetronica") || carrera.equalsIgnoreCase("Arquitectura") || carrera.equalsIgnoreCase("Quimica") || carrera.equalsIgnoreCase("Elcetrica")){
                System.out.println("");
        }else{
            System.out.println("Debe de escoger una carrera que se encuentre en la UNI");
        }
        System.out.println("Cual es su turno? (Diurno o Nocturno)");
        String turno = leer.nextLine();
        if(turno!="Diurno" || turno!="diurno" || turno!="Nocturno" || turno!="nocturno"){
            
        }else{
                System.out.println("Escriba una opcion correcta");
        }

        int semestre = 0;
        System.out.println("En que semestre se encuentra '1 al 10'");
        try {
        semestre = leer.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese correctamente los valores");
        }
        if (semestre > 0 || semestre < 11) {
            System.out.println("El semestre seleccionado es: " + semestre);
        } else {
           System.out.println("Elige una opción que se encuentre entre 1 y 10.");
        }

        int asignatura=0;
        try {
            
        
        System.out.println("Cuantas asignaturas desea inscribir");
        asignatura = leer.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese correctamente los valores");
        }

        if (asignatura > 0 && asignatura <= 7) {
            System.out.println("Las asignaturas inscritas son: " + asignatura);

            String nombres[] = new String[asignatura];
            int credito1[] = new int[asignatura];
            int sumaCreditos = 0;
            String retiroAsignatura[] = new String[asignatura]; 


            for (int i = 0; i < asignatura; i++) {
                leer.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Ingrese el nombre de la asignatura " + (i + 1));
                nombres[i] = leer.nextLine();

                System.out.println("Ingrese los creditos de la asignatura " + (i + 1));
                credito1[i] = credito(credito1);
                

                System.out.println("Desea retirar la asignatura? (Si o No)");
                retiroAsignatura[i]=leer.nextLine();

                sumaCreditos += credito1[i];
            }

            // Ordenar alfabéticamente los nombres de las asignaturas usando QuickSort
            quickSort(nombres, 0, nombres.length - 1);

            System.out.println("La suma de creditos de las asignaturas es: " + sumaCreditos);

            if (sumaCreditos > 28) {
                System.out.println("La suma de los creditos no puede ser mayor a 28 créditos");
            }

            System.out.println(nombre);
            System.out.println(carrera);
            System.out.println("Su carnet es : " + carnet);
            System.out.println("Su numero de inscripcion es : " + numeroInscripcion);
            System.out.println("Plan de estudio : 2015");
            System.out.println("Semestre : " + semestre);
            System.out.println("Turno : " + turno);
            System.out.println("Fecha : " + fechaFormateada);

            System.out.println("Nombres de asignaturas después de ordenar:");
            
            for (int i = 0; i < asignatura; i++) {
                System.out.println("Asignatura: " + nombres[i] + ", Creditos: " + credito1[i] + ", Retiro de asignatura: " + retiroAsignatura[i]);
            }
        } else {
            System.out.println("El numero de asignaturas debe estar entre 1 y 7");
        }
    }

    // Métodos de ordenamiento QuickSort
    private static void quickSort(String[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(array, inicio, fin);
            quickSort(array, inicio, indiceParticion - 1);
            quickSort(array, indiceParticion + 1, fin);
        }
    }

    private static int particion(String[] array, int inicio, int fin) {
        String pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j].compareToIgnoreCase(pivote) <= 0) {
                i++;
                intercambiar(array, i, j);
            }
        }

        intercambiar(array, i + 1, fin);
        return i + 1;
    }

    private static void intercambiar(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static int credito(int creditos[]){

        int numero=0;

        numero = leer.nextInt();
        if(numero >0 && numero<5){
            return numero;
        }else{
            System.out.println("Debe de ingresar un numero que se encuentre entre 1 a 4");
        }
        return numero;
    }
}