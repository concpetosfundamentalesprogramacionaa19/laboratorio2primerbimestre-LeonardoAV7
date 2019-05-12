/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author Leonardo Aguilar
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos las variables que utilizaremos
        String nombre;
        double sueldo;
        int hijos;
        double pasajes;
        double bar;
        double salidas;
        boolean bandera = true;
        int i = 1;
        int j = 1;
        String mensajeFinal = "";
        String opcion;
        double totalPasajes = 0;
        double totalBar = 0;
        double totalSalidas= 0;
        double total;
        String texto1;
        
        Scanner entrada = new Scanner(System.in);
        // empezamos a acumular el mensaje final
        mensajeFinal = String.format("%s%s\n\n", mensajeFinal,
                "Reporte Gastos de Padres de Familia");
        
        
        while (bandera == true){ // el ciclo se repetira mientras bandera
                                 // sea verdadero                      
            // solicitamos datos por teclado                     
            System.out.println("Ingrese los nombres y apellidos del padre de"
                    + " familia: ");
            nombre = entrada.nextLine();
            System.out.println("Ingrese el sueldo semanal del padre de"
                    + " familia:");
            sueldo = entrada.nextDouble();
            System.out.println("Ingrese el numero de hijos del padre de"
                    + " familia:");
            hijos = entrada.nextInt();
            // seguimos acumulando el mensaje final con los datos ingresados
            mensajeFinal = String.format("%s%s%d \n\nNombre de Padre de"
                    + " familia: %s \nSueldo Semanal: $%.2f \nNúmero de hijos:"
                    + " %d\n\nReporte de Gastos \nPersona\t\tPasaje\t\tBar"
                    + "\t\tSalidas\n", mensajeFinal, "Reporte ", i, nombre,
                    sueldo, hijos);
            
            while (j <= hijos){ // el ciclo se repetira tantos hijos tenga
                // se solicitan los datos de los gastos de cada hijo
                System.out.println("Ingrese el gasto semanal en pasajes del"
                        + " hijo "+ j + ": ");
                pasajes = entrada.nextDouble();
                System.out.println("Ingrese el gasto semanal en bares del hijo"
                        + " "+ j + ": ");
                bar = entrada.nextDouble();
                System.out.println("Ingrese el el gasto semanal en salidas "
                        + "del hijo "+ j + ": ");
                salidas = entrada.nextDouble();
                // se acumula el gasto de cada parametreo 
                totalPasajes = totalPasajes + pasajes;
                totalBar = totalBar + bar;
                totalSalidas = totalSalidas + salidas;
                // seguimos acumulando el mensaje final
                mensajeFinal = String.format("%sHijo %d\t\t%.2f\t\t%.2f\t\t"
                        + "%.2f\n", mensajeFinal, j, pasajes, bar, salidas);
                
                j = j + 1; // aumentamos nuestro contador 
            }
            // sacamos el total que gastan todos los hijos
            total = totalPasajes + totalBar + totalSalidas;
            
            if (sueldo > total){ // determinamos si su sueldo le alcanza o no
                texto1 = "alcanza";
            }else{
                texto1 = "falta";
            }
            // terminamos de acumular el mensaje final con los demas datos
            mensajeFinal = String.format("%sTotales\t\t%.2f\t\t%.2f\t\t%.2f"
                    + " \nEl padre de familia %s le %s el dinero semanal,"
                    + " para sus gastos \n\nFin del Reporte %d\n\n",
                    mensajeFinal, totalPasajes, totalBar, totalSalidas, nombre,
                    texto1, i);
            
            i = i +1; // usamos este contador para ver en que reporte estamos 
            // reiniciamos las variables que lo neceitan para volverlas a usar
            j = 1;
            totalPasajes = 0;
            totalBar = 0;
            totalSalidas = 0;
            entrada.nextLine();
            // determinamos si desea seguir ingresando mas reportes
            System.out.println("Digite 'n' para terminar el ingreso de"
                    + " informacion o cualquier otra tecla para continuar : ");
            opcion = entrada.nextLine();
            if (opcion.equals("n")){ 
                bandera = false; // con la bandera falsa, saldra del ciclo
            }
        }
        // mostramos el resultado final
        System.out.printf("%s", mensajeFinal);
        
    }
    
}
