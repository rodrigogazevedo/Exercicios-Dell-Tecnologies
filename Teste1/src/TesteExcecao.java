
public class TesteExcecao {

	public static void main(String[] args) {

		String []a = new String[2];
		
		a[0] = "Projeto";
		a[1] = "Le@d";
		
		try {
			System.out.println("O valor da posição 5 do vetor é: ");
			System.out.println(a[5]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Houve um erro ao acessar o vetor."+e.getMessage());
		}finally {
			System.out.println("O bloco finally sempre será executado.");
		}
	}

}
