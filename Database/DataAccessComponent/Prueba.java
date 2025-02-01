package DataAccessComponent;

public class Prueba {
    public static void main(String[] args) {
        try {
            System.out.println("Intentando conectar...");
            SQLServerDataHelper.openConnection();
            System.out.println("¡Conexión exitosa!");
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}