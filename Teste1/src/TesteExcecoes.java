import java.util.InputMismatchException;
import java.util.Scanner;
public class TesteExcecoes {
	public static void main(String[] args) {

		try {
			System.out.println("Informe um número.");
			int numero = lerTeclado();
			System.out.println("O número foi " + numero);
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido.");
		}
	}

	public static int lerTeclado() throws InputMismatchException {
		Scanner s = new Scanner(System.in);
		return Integer.parseInt(s.nextLine());
	}
}