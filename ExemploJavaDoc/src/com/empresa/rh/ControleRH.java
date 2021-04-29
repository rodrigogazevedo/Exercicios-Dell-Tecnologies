package com.empresa.rh;

/**
 * Esta classe é responsável por gerenciar as atividades
 * do setor de RH (Recursos Humanos) como verificação de
 * disponibilidade de funcionários, cálculo de faltas,
 * cálculo de salário para o mês base etc.
 * 
 * @author Rodrigo
 *
 */
public class ControleRH {

	private double salarioBase;
	private int quantidadeFuncionarios;
	
	/**
	 * Este método calcula o salário do mês para um funcionário,
	 * baseado no salário base da empresa e em dois valores variáveis,
	 * de acordo com a produtividade/faltas: o bônus percentual e o
	 * desconto que ele sofrerá no mês atual.
	 * @param descontoMes valor em moeda que será descontado do salário
	 * @param bonusMes percentual de bônus. (Exemplo: 15% de bônus = 1.15)
	 */
	public double calcularSalarioMes(double descontoMes, double bonusMes) {
		return (salarioBase * bonusMes) - descontoMes;
	}
	
	/**
	 * Fornece a quantidade de funcionários contratados atualmente.
	 * @return quantidade de funcionários da empresa.
	 */
	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}
	
	/**
	 * Calcula a quantidade de faltas acumuladas do funcionário durante o ano.
	 * Para obter a quantidade de faltas de cada mês, o método
	 * {@link com.empresa.rh.Funcionario#qtdFaltasNoMes(int)} é utilizado.
	 * @param f funcionario
	 * @return a quantidade de faltas acumuladas do funcionário em 12 meses
	 */
	public int faltasAcumuladasAno(Funcionario f) {
		int faltasAcumuladas = 0;
		for (int mes = 0; mes < 12; mes++) {
			faltasAcumuladas += f.qtdFaltasNoMes(mes);
		}
		return faltasAcumuladas;
	}
	
	/**
	 * @deprecated Esta versão não é mais utilizada. O setor do RH emite apenas o
	 * número de faltas para um período de 12 meses. Utilize a versão para um ano
	 * completo: {@link ControleRH#faltasAcumuladasAno(Funcionario)}.
	 */
	public int faltasAcumuladasPeriodo(Funcionario f, int mesInicial, int mesFinal) {
		int faltasAcumuladas = 0;
		//...
		return faltasAcumuladas;
	}
}
