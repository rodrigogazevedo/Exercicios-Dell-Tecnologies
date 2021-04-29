import java.util.Scanner;
 
public class TesteScanner {
    public static void main(String[] args) {

        /* Criação de um objeto da classe Scanner */
        Scanner entradaTeclado = new Scanner(System.in);
        
        System.out.print("Digite um texto qualquer: ");
        /* Captura do que foi digitado pelo usuário */
        String t1 = entradaTeclado.nextLine();
        System.out.println("Seu texto foi: " + t1);
         
        /* Finalizando o processo de entrada de dados */
        entradaTeclado.close();
    }
}