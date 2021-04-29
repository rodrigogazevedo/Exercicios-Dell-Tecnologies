import java.util.Scanner;

public class DescontoINSS {

	public static void main(String[] args) {
		Scanner entradaTeclado = new Scanner(System.in);
		
		System.out.println("Informe o valor do salário de contribuição");
        double valorContrib = entradaTeclado.nextDouble();
        
        //double salario = valorContrib - calcularDescontoINSS(valorContrib);
        double salario = valorContrib - novoCalcularDescontoINSS(valorContrib);
        
        System.out.println("O salário líquido do funcionário é: "+salario);
        
        entradaTeclado.close();
	}
	
	/**
	 * @deprecated Cálculo do desconto do INSS Agosto/2006 do salário do contribuinte.
	 * Atualmente os valores da alíquota são outros
	 */
	public static double calcularDescontoINSS(double valorContrib) {
		double valorDescontoINSS = 0;
		if (valorContrib <= 840.47) {
			valorDescontoINSS = ((valorContrib * 7.65)/100);
		}else if ((valorContrib >= 840.48) &&  (valorContrib <= 1050)){
			valorDescontoINSS = ((valorContrib * 8.65)/100);
		}else if ((valorContrib >= 1050.01) &&  (valorContrib <= 1400.77)){
			valorDescontoINSS = ((valorContrib * 9)/100);
		}else if ((valorContrib >= 1400.78) &&  (valorContrib <= 2508.72)){
			valorDescontoINSS = ((valorContrib * 11)/100); 
		}
		return valorDescontoINSS;
	}
	
	public static double novoCalcularDescontoINSS(double valorContrib) {
		double valorDescontoINSS = 0;
		int aliquota1 = 8, aliquota2 = 9, aliquota3 = 11;
		if (valorContrib <= 1751.81) {
			valorDescontoINSS = ((valorContrib * aliquota1)/100);
		}else if ((valorContrib >= 1751.82) &&  (valorContrib <= 2919.72)){
			valorDescontoINSS = ((valorContrib * aliquota2)/100);
		}else if ((valorContrib >= 2919.72) &&  (valorContrib <= 5839.45)){
			valorDescontoINSS = ((valorContrib * aliquota3)/100);
		}
		return valorDescontoINSS;
	}
}
