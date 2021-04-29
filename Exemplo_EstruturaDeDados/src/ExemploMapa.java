import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ExemploMapa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String> mapa = new HashMap<String, String>();

		for (int i = 0; i < 3; i++) {
			System.out.print("Informe o CPF: ");
			String cpf = scanner.nextLine();
			System.out.print("Informe o nome: ");
			String nome = scanner.nextLine();

			mapa.put(cpf, nome);
		}

		System.out.println(mapa);

		System.out.print("Informe um CPF para busca: ");
		String cpfBusca = scanner.nextLine();
		String nomeClienteBuscado = mapa.get(cpfBusca);
		if (nomeClienteBuscado != null)
			System.out.println("Encontramos o cliente " + nomeClienteBuscado + ", para o CPF " + cpfBusca);
		else
			System.out.println("Nenhum cliente encontrado com o CPF "+cpfBusca);
		
		System.out.print("Informe um CPF para remoção: ");
		String cpfRemocao = scanner.nextLine();
		mapa.remove(cpfRemocao);
		
		System.out.println(mapa);

		scanner.close();
	}

}
