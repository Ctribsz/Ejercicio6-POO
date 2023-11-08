import java.util.List;
import java.util.Scanner;

class TicketC implements Ticket {

    @Override
    public void Total(String pr, List<String[]> campos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de horas trabajadas: ");
        int ht = sc.nextInt();

        campos.add(new String[]{pr,Integer.toString(ht),Integer.toString(ht * 10)});
    }
    
}
