import java.util.Scanner;

public class TrianguloScanner {
	public static void main(String[] args) {
		/* Criação de um objeto da classe Scanner */
		Scanner entradaTeclado = new Scanner(System.in);
		
		/* Captura os três lados do triângulo digitado no console pelo usuário */
		System.out.println("Digite o primeiro lado do triângulo");
		float lado1 = entradaTeclado.nextFloat();
		System.out.println("Digite o segundo lado do triângulo");
		float lado2 = entradaTeclado.nextFloat();
		System.out.println("Digite o terceiro lado do triângulo");
		float lado3 = entradaTeclado.nextFloat();
		
		/* Verifica se os lados informados formam um triângulo */
		if (lado1<lado2+lado3 && lado2<lado1+lado3 && lado3<lado1+lado2) {
			
			/* Verifica se todos os lados informados são iguais */
			if ((lado1 == lado2) && (lado1 == lado3) && (lado2 == lado3)) {
		        System.out.println("\nO triangulo é equilátero");
    	    }
			
			/* Verifica se pelo menos dois lados informados são iguais */
			else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) {
		    	System.out.println("\nO triangulo é isósceles");
		    }
			
			/* No caso dos três lados serem diferentes */
		    else {
		    	System.out.println("\nO triangulo é escaleno");
		    }
		
		/* No caso dos três lados não formarem um triângulo */
		}else {
			System.out.println("\nOs lados informados não formam um triângulo");
		}
		
		/* Finaliza o processo de entrada de dados */
		entradaTeclado.close();
	}
}
