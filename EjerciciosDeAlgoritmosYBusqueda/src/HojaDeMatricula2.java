import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

// esta es otra opcion de Hoja de Matricula con valores predeterminados o preguardados
public class HojaDeMatricula2 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //Datos preguardados , el nombre de la carrera y el plan de estudio
        String carrera = "Ingeniería de Sistemas";
        String planEstudio = "2015";

        int intentosMaximos = 3;
        boolean datosCorrectos = false;

        while (intentosMaximos > 0 && !datosCorrectos) {

            System.out.println("Ingrese la información del estudiante:");
            System.out.print("Número de recibo: ");
            int numRecibo = scanner.nextInt();
            scanner.nextLine(); // utilizamos salto de linea para Limpiar el buffer

            System.out.print("Número de inscripción: ");
            int numInscripcion = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombres y apellidos: ");
            String nombresApellidos = scanner.nextLine();

            System.out.print("Número de carnet: ");
            String numCarnet = scanner.next();
            scanner.nextLine();

            System.out.print("Turno: ");
            String turno = scanner.next();
            scanner.nextLine();

            System.out.print("Semestre: ");
            int semestre = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Fecha de matrícula (yyyy-MM-dd): ");
            Date fechaMatricula = null;
            try {
                fechaMatricula = dateFormat.parse(scanner.next());
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
                continue;
            }
            scanner.nextLine();

            System.out.println("Ingrese la información de las asignaturas:");

            int maximoAsignaturas = 7;
            int maximoCreditosPorAsignatura = 4;
            int maximoCreditosTotales = 28;
            int maximoFrecuenciaInscripcion = 3;

            int totalCreditos = 0;
            String[] asignaturas = new String[maximoAsignaturas];
            int[] creditos = new int[maximoAsignaturas];

            for (int i = 0; i < maximoAsignaturas; i++) {
                System.out.print("Código de asignatura " + (i + 1) + ": ");
                String codigoAsignatura = scanner.next();
                scanner.nextLine();

                System.out.print("Nombre de la asignatura " + (i + 1) + ": ");
                String nombreAsignatura = scanner.nextLine();

                System.out.print("Grupo y aula " + (i + 1) + ": ");
                String grupoAula = scanner.nextLine();

                System.out.print("Cantidad de créditos de la asignatura " + (i + 1) + ": ");
                int creditosAsignatura = scanner.nextInt();
                scanner.nextLine();

                if (creditosAsignatura > maximoCreditosPorAsignatura) {
                    System.out.println("La cantidad de créditos por asignatura no puede ser mayor que " + maximoCreditosPorAsignatura + ".");
                    break;
                }

                System.out.print("Frecuencia de inscripción de la asignatura " + (i + 1) + ": ");
                int frecuenciaInscripcion = scanner.nextInt();
                scanner.nextLine();

                if (frecuenciaInscripcion > maximoFrecuenciaInscripcion) {
                    System.out.println("La frecuencia de inscripción de la asignatura no puede ser mayor que " + maximoFrecuenciaInscripcion + ".");
                    break;
                }

                if (totalCreditos + creditosAsignatura > maximoCreditosTotales) {
                    System.out.println("La suma total de créditos no puede ser mayor que " + maximoCreditosTotales + ".");
                    break;
                }

                asignaturas[i] = codigoAsignatura + " - " + nombreAsignatura + " (Grupo " + grupoAula + ")";
                creditos[i] = creditosAsignatura;
                totalCreditos += creditosAsignatura;

                System.out.print("¿Desea retirar esta asignatura? (S/N): ");
                String retirarAsignatura = scanner.next();
                scanner.nextLine();
                if ("S".equalsIgnoreCase(retirarAsignatura)) {
                    asignaturas[i] = null;
                    creditos[i] = 0;
                }
            }

            String[] asignaturasFiltradas = Arrays.stream(asignaturas)
                    .filter(s -> s != null)
                    .toArray(String[]::new);

            if (asignaturasFiltradas.length == 0) {
                System.out.println("No se ha inscrito en ninguna asignatura. Inténtelo de nuevo.");
                continue;
            }

            Date fechaActual = new Date();
            System.out.println("\nReporte de Matrícula");
            System.out.println("Fecha de impresión: " + dateFormat.format(fechaActual));
            System.out.println("Carrera: " + carrera);
            System.out.println("Plan de estudio: " + planEstudio);
            System.out.println("Número de recibo: " + numRecibo);
            System.out.println("Número de inscripción: " + numInscripcion);
            System.out.println("Nombres y apellidos: " + nombresApellidos);
            System.out.println("Número de carnet: " + numCarnet);
            System.out.println("Turno: " + turno);
            System.out.println("Semestre: " + semestre);
            System.out.println("Fecha de matrícula: " + dateFormat.format(fechaMatricula));
            System.out.println("Asignaturas inscritas:");
            Arrays.sort(asignaturasFiltradas);
            for (int i = 0; i < asignaturasFiltradas.length; i++) {
                System.out.println(asignaturasFiltradas[i] + " - Créditos: " + creditos[i]);
            }

            datosCorrectos = true;
        }

        if (!datosCorrectos) {
            System.out.println("Se han agotado Todos sus intentos .");
        } else {
            System.out.print("¿Quiere crear otra Hoja de matricula ? (S/N): ");
            String respuesta = scanner.next();
            if ("N".equalsIgnoreCase(respuesta)) {
                System.out.println("Gracias por utilizar la aplicación. ¡Hasta luego!");
            } else {
                //retornar al main
                main(args);
            }
        }

        scanner.close();
    }
       
    }