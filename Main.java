import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Gestor g = new Gestor();
        List<String[]> campos = g.leerArchivo("tickets.csv");
        while (true) {
            System.out.println("______________MENU____________");
            System.out.println("1. Imprimir tickets actuales");
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
                    Ticket t;
                    System.out.println("Ingrese la prioridad del ticket (Baja, Media o Alta): ");
                    String pr = sc.nextLine();
                    
                    if (pr.equals("Alta")){
                        t = new TicketA();

                       t.Total(pr, campos);
                    } else if (pr.equals("Media")){
                        t = new TicketB();

                        t.Total(pr, campos);
                    } else if (pr.equals("Baja")) {
                        t = new TicketC();
                        t.Total(pr, campos);
                    }
                
                    break;
                    
                case 3:
                    g.reporte(campos);
                    break;

                case 4:
                    g.guardarCSV(campos, "tickets.csv");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            
        }
        
    }
}
