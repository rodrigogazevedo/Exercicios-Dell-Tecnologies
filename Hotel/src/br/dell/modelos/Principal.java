package br.dell.modelos;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args){
		//Declara��o das vari�veis usadas para armazenar as informa��es do H�spede
		String cpfHStr, rgHStr, nomeH, idadeHStr, enderecoH;
		Long cpfH = null, rgH;
		int idadeH = 0;
		boolean check = true;
		
		//Cria��o da inst�ncia da classe Hospede
		Hospede hospede = new Hospede();

		//Tratamento de exce��es
		try { 
			//Obten��o das informa��es do hospede atrav�s de janelas
			cpfHStr = JOptionPane.showInputDialog(null, "Informe o CPF do hospede");
			cpfH = Long.parseLong(cpfHStr);
			rgHStr = JOptionPane.showInputDialog(null, "Informe o RG do hospede");
			rgH = Long.parseLong(rgHStr);

			/* La�o de itera��o para a inser��o da informa��o do nome do hospede
			 * Ap�s a inser��o do nome, � acionado o m�todo verificaName que checar� se o nome
			 * inserido � v�lido ou n�o, de acordo com parametros definidos na fun��o.
			 * Se o nome foi inv�lido � gerado uma mensagem de erro e solicitado novamente a 
			 * inser��o do nome do usu�rio.
			 * Se o nome foi v�lido sai da itera��o e continua a execu��o do programa
			 */
			do{
				nomeH = JOptionPane.showInputDialog(null, "Informe o nome do hospede");
				if (verificaNome(nomeH) == false) {
					JOptionPane.showMessageDialog(null,"Nome do hospede est� incorreto");
					check = true; //vari�vel mantida como true para repetir a itera��o - nome informado incorretamente
				}else {
					check = false; //vari�vel alterada para false para sair da itera��o - nome informado corretamente
				}
			}while (check == true);
			
			//Obten��o das outras informa��es do hospede atrav�s de janelas
			idadeHStr = JOptionPane.showInputDialog(null, "Informe a idade do hospede");
			idadeH = Integer.parseInt(idadeHStr);
			enderecoH = JOptionPane.showInputDialog(null, "Informe o endere�o do hospede");

			//Envia as informa��es repassadas para a Classe Hospede
			hospede.setCPF(cpfH);
			hospede.setRG(rgH);
			hospede.setNome(nomeH);
			hospede.setIdade(idadeH);
			hospede.setEndereco(enderecoH);

			//Imprime mensagem de sucesso ao inserir os dados
			JOptionPane.showMessageDialog(null,"Hospede cadastrado com sucesso!!");

			//Obten��o das informa��es do quarto do hospede atrav�s de janelas
			String quartoHospedeStr = JOptionPane.showInputDialog("Informe o n�mero do quarto do hospede");
			int quartoHospede = Integer.parseInt(quartoHospedeStr);
			
			//Envia as informa��es repassadas para a Classe Quarto
			Quarto quarto = new Quarto(quartoHospede, hospede);

			//Mostra em uma janela as informa��es armazenadas
			JOptionPane.showMessageDialog(null,"Dados do hospede\n"
					+ "\nNome: "+hospede.getNome()
					+ "\nRG: "+hospede.getRG()
					+ "\nCPF: "+hospede.getCPF()
					+ "\nIdade: "+hospede.getIdade()
					+ "\nEndereco: "+hospede.getEndereco()
					+ "\nQuarto: "+quarto.getNumero());
		}catch (InputMismatchException ime) {
			/* Exce��o lan�ado por um scanner para indicar que o token recuperado n�o corresponde 
			 * ao padr�o para o tipo esperado ou que o token est� fora do intervalo para o tipo 
			 * esperado. 
			 */
			System.err.println("Erro ao informar os dados. Informe somente n�meros. Erro: "+ime.getMessage());
		}
		catch(NumberFormatException nfe){
			/* Exce��o lan�ado para indicar que o aplicativo tentou converter uma sequ�ncia em um 
			 * dos tipos num�ricos, mas que a sequ�ncia n�o possui o formato apropriado. 
			 */
			System.err.println("Erro ao informar os dados. Informe somente n�meros. Erro: "+nfe.getMessage());
		}


	}

	//M�todo que verifica se o nome inserido correspende aos padr�es definidos: Somente letras (maiusculas e/ou minusculas)
	public static boolean verificaNome(String nome) {
		//Inicializa a vari�vel "valido" como true
		boolean valido = true;
		
		/* Usado o m�todo replaceAll para substitui todos os caracteres passados no primeiro par�metro pelos caracteres 
		 * passados no segundo par�metro, ou seja, no primeiro par�metro do replaceAll() estamos dizendo que tudo que for espa�o deve 
		 * ser substitu�do por nada (na verdade, s� est� retirando os espa�os do nome passado para o m�todo)
		 */
		nome = nome.replaceAll(" ", "");

		/* Condi��o que testar� o nome passado para o m�todo: Se o nome contiver letras maiusculas e/ou minusculas, 
		 * vogais com acentos agudos (�) e/ou tis (~), e tamb�m o cedilha (maiusculo ou minusculo), ent�o o nome est� correto, ou seja, 
		 * exclui caracteres especiais, v�rgula, ponto, barra e n�meros como letras v�lidas para compor o nome do h�spede (devido 
		 * se tratar de uma String e aceitar esses tipos)
		 */
		if(!nome.matches("[a-zA-Z\\�-��-�\\�-��-�\\��]*")){
			//Retorna o valor "false" se nome estiver fora das par�metros corretos
			valido = false;
		}

		//Retorna o valor "true" se nome estiver dentro das par�metros corretos
		return valido;
	}

}