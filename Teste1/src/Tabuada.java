import java.util.*;

public class Tabuada {

    public static void main(String argumento[]) {
        int num = 0;

        Scanner leitura = new Scanner(System.in);

        do {
            System.out.print("\n Entre com um numero: ");
            try {
                num = leitura.nextInt();
                if (num < 0 || num > 10) {
                    System.out.println("\n\n\n Digite um numero valido!");
                } else if (num != 0) {
                    System.out.print("\n");
                    for (int x = 1; x <= 10; x++) {
                        System.out.println(" " + num + " x " + x + " = " + num * x);
                    }
                }
            }catch(InputMismatchException e){  
                System.out.println("\n\n\n   A T E N C A O\n\n Digite somente numeros!");
				leitura.nextLine();
            }
        } while (num != 0);
        
        leitura.close();
    }
    
}