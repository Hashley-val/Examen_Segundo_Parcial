import java.util.Scanner;

public class Calificaciones1
{

    static int totalRegistrados = 0;
    static int totalAprobados = 0;
    static int totalReprobados = 0;
    static double sumaPromedios = 0;

    public static void main(String[] args)
    {
        int opc = 0;
        while (opc != 3)
        {
            opc = menuPrincipal();
            switch (opc)
            {
                case 1:
                    registrarCalificaciones();
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("No es una opción");
                    break;
            }
        }
        System.out.println("Salír");
    }

    private static int menuPrincipal()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("     CONTROL DE CALIFICACIONES");
        System.out.println("=====================================");
        System.out.println("1. Registrar calificaciones");
        System.out.println("2. Mostrar estadísticas");
        System.out.println("3. Salir");
        System.out.println("=====================================");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    private static void registrarCalificaciones()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("        REGISTRAR ESTUDIANTE         ");
        System.out.println("=====================================");
        System.out.print("¿Cuántos estudiantes registrará?: ");
        int nEstudiantes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= nEstudiantes; i++)
        {
            System.out.println("-------------------------------------");
            System.out.println("Estudiante " + i);
            System.out.println("-------------------------------------");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Evaluación 1: ");
            double eval1 = scanner.nextDouble();

            System.out.print("Evaluación 2: ");
            double eval2 = scanner.nextDouble();

            System.out.print("Evaluación 3: ");
            double eval3 = scanner.nextDouble();
            scanner.nextLine();

            double promedio = (eval1 + eval2 + eval3) / 3.0;

            String resultado;
            if (promedio >= 6.0)
            {
                resultado = "APROBADO";
                totalAprobados++;
            } else
            {
                resultado = "REPROBADO";
                totalReprobados++;
            }

            totalRegistrados++;
            sumaPromedios += promedio;

            System.out.printf("Promedio: %.2f", promedio);
            System.out.println("Resultado: " + resultado);
        }
        System.out.println("-------------------------------------");
    }

    private static void mostrarEstadisticas()
    {
        System.out.println("=====================================");
        System.out.println("      ESTADÍSTICAS DEL GRUPO");
        System.out.println("=====================================");
        System.out.println("Estudiantes registrados: " + totalRegistrados);
        System.out.println("Estudiantes aprobados: " + totalAprobados);
        System.out.println("Estudiantes reprobados: " + totalReprobados);

        double promedioGeneral = 0;
        if (totalRegistrados > 0)
        {
            promedioGeneral = sumaPromedios / totalRegistrados;
        }
        System.out.printf("Promedio general: %.2f\n", promedioGeneral);
        System.out.println("=====================================");
    }
}