import java.util.*;

import javax.swing.JOptionPane;

public class TrianguloUI {
    public static void main(String[] args) {
    	try {
    	String lado1Str = JOptionPane.showInputDialog(null, "Informe o primeiro lado do triângulo");
    	int lado1 = Integer.parseInt(lado1Str);
    	String lado2Str = JOptionPane.showInputDialog(null, "Informe o segundo lado do triângulo");
    	int lado2 = Integer.parseInt(lado2Str);
    	String lado3Str = JOptionPane.showInputDialog(null, "Informe o terceiro lado do triângulo");
    	int lado3 = Integer.parseInt(lado3Str);
    	
    	/* Verifica se os lados informados formam um triângulo */
		if (lado1<lado2+lado3 && lado2<lado1+lado3 && lado3<lado1+lado2) {
			
			/* Verifica se todos os lados informados são iguais */
			if ((lado1 == lado2) && (lado1 == lado3) && (lado2 == lado3)) {
		        JOptionPane.showMessageDialog(null, "O triangulo é equilátero");
    	    }
			
			/* Verifica se pelo menos dois lados informados são iguais */
			else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) {
				JOptionPane.showMessageDialog(null, "O triangulo é isósceles");
		    }
			
			/* No caso dos três lados serem diferentes */
		    else {
		    	JOptionPane.showMessageDialog(null, "O triangulo é escaleno");
		    }
		
		/* No caso dos três lados não formarem um triângulo */
		}else {
			JOptionPane.showMessageDialog(null, "Os lados informados não formam um triângulo");
		}
    	}catch(InputMismatchException e) {
    		System.out.println("Erro ao informar o lado do triângulo");
			e.getMessage();
    	}
    }
}
