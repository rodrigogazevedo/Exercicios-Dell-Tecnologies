import javax.swing.JOptionPane;

public class MercadinhoUI {
	public static void main (String args[]) {
		/* Lista de produtos e seus respectivos pre�os */
		
		String produtos[] = {"Macarr�o", "Arroz", "Batata", "Caf�", "Leite", "Feij�o"};
		
		float precos[] = {1.99f, 2.75f, 3.80f, 4.00f, 2.99f, 3.50f};
		
		/*Obter o c�digo do produto*/
		String codigoProdutoStr = JOptionPane.showInputDialog(null, "Informe o codigo do produto");
		int codigoProduto = Integer.parseInt(codigoProdutoStr);
		
		/*Se o c�digo do produto estiver correto, solicitar a quantidade do produto */
		if (codigoProduto > 1 && codigoProduto < produtos.length) {
			/* Obter a quantidade do produto */
			String quantidadeStr = JOptionPane.showInputDialog(null, "Informe a quantidade do produto");
			int quantidade = Integer.parseInt(quantidadeStr);
			
			float total = precos[codigoProduto] * quantidade;
			
			JOptionPane.showMessageDialog(null,
					"Produto: "+produtos[codigoProduto] +"\n"
					+ "Valor unit�rio: R$ "+precos[codigoProduto] +"\n"
					+ "Quantidade: "+quantidade+ "\n"
					+ "--------------------------------------" + "\n"
					+ "TOTAL: R$ "+total);
		} else {
			JOptionPane.showMessageDialog(null,"Produto n�o encontrado!");
		}
		
	}

}
