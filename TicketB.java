import java.util.List;
import java.util.Scanner;

class TicketB implements Ticket {

    @Override
    public void Total(String pr, List<String[]> campos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantida de horas trabajadas: ");
        int ht = sc.nextInt();

        double calc =  (ht * 10) + (ht * 0.8);
        int cl = (int) Math.round(calc);
        campos.add(new String[]{pr,Integer.toString(ht),Integer.toString(cl)});
    }

}
