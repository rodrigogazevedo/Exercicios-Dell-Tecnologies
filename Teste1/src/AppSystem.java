import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
  
public class AppSystem {
  
  public static void main(String... args) 
   throws FileNotFoundException {
  
     try {
             InputStream input = new FileInputStream("/tmp/dados.txt");
               System.out.println("Aberto arquivo...");
           } catch (IOException e) {
               System.err.println("Falha ao tentar abrir o arquivo:");
                e.printStackTrace();
           }
  
  }
  
}