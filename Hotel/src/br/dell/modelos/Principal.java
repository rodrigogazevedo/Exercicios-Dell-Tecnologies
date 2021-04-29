package br.dell.modelos;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args){
		//Declaração das variáveis usadas para armazenar as informações do Hóspede
		String cpfHStr, rgHStr, nomeH, idadeHStr, enderecoH;
		Long cpfH = null, rgH;
		int idadeH = 0;
		boolean check = true;
		
		//Criação da instância da classe Hospede
		Hospede hospede = new Hospede();

		//Tratamento de exceções
		try { 
			//Obtenção das informações do hospede através de janelas
			cpfHStr = JOptionPane.showInputDialog(null, "Informe o CPF do hospede");
			cpfH = Long.parseLong(cpfHStr);
			rgHStr = JOptionPane.showInputDialog(null, "Informe o RG do hospede");
			rgH = Long.parseLong(rgHStr);

			/* Laço de iteração para a inserção da informação do nome do hospede
			 * Após a inserção do nome, é acionado o método verificaName que checará se o nome
			 * inserido é válido ou não, de acordo com parametros definidos na função.
			 * Se o nome foi inválido é gerado uma mensagem de erro e solicitado novamente a 
			 * inserção do nome do usuário.
			 * Se o nome foi válido sai da iteração e continua a execução do programa
			 */
			do{
				nomeH = JOptionPane.showInputDialog(null, "Informe o nome do hospede");
				if (verificaNome(nomeH) == false) {
					JOptionPane.showMessageDialog(null,"Nome do hospede está incorreto");
					check = true; //variável mantida como true para repetir a iteração - nome informado incorretamente
				}else {
					check = false; //variável alterada para false para sair da iteração - nome informado corretamente
				}
			}while (check == true);
			
			//Obtenção das outras informações do hospede através de janelas
			idadeHStr = JOptionPane.showInputDialog(null, "Informe a idade do hospede");
			idadeH = Integer.parseInt(idadeHStr);
			enderecoH = JOptionPane.showInputDialog(null, "Informe o endereço do hospede");

			//Envia as informações repassadas para a Classe Hospede
			hospede.setCPF(cpfH);
			hospede.setRG(rgH);
			hospede.setNome(nomeH);
			hospede.setIdade(idadeH);
			hospede.setEndereco(enderecoH);

			//Imprime mensagem de sucesso ao inserir os dados
			JOptionPane.showMessageDialog(null,"Hospede cadastrado com sucesso!!");

			//Obtenção das informações do quarto do hospede através de janelas
			String quartoHospedeStr = JOptionPane.showInputDialog("Informe o número do quarto do hospede");
			int quartoHospede = Integer.parseInt(quartoHospedeStr);
			
			//Envia as informações repassadas para a Classe Quarto
			Quarto quarto = new Quarto(quartoHospede, hospede);

			//Mostra em uma janela as informações armazenadas
			JOptionPane.showMessageDialog(null,"Dados do hospede\n"
					+ "\nNome: "+hospede.getNome()
					+ "\nRG: "+hospede.getRG()
					+ "\nCPF: "+hospede.getCPF()
					+ "\nIdade: "+hospede.getIdade()
					+ "\nEndereco: "+hospede.getEndereco()
					+ "\nQuarto: "+quarto.getNumero());
		}catch (InputMismatchException ime) {
			/* Exceção lançado por um scanner para indicar que o token recuperado não corresponde 
			 * ao padrão para o tipo esperado ou que o token está fora do intervalo para o tipo 
			 * esperado. 
			 */
			System.err.println("Erro ao informar os dados. Informe somente números. Erro: "+ime.getMessage());
		}
		catch(NumberFormatException nfe){
			/* Exceção lançado para indicar que o aplicativo tentou converter uma sequência em um 
			 * dos tipos numéricos, mas que a sequência não possui o formato apropriado. 
			 */
			System.err.println("Erro ao informar os dados. Informe somente números. Erro: "+nfe.getMessage());
		}


	}

	//Método que verifica se o nome inserido correspende aos padrões definidos: Somente letras (maiusculas e/ou minusculas)
	public static boolean verificaNome(String nome) {
		//Inicializa a variável "valido" como true
		boolean valido = true;
		
		/* Usado o método replaceAll para substitui todos os caracteres passados no primeiro parâmetro pelos caracteres 
		 * passados no segundo parâmetro, ou seja, no primeiro parâmetro do replaceAll() estamos dizendo que tudo que for espaço deve 
		 * ser substituído por nada (na verdade, só está retirando os espaços do nome passado para o método)
		 */
		nome = nome.replaceAll(" ", "");

		/* Condição que testará o nome passado para o método: Se o nome contiver letras maiusculas e/ou minusculas, 
		 * vogais com acentos agudos (´) e/ou tis (~), e também o cedilha (maiusculo ou minusculo), então o nome está correto, ou seja, 
		 * exclui caracteres especiais, vírgula, ponto, barra e números como letras válidas para compor o nome do hóspede (devido 
		 * se tratar de uma String e aceitar esses tipos)
		 */
		if(!nome.matches("[a-zA-Z\\á-úÁ-Ú\\ã-õÃ-Õ\\çÇ]*")){
			//Retorna o valor "false" se nome estiver fora das parâmetros corretos
			valido = false;
		}

		//Retorna o valor "true" se nome estiver dentro das parâmetros corretos
		return valido;
	}

}