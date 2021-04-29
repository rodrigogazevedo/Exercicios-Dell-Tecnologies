import javax.swing.JOptionPane;

public class MercadinhoUI {
	public static void main (String args[]) {
		/* Lista de produtos e seus respectivos preços */
		
		String produtos[] = {"Macarrão", "Arroz", "Batata", "Café", "Leite", "Feijão"};
		
		float precos[] = {1.99f, 2.75f, 3.80f, 4.00f, 2.99f, 3.50f};
		
		/*Obter o código do produto*/
		String codigoProdutoStr = JOptionPane.showInputDialog(null, "Informe o codigo do produto");
		int codigoProduto = Integer.parseInt(codigoProdutoStr);
		
		/*Se o código do produto estiver correto, solicitar a quantidade do produto */
		if (codigoProduto > 1 && codigoProduto < produtos.length) {
			/* Obter a quantidade do produto */
			String quantidadeStr = JOptionPane.showInputDialog(null, "Informe a quantidade do produto");
			int quantidade = Integer.parseInt(quantidadeStr);
			
			float total = precos[codigoProduto] * quantidade;
			
			JOptionPane.showMessageDialog(null,
					"Produto: "+produtos[codigoProduto] +"\n"
					+ "Valor unitário: R$ "+precos[codigoProduto] +"\n"
					+ "Quantidade: "+quantidade+ "\n"
					+ "--------------------------------------" + "\n"
					+ "TOTAL: R$ "+total);
		} else {
			JOptionPane.showMessageDialog(null,"Produto não encontrado!");
		}
		
	}

}
