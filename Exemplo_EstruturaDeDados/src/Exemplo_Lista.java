import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exemplo_Lista {

	public static void main(String[] args) {
		List<String> listaDeClientes = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.print("Digite o nome: ");
			String nome = scanner.nextLine();
			listaDeClientes.add(nome);
		}
		
		System.out.println(listaDeClientes);
		
		System.out.println("Informe o nome a ser removido: ");
		String nome = scanner.nextLine();
		listaDeClientes.remove(nome);
		System.out.println(listaDeClientes);
		
		for(String n: listaDeClientes) {
			System.out.println("Nome do cliente: "+n);
		}

		scanner.close();
	}
}
