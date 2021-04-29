import java.util.*;

import javax.swing.JOptionPane;

public class TrianguloUI {
    public static void main(String[] args) {
    	try {
    	String lado1Str = JOptionPane.showInputDialog(null, "Informe o primeiro lado do tri�ngulo");
    	int lado1 = Integer.parseInt(lado1Str);
    	String lado2Str = JOptionPane.showInputDialog(null, "Informe o segundo lado do tri�ngulo");
    	int lado2 = Integer.parseInt(lado2Str);
    	String lado3Str = JOptionPane.showInputDialog(null, "Informe o terceiro lado do tri�ngulo");
    	int lado3 = Integer.parseInt(lado3Str);
    	
    	/* Verifica se os lados informados formam um tri�ngulo */
		if (lado1<lado2+lado3 && lado2<lado1+lado3 && lado3<lado1+lado2) {
			
			/* Verifica se todos os lados informados s�o iguais */
			if ((lado1 == lado2) && (lado1 == lado3) && (lado2 == lado3)) {
		        JOptionPane.showMessageDialog(null, "O triangulo � equil�tero");
    	    }
			
			/* Verifica se pelo menos dois lados informados s�o iguais */
			else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) {
				JOptionPane.showMessageDialog(null, "O triangulo � is�sceles");
		    }
			
			/* No caso dos tr�s lados serem diferentes */
		    else {
		    	JOptionPane.showMessageDialog(null, "O triangulo � escaleno");
		    }
		
		/* No caso dos tr�s lados n�o formarem um tri�ngulo */
		}else {
			JOptionPane.showMessageDialog(null, "Os lados informados n�o formam um tri�ngulo");
		}
    	}catch(InputMismatchException e) {
    		System.out.println("Erro ao informar o lado do tri�ngulo");
			e.getMessage();
    	}
    }
}
