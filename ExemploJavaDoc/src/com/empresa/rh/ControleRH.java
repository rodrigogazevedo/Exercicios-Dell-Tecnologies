package com.empresa.rh;

/**
 * Esta classe � respons�vel por gerenciar as atividades
 * do setor de RH (Recursos Humanos) como verifica��o de
 * disponibilidade de funcion�rios, c�lculo de faltas,
 * c�lculo de sal�rio para o m�s base etc.
 * 
 * @author Rodrigo
 *
 */
public class ControleRH {

	private double salarioBase;
	private int quantidadeFuncionarios;
	
	/**
	 * Este m�todo calcula o sal�rio do m�s para um funcion�rio,
	 * baseado no sal�rio base da empresa e em dois valores vari�veis,
	 * de acordo com a produtividade/faltas: o b�nus percentual e o
	 * desconto que ele sofrer� no m�s atual.
	 * @param descontoMes valor em moeda que ser� descontado do sal�rio
	 * @param bonusMes percentual de b�nus. (Exemplo: 15% de b�nus = 1.15)
	 */
	public double calcularSalarioMes(double descontoMes, double bonusMes) {
		return (salarioBase * bonusMes) - descontoMes;
	}
	
	/**
	 * Fornece a quantidade de funcion�rios contratados atualmente.
	 * @return quantidade de funcion�rios da empresa.
	 */
	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}
	
	/**
	 * Calcula a quantidade de faltas acumuladas do funcion�rio durante o ano.
	 * Para obter a quantidade de faltas de cada m�s, o m�todo
	 * {@link com.empresa.rh.Funcionario#qtdFaltasNoMes(int)} � utilizado.
	 * @param f funcionario
	 * @return a quantidade de faltas acumuladas do funcion�rio em 12 meses
	 */
	public int faltasAcumuladasAno(Funcionario f) {
		int faltasAcumuladas = 0;
		for (int mes = 0; mes < 12; mes++) {
			faltasAcumuladas += f.qtdFaltasNoMes(mes);
		}
		return faltasAcumuladas;
	}
	
	/**
	 * @deprecated Esta vers�o n�o � mais utilizada. O setor do RH emite apenas o
	 * n�mero de faltas para um per�odo de 12 meses. Utilize a vers�o para um ano
	 * completo: {@link ControleRH#faltasAcumuladasAno(Funcionario)}.
	 */
	public int faltasAcumuladasPeriodo(Funcionario f, int mesInicial, int mesFinal) {
		int faltasAcumuladas = 0;
		//...
		return faltasAcumuladas;
	}
}
