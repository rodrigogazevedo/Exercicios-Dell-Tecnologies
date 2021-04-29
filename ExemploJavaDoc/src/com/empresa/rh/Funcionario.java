package com.empresa.rh;

/**
 * Representa os dados de um usu�rio na empresa,
 * @author Rodrigo
 *
 */
public class Funcionario {
	public String nome;
	private int[] faltasMes;
	
	public Funcionario(String nome) {
		this.nome = nome;
		faltasMes = new int[12];
	}
	
	/**
	 * Fornece a quantidade de faltas do funcion�rio em um determinado m�s.
	 * @param indiceMes �ndice do m�s no array de faltas.
	 * @return a quantidade de faltas do funcion�rio no m�s indicado.
	 */
	public int qtdFaltasNoMes(int indiceMes) {
		return faltasMes[indiceMes];
	}
}
