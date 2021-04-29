import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Calendar cal = GregorianCalendar.getInstance();
		int anoAtual = cal.get(Calendar.YEAR);
		int mesAtual = cal.get(Calendar.MONTH);
		int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
		//Scanner in;
		int diaNasc;
		int mesNasc;
		int anoNasc;

		// sintaxe
		/*
		 * Geralmente ele retorna uma string, por isso converter para o tipo de
		 * variavel desejado int variavel =
		 * Integer.parseInt(JOptionPane.showInputDialog("Digite o nome"));
		 */

		try {

			do {

				diaNasc = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o dia"));

				if (diaNasc < 1 || diaNasc > 31)
					JOptionPane.showMessageDialog(null, "entrada invalida!");

			} while (diaNasc < 1 || diaNasc > 31);

			do {
				mesNasc = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o mes:"));

				if (mesNasc < 1 || mesNasc > 12)
					JOptionPane.showMessageDialog(null, "entrada invalida!");
			} while (mesNasc < 1 || mesNasc > 12);

			do {
				anoNasc = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o ano:"));
				if (anoNasc < 1 || anoNasc > anoAtual)
					JOptionPane.showMessageDialog(null, "entrada invalida!");
			} while (anoNasc < 1 || anoNasc > anoAtual);

			int idade = (anoAtual - anoNasc);
			if ((mesAtual < mesNasc) && (diaAtual < diaNasc))
				idade--;

			JOptionPane
					.showMessageDialog(null, "voce tem: " + idade + " anos.");
			if (idade < 18) {
				JOptionPane.showMessageDialog(null, "Menor de idade");
			} else {
				JOptionPane.showMessageDialog(null, "Maior de idade");
			}
		} catch (InputMismatchException ex) {
			// aqui exibe apenas mensagem
			JOptionPane.showMessageDialog(null, "entrada invalida!");
		}
	}
}

