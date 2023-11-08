import java.io.BufferedReader;
import java.io.FileReader;
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
}
