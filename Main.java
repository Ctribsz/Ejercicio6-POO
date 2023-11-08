import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Gestor g = new Gestor();
        List<String[]> campos = g.leerArchivo("tickets.csv");

        while (true) {
            System.out.println("______________MENU____________");
            System.out.println("1. Imprimir tickets guardados");
            System.out.println("2. Hacer nuevo aporte de ticket");
            System.out.println("3. Generar informe");
            System.out.println("4. Salir");
            Scanner sc = new Scanner(System.in);  
            System.out.println("Elige la accion que quieras realizar: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    g.imprimir(campos);
                    break;
                    
                case 2:
                    
                    break;
                
                case 3:

                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            
        }
        
    }
}
