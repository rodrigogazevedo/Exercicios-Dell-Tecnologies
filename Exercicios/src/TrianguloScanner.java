import java.util.Scanner;

public class TrianguloScanner {
	public static void main(String[] args) {
		/* Cria��o de um objeto da classe Scanner */
		Scanner entradaTeclado = new Scanner(System.in);
		
		/* Captura os tr�s lados do tri�ngulo digitado no console pelo usu�rio */
		System.out.println("Digite o primeiro lado do tri�ngulo");
		float lado1 = entradaTeclado.nextFloat();
		System.out.println("Digite o segundo lado do tri�ngulo");
		float lado2 = entradaTeclado.nextFloat();
		System.out.println("Digite o terceiro lado do tri�ngulo");
		float lado3 = entradaTeclado.nextFloat();
		
		/* Verifica se os lados informados formam um tri�ngulo */
		if (lado1<lado2+lado3 && lado2<lado1+lado3 && lado3<lado1+lado2) {
			
			/* Verifica se todos os lados informados s�o iguais */
			if ((lado1 == lado2) && (lado1 == lado3) && (lado2 == lado3)) {
		        System.out.println("\nO triangulo � equil�tero");
    	    }
			
			/* Verifica se pelo menos dois lados informados s�o iguais */
			else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) {
		    	System.out.println("\nO triangulo � is�sceles");
		    }
			
			/* No caso dos tr�s lados serem diferentes */
		    else {
		    	System.out.println("\nO triangulo � escaleno");
		    }
		
		/* No caso dos tr�s lados n�o formarem um tri�ngulo */
		}else {
			System.out.println("\nOs lados informados n�o formam um tri�ngulo");
		}
		
		/* Finaliza o processo de entrada de dados */
		entradaTeclado.close();
	}
}
