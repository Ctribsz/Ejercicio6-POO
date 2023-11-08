import java.util.List;
import java.util.Scanner;

class TicketA implements Ticket{

    @Override
    public void Total(String pr, List<String[]> campos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de horas trabajadas entre semana.");
        int ht = sc.nextInt();

        System.out.println("Ingrese la cantidad de horas trabajadas en fin de semana");
        int ht2 = sc.nextInt();
        
        int calc = ht + ht2;
        double calc2 = (calc * 8) + (ht * 8 * 0.05) + (ht2 * 8 * 0.2);
        int cl = (int) Math.round(calc2);
        campos.add(new String[]{pr,Integer.toString(calc),Integer.toString(cl)});
    }

}
