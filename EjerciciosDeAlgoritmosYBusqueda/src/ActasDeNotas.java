import java.util.Scanner;
import java.text.DecimalFormat;

public class ActasDeNotas {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        int intentosMaximos = 3;
        boolean datosCorrectos = false;

        while (intentosMaximos > 0 && !datosCorrectos) { 
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
            String codigoCurso = lector.next();
            lector.nextLine();

            System.out.print("Grupo: ");
            String grupo = lector.next();
            lector.nextLine();

            System.out.print("Código de asignatura: ");
            String codigoAsignatura = lector.next();
            lector.nextLine();

            System.out.print("Código de programa de asignatura: ");
            String codigoProgramaAsignatura = lector.next();
            lector.nextLine();

            System.out.print("Cantidad de estudiantes: ");
            int cantidadEstudiantes = lector.nextInt();
            lector.nextLine();

            // Crear arreglos para almacenar la informacion de cada estudiante 
            //en cada campo que se nos impuso en el ejercicio 
            String[] carnetEstudiantes = new String[cantidadEstudiantes];
            String[] nombresApellidos = new String[cantidadEstudiantes];
            double[] primerParcial = new double[cantidadEstudiantes];
            double[] notaProyecto = new double[cantidadEstudiantes];
            double[] sistemáticos = new double[cantidadEstudiantes];
            double[] notaExamenPrimeraConvocatoria = new double[cantidadEstudiantes];
            double[] notaExamenSegundaConvocatoria = new double[cantidadEstudiantes];
            double[] notaFinal = new double[cantidadEstudiantes];
            boolean[] aprobado = new boolean[cantidadEstudiantes];
            boolean[] desercion = new boolean[cantidadEstudiantes];

            //se estaran almacenando los datos de cada estudiantes 
            //debido a los arreglos y los contadores
            for (int i = 0; i < cantidadEstudiantes; i++) {
                System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
                System.out.print("Número de carnet: ");
                carnetEstudiantes[i] = lector.next();
                lector.nextLine(); //limpiar buffer

                System.out.print("Nombres y Apellidos: ");
                nombresApellidos[i] = lector.nextLine();

                System.out.print("Primer parcial (máximo 35.00): ");
                primerParcial[i] = lector.nextDouble();

                System.out.print("Sistemáticos (máximo 30.00): ");
                sistemáticos[i] = lector.nextDouble();

                if (modalidad.equalsIgnoreCase("con proyecto")) {
                    System.out.print("Nota del Proyecto (máximo 35.00): ");
                    notaProyecto[i] = lector.nextDouble();
                } else {
                    System.out.print("Segundo parcial (máximo 35.00): ");
                    primerParcial[i] = lector.nextDouble();
                }

                notaFinal[i] = primerParcial[i] + sistemáticos[i] + notaProyecto[i];
                if (notaFinal[i] < 60.00) {
                    System.out.print("Examen de primera convocatoria (máximo 70.00): ");
                    notaExamenPrimeraConvocatoria[i] = lector.nextDouble();
                    notaFinal[i] = sistemáticos[i] + notaExamenPrimeraConvocatoria[i];
                    if (notaFinal[i] < 60.00) {
                        System.out.print("Examen de segunda convocatoria (máximo 100.00): ");
                        notaExamenSegundaConvocatoria[i] = lector.nextDouble();
                        notaFinal[i] = notaExamenSegundaConvocatoria[i];
                    }
                }

                aprobado[i] = notaFinal[i] >= 60.00;

                System.out.print("¿El estudiante desertó el curso? (S/N): ");
                String respuestaDesercion = lector.next();
                desercion[i] = respuestaDesercion.equalsIgnoreCase("S");
            }

            // Mostrar el acta de notas en orden alfabético por apellidos
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

            // Mostrar reporte de estadísticas
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

            // Preguntar al usuario si desea volver a utilizar la aplicación
            System.out.print("\n¿quiere volver a usar el programa? (S/N): ");
            String respuesta = lector.next();
            if ("N".equalsIgnoreCase(respuesta)) {
                System.out.println("Gracias por utilizar la aplicación. ¡Hasta luego!");
                datosCorrectos = true;
            } else {
                intentosMaximos--;
                if (intentosMaximos == 0) {
                    System.out.println("Se han agotado los intentos , a continuacion estara saliendo del programa.");
                }
            }
        }

        lector.close();
    }
}