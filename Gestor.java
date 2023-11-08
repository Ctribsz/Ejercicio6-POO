import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Gestor {
    public static List<String[]> leerArchivo(String nombreArchivo) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));

        String linea;
        List<String[]> campos = new ArrayList<>();
        while ((linea = reader.readLine()) != null) {
            String[] camposActuales = linea.split(",");

            campos.add(camposActuales);
        }
        reader.close();

        return campos;
    }
    
    public static void imprimir(List<String[]> campos) {
        // Imprimir los encabezados
        System.out.println("|  Tipo de prioridad  |   Horas   |   Total   |");
        // Imprimir los campos
        for (String[] campo : campos) {
            // Imprimir los campos en una línea
            System.out.println("|           " + String.join("      |    ", campo) + "     |     ");
        }
    }

    public static void guardarCSV(List<String[]> campos, String nombreArchivo) throws IOException {
        FileWriter writer = new FileWriter(nombreArchivo);
    
        for (String[] camposActuales : campos) {
            for (String campo : camposActuales) {
                writer.write(campo);
                writer.write(",");
            }
            writer.write("\n");
        }
    
        writer.close();
    }

    public static void reporte(List<String[]> campos){
        double t1 = 0;
        double t2 = 0;
        double t3 = 0;
        
        for (int i = 0; i < campos.size(); i++) {
            String campo2 = campos.get(i)[0];
            if(campo2.equals("Alta")){
                t1 = t1 + Integer.parseInt(campos.get(i)[2]);
            } else if(campo2.equals("Media")){
                t2 = t2 + Integer.parseInt(campos.get(i)[2]);
            } else if(campo2.equals("Baja")){
                t3 = t3 + Integer.parseInt(campos.get(i)[2]);
            }
        }
        

        double mayor = mayor(t1, t2, t3);

        if( mayor == t1 ){
            System.out.println("\u001B[31mLa prioridad que esta generando mayor gananacia es Alta con : " + t1 + "\u001B[0m");
            System.out.println("El total de ganancias de tickets de prioridad Media es: " + t2);
            System.out.println("El total de ganancias de tickets de prioridad Baja es: " + t3);
        } else if (mayor  == t2){
            System.out.println("\u001B[31mLa prioridad que esta generando mayor gananacia es Media con : " + t2 + "\u001B[0m");
            System.out.println("El total de ganancias de tickets de prioridad Alta es: " + t1);
            System.out.println("El total de ganancias de tickets de prioridad Baja es: " + t3);
        } else {
            System.out.println("\u001B[31mLa prioridad que esta generando mayor gananacia es Baja con : " + t3 + "\u001B[0m");
            System.out.println("El total de ganancias de tickets de prioridad Media es: " + t2);
            System.out.println("El total de ganancias de tickets de prioridad Alta es: " + t1);
        }
    }

    public static double mayor(double n1, double n2, double n3) {
        double mayor = n1;
    
        if (n2 > mayor) {
            mayor = n2;
        }
    
        if (n3 > mayor) {
            mayor = n3;
        }
    
        return mayor;
    }
}
