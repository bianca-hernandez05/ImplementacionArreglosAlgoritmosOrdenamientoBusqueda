import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ActaDeNotas1{

    static int cantidadEstudiantes;
    static double notaBuscada;
    static DecimalFormat decimalFormat = new DecimalFormat("0.00");
    static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {

        boolean useApp = true;

        do {
             // Obtener información general del curso
             System.out.println("Ingrese los Datos Generales del curso:");
             System.out.print("Nombre del curso: ");
             String nombreCurso = lector.nextLine();
 
             System.out.print("Período lectivo: ");
             String periodoLectivo = lector.nextLine();
 
             System.out.print("Carrera: ");
             String carrera = lector.nextLine();
 
             System.out.print("Modalidad: ");
             String modalidad = lector.nextLine();
 
             System.out.print("Código del curso: ");
             String codigoCurso = lector.nextLine();
 
             System.out.print("Grupo: ");
             String grupo = lector.nextLine();
 
             System.out.print("Código de asignatura: ");
             String codigoAsignatura = lector.nextLine();
 
             System.out.print("Código de programa de asignatura: ");
             String codigoProgramaAsignatura = lector.nextLine();
 
             System.out.print("Cantidad de estudiantes: ");
             cantidadEstudiantes = lector.nextInt();
             lector.nextLine(); // Consumir el carácter de nueva línea
 
             // Matrices para almacenar la información de los estudiantes
             String[] carnetEstudiantes = new String[cantidadEstudiantes];
             String[] nombresApellidos = new String[cantidadEstudiantes];
             double[] primerParcial = new double[cantidadEstudiantes];
             double[] segundoParcial = new double[cantidadEstudiantes];
             double[] sistemáticos = new double[cantidadEstudiantes];
             double[] notaProyecto = new double[cantidadEstudiantes];
             double[] notaExamenPrimeraConvocatoria = new double[cantidadEstudiantes];
             double[] notaExamenSegundaConvocatoria = new double[cantidadEstudiantes];
             double[] notaFinal = new double[cantidadEstudiantes];
             double[] notaFinalConv1 = new double[cantidadEstudiantes];
             double[] notaFinalConv2 = new double[cantidadEstudiantes];
             boolean[] aprobado = new boolean[cantidadEstudiantes];
             boolean[] desercion = new boolean[cantidadEstudiantes];
 
             // Ingresar la información del estudiante
             for (int i = 0; i < cantidadEstudiantes; i++) {
                 System.out.println("\nIngrese los datos del estudiante " + (i + 1) + ":");
                 System.out.print("Número de carnet: ");
                 carnetEstudiantes[i] = lector.next();
                 lector.nextLine(); // Consumir el carácter de nueva línea
 
                 System.out.print("Nombres y Apellidos: ");
                 nombresApellidos[i] = lector.nextLine();
 
                 System.out.print("Primer parcial (máximo 35.00): ");
                 primerParcial[i] = lector.nextDouble();
 
                 System.out.print("Segundo parcial (máximo 35.00): ");
                 segundoParcial[i] = lector.nextDouble();
 
                 System.out.print("Sistemáticos (máximo 30.00): ");
                 sistemáticos[i] = lector.nextDouble();
 
                 if (modalidad.equalsIgnoreCase("con proyecto")) {
                     System.out.print("Nota del Proyecto (máximo 35.00): ");
                     notaProyecto[i] = lector.nextDouble();
                 } else {
                     System.out.print("Nota del Segundo Parcial (máximo 35.00): ");
                     segundoParcial[i] = lector.nextDouble();
                 }
 
                 notaFinal[i] = primerParcial[i] + segundoParcial[i] + sistemáticos[i] + notaProyecto[i];
 
                 if (notaFinal[i] < 60.00) {
                     System.out.print("Examen de primera convocatoria (máximo 70.00): ");
                     notaExamenPrimeraConvocatoria[i] = lector.nextDouble();
                     notaFinal[i] = sistemáticos[i] + notaExamenPrimeraConvocatoria[i];
                     notaFinalConv1[i] = notaFinal[i];
 
                     if (notaFinal[i] < 60.00) {
                         System.out.print("Examen de segunda convocatoria (máximo 100.00): ");
                         notaExamenSegundaConvocatoria[i] = lector.nextDouble();
                         notaFinal[i] = notaExamenSegundaConvocatoria[i];
                         notaFinalConv2[i] = notaFinal[i];
                     }
                 }
 
                 aprobado[i] = notaFinal[i] >= 60.00;
 
                 System.out.print("¿El estudiante desertó el curso? (S/N): ");
                 String respuestaDesercion = lector.next();
                 desercion[i] = respuestaDesercion.equalsIgnoreCase("S");
             }
 

            // Mostrar las actas de notas en orden alfabético por apellidos
            System.out.println("\nActa de Notas para el Curso: " + nombreCurso);
            System.out.println("Período lectivo: " + periodoLectivo);
            System.out.println("Carrera: " + carrera);
            System.out.println("Modalidad: " + modalidad);
            System.out.println("Código del curso: " + codigoCurso);
            System.out.println("Grupo: " + grupo);
            System.out.println("Código de asignatura: " + codigoAsignatura);
            System.out.println("Código de programa de asignatura: " + codigoProgramaAsignatura);
            System.out.println("Cantidad de estudiantes: " + cantidadEstudiantes);
            System.out.println();

            for (int i = 0; i < cantidadEstudiantes; i++) {
                System.out.println("Estudiante: " + nombresApellidos[i]);
                System.out.println("Número de carnet: " + carnetEstudiantes[i]);
                System.out.println("Nota Final: " + decimalFormat.format(notaFinal[i]));
                System.out.println("¿Aprobado? " + (aprobado[i] ? "Sí" : "No"));
                System.out.println("¿Deserción? " + (desercion[i] ? "Sí" : "No"));
                System.out.println();
            }

            // Calcular estadísticas
            int matriculaInicial = cantidadEstudiantes;
            int matriculaEfectiva = matriculaInicial;
            int deserciones = 0;
            int aprobados = 0;
            int reprobados = 0;
            double notaMinima = 100.00;
            double notaMaxima = 0.00;
            double sumaNotas = 0.00;

            for (int i = 0; i < cantidadEstudiantes; i++) {
                if (desercion[i]) {
                    matriculaEfectiva--;
                    deserciones++;
                } else {
                    if (aprobado[i]) {
                        aprobados++;
                    } else {
                        reprobados++;
                    }

                    sumaNotas += notaFinal[i];

                    if (notaFinal[i] < notaMinima) {
                        notaMinima = notaFinal[i];
                    }

                    if (notaFinal[i] > notaMaxima) {
                        notaMaxima = notaFinal[i];
                    }
                }
            }

            double porcentajeAprobados = (double) aprobados / matriculaEfectiva * 100.0;
            double porcentajeReprobados = (double) reprobados / matriculaEfectiva * 100.0;
            double promedioNotas = sumaNotas / matriculaEfectiva;

            // Mostrar informe de estadísticas
            System.out.println("\nReporte de Datos Estadísticos:");
            System.out.println("Matrícula inicial: " + matriculaInicial);
            System.out.println("Matrícula efectiva: " + matriculaEfectiva);
            System.out.println("Número de deserciones: " + deserciones);
            System.out.println("Cantidad de aprobados: " + aprobados);
            System.out.println("% de aprobados: " + decimalFormat.format(porcentajeAprobados) + "%");
            System.out.println("Cantidad de reprobados: " + reprobados);
            System.out.println("% de reprobados: " + decimalFormat.format(porcentajeReprobados) + "%");
            System.out.println("Nota mínima: " + decimalFormat.format(notaMinima));
            System.out.println("Nota máxima: " + decimalFormat.format(notaMaxima));
            System.out.println("Promedio de notas: " + decimalFormat.format(promedioNotas));

            // Menú con opciones adicionales
            int opcion;
            do {
                System.out.println("\nMenú de Acciones Adicionales:");
                System.out.println("1. Ordenar notas");
                System.out.println("2. Realizar búsqueda de notas");
                System.out.println("3. Mostrar y graficar rangos de notas");
                System.out.println("4. Volver al Menú Principal");
                System.out.print("Seleccione una opción (1-4): ");
                opcion = lector.nextInt();

                switch (opcion) {
                    case 1:
                        ordenarNotas(notaFinal, notaFinalConv1, notaFinalConv2);
                        break;
                    case 2:
                        buscarNotas(notaFinal, notaFinalConv1, notaFinalConv2, nombresApellidos, carnetEstudiantes);
                        break;
                    case 3:
                        mostrarRangosDeNotas(notaFinal);
                        break;
                    case 4:
                        break; // No hace nada, vuelve al menu principal
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 4.");
                }
            } while (opcion != 4);

            // Preguntar al usuario si desea volver a utilizar la aplicación
            System.out.print("\n¿Quiere volver a usar la aplicación? (S/N): ");
            String respuesta = lector.next();
            useApp = respuesta.equalsIgnoreCase("S");

        } while (useApp);

        System.out.println("Gracias por utilizar la aplicación. ¡Hasta luego!");
        lector.close();
    }

    // Metodos adicionales para el menu de opciones
    private static void ordenarNotas(double[] notas, double[] notaFinalConv1, double[] notaFinalConv2) {
        // Mostrar opciones de ordenamiento
        System.out.println("\nSeleccione una opción de ordenamiento:");
        System.out.println("1. Por nota final");
        System.out.println("2. Por nota final después de primera convocatoria");
        System.out.println("3. Por nota final después de segunda convocatoria");

        int opcion = lector.nextInt();

        switch (opcion) {
            case 1:
                Arrays.sort(notas); // Ordenar de forma ascendente
                System.out.println("\nNotas ordenadas:");
               for (double nota : notas) {
               System.out.print(nota + " ");
              }
                break;
            case 2:
                Arrays.sort(notaFinalConv1); // Lógica para ordenar ascendente por nota final después de primera convocatoria
                System.out.println("\nNotas ordenadas:");
               for (double nota : notaFinalConv1) {
               System.out.print(nota + " ");
              }
                break;
            case 3:
                Arrays.sort(notaFinalConv2);// Lógica para ordenar ascendente por nota final después de segunda convocatoria
                System.out.println("\nNotas ordenadas:");
               for (double nota: notaFinalConv2) {
               System.out.print(nota + " ");
              }
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
                return;
        }

    }

    private static void buscarNotas(double[] notas,double[] notaFinalConv1, double[] notaFinalConv2, String[] nombresApellidos,String[] carnetEstudiantes ) {
        // Mostrar opciones de busqueda
        System.out.println("\nSeleccione una opción de busqueda:");
        System.out.println("1. Por nota final");
        System.out.println("2. Por nota final después de primera convocatoria");
        System.out.println("3. Por nota final después de segunda convocatoria");

        int opcion = lector.nextInt();
         System.out.print("Ingrese la nota a buscar: ");
          double notaBuscada = lector.nextDouble();
          boolean encontrado = false;

        switch (opcion) {
            case 1:// busqueda por nota final
            for (int i = 0; i < notas.length; i++) {
                if (notas[i] == notaBuscada) {
                System.out.println("Estudiante: " + nombresApellidos[i]);
                System.out.println("Número de carnet: " + carnetEstudiantes[i]);
                System.out.println("Nota Final: " + decimalFormat.format(notas[i]));
                System.out.println();
              encontrado = true;
              }
             }

             if (!encontrado) {
                 System.out.println("No se encontraron estudiantes con nota igual a " + notaBuscada);
              }
                break;
            case 2:// busqueda por nota final después de primera convocatoria
                for (int i = 0; i < notaFinalConv1.length; i++) {
                if (notas[i] == notaBuscada) {
                System.out.println("Estudiante: " + nombresApellidos[i]);
                System.out.println("Número de carnet: " + carnetEstudiantes[i]);
                System.out.println("Nota Final: " + decimalFormat.format(notas[i]));
                System.out.println();
              encontrado = true;
              }
             }

             if (!encontrado) {
                 System.out.println("No se encontraron estudiantes con nota igual a " + notaBuscada);
              }
                break;
            case 3:// busqueda por nota final después de segunda convocatoria
                for (int i = 0; i < notaFinalConv2.length; i++) {
                if (notas[i] == notaBuscada) {
                System.out.println("Estudiante: " + nombresApellidos[i]);
                System.out.println("Número de carnet: " + carnetEstudiantes[i]);
                System.out.println("Nota Final: " + decimalFormat.format(notas[i]));
                System.out.println();
              encontrado = true;
              }
             }

             if (!encontrado) {
                 System.out.println("No se encontraron estudiantes con nota igual a " + notaBuscada);
              }
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
                return;
        }
    }

    private static void mostrarRangosDeNotas(double[] notas) {
        String reprobados = "";
        String aprobados_minimo = "";
        String aprobados_medio = "";
        String aprobados_pro = "";
        String aprobados_excelencia = "";

        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (notas[i] <= 59) {
                reprobados = reprobados + "*";
            } else if (notas[i] == 60 || notas[i] <= 69) {
                aprobados_minimo = aprobados_minimo + "*";
            } else if (notas[i] == 70 || notas[i] <= 79) {
                aprobados_medio = aprobados_medio + "*";
            } else if (notas[i] == 80 || notas[i] <= 89) {
                aprobados_pro = aprobados_pro + "*";
            } else if (notas[i] == 90 || notas[i] <= 100) {
                aprobados_excelencia = aprobados_excelencia + "*";
            }
        }
        int indice_2 = 1;

        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.print("Nota_" + indice_2 + ": " + notas[i] + "  ");
            indice_2++;
        }

        System.out.println("");

        System.out.println("Reprobados: " + reprobados);
        System.out.println("Aprobados con la nota minima: " + aprobados_minimo);
        System.out.println("Aprobados con una nota regular: " + aprobados_medio);
        System.out.println("Aprobados con una nota buena: " + aprobados_pro);
        System.out.println("Aprobados con una nota excelente: " + aprobados_excelencia);
        
    }
}