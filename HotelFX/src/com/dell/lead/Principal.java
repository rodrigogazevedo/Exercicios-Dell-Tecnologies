package com.dell.lead;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Classe principal que irá criar os Objetos Hospede e Quarto para armazenamento dos dados
 * do hospede e seu respectivo quarto
 * @author Rodrigo Guimarães de Azevedo
 * @version 3
 */
public class Principal {

	/**
	 * Método Principal
	 * @since 22/12/2019 Criação do Mapa para mapear chave (cpf) com o valor (nome) para busca das informações do hóspede
	 * 
	 */
	public static void main(String[] args){
		//Declaração das variáveis usadas para armazenar as informações do Hóspede
		String cpfHStr, rgHStr, nomeH, idadeHStr, enderecoH, cpfHStrBuscar;
		Long cpfH = null, rgH, cpfHBuscar;
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
			
			/* Eu optei por usar o mapa pois favorece a busca dos dados do hospede passando como parâmetro o CPF do mesmo.
			 * Assim, eu mapeei o cpf - chave - com a nome - valor - para facilitar a recuperação das informações do hospede e
			 * do quarto em que ele está hospedado
			 */
			Map<Long, String> mapaHospede = new HashMap<Long, String>();
			mapaHospede.put(cpfH, nomeH);
			
			cpfHStrBuscar = JOptionPane.showInputDialog(null, "Informe o CPF do hospede para buscar: ");
			cpfHBuscar = Long.parseLong(cpfHStrBuscar);
			
			//Passa a chave - CPF - para localizar o valor - nome - do hospede atrelado a ela
			String nomeClienteBuscado = mapaHospede.get(cpfHBuscar);
			//Testa a condição para saber se existe algum hospede com o CPF informado
			if (nomeClienteBuscado != null)
				//Mostra em uma janela as informações do hospede armazenadas se encontrar o CPF informado
				JOptionPane.showMessageDialog(null,"Dados do hospede\n"
						+ "\nNome: "+hospede.getNome()
						+ "\nRG: "+hospede.getRG()
						+ "\nCPF: "+hospede.getCPF()
						+ "\nIdade: "+hospede.getIdade()
						+ "\nEndereco: "+hospede.getEndereco()
						+ "\nQuarto: "+quarto.getNumero());
			else
				//Mostra uma mensagem de alerta que não encontrou o hospede com o CPF informado
				JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o CPF "+cpfHBuscar+" informado", "Alerta", JOptionPane.ERROR_MESSAGE);

		}
		
		catch(NumberFormatException nfe){
			System.err.println("Erro ao informar os dados. Informe somente números. Erro: "+nfe.getMessage());
		}


	}

	/**
	 * Método que verifica se o nome inserido correspende aos padrões definidos: Somente letras (maiusculas e/ou minusculas),
	 * vogais com acentos agudos (´) e/ou tis (~), e também o cedilha (maiusculo ou minusculo)
	 * @since 22/12/2019
	 * @param nome Recebe como parâmetro o nome do hóspede
	 * @return Retorna "true", caso o nome inserido do hóspede está dentro dos padrões estabelecidas; retorna "false", 
	 * caso o nome inserido esteja fora dos padrões estabelecidos
	 */
	public static boolean verificaNome(String nome) {
		//Inicializa a variável "valido" como true
		boolean valido = true;
		
		/* Usado o método replaceAll para substitui todos os caracteres passados no primeiro parâmetro pelos caracteres 
		 * passados no segundo parâmetro, ou seja, no primeiro parâmetro do replaceAll() estamos dizendo que tudo que for espaço deve 
		 * ser substituído por nada (na verdade, só está retirando os espaços do nome passado para o método)
		 */
		nome = nome.replaceAll(" ", "");

		/* Condição que testará o nome passado para o método: Se o nome não contiver letras maiusculase/ou minusculas, 
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