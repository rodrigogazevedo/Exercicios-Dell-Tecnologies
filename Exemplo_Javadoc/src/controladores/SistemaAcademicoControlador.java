package controladores;

import entidades.Aluno;
import entidades.DadosAcademicos;

/**
 * Modela e realiza opera��es de c�lculo e recupera��o de dados acad�micos de um aluno
 * 
 * @author Rodrigo
 * @version 2
 */
public class SistemaAcademicoControlador {
	private DadosAcademicos dadosAcademicos;
	private double mediaMinimaAprovacao;
	private double mediaMinimaRecuperacao;
	
	public SistemaAcademicoControlador(DadosAcademicos dadosAcademicos) {
		super();
		this.dadosAcademicos = dadosAcademicos;
	}
	
	public double getMediaMinimaAprovacao() {
		return mediaMinimaAprovacao;
	}
	
	public void setMediaMinimaAprovacao(double mediaMinimaAprovacao) {
		this.mediaMinimaAprovacao = mediaMinimaAprovacao;
	}
	
	public double getMediaMinimaRecuperacao() {
		return mediaMinimaRecuperacao;
	}
	
	public void setMediaMinimaRecuperacao(double mediaMinimaRecuperacao) {
		this.mediaMinimaRecuperacao = mediaMinimaRecuperacao;
	}

	public String getNomeAluno() {
		return dadosAcademicos.getAluno().getNome();
	}
	
	public String getMatriculaAluno() {
		return dadosAcademicos.getAluno().getMatricula();
	}
	
	public Aluno getAluno() {
		return dadosAcademicos.getAluno();
	}
	
	/**
	 * Retorna a m�dia aritm�tica simples das notas do aluno.
	 * 
	 * @return media aritm�tica dos atributos nota1, nota2 e nota3 do aluno 
	 */
	public double getMedia() {
		return (dadosAcademicos.getNota1() + dadosAcademicos.getNota2() + dadosAcademicos.getNota3())/3;
	}
	
	/**
	 * Adiciona informa��es ou observa��es sobre o aluno.
	 * 
	 * @param anotacoes recebe informa��es ut�is sobre o aluno, que n�o s�o adicionadas em outros campos.
	 */
	public void adicionarAnotacoes(String anotacoes) {
		dadosAcademicos.setAnotacoes(anotacoes);
	}
	
	public void atualizarDadosAluno(Aluno aluno) {
		dadosAcademicos.setAluno(aluno);
	}
	
	/**
	 * Retorna a situa��o de aprova��o do aluno.
	 * 
	 * @return true, caso o aluno tenha sido aprovado, e false, caso o aluno tenha sido reprovado.
	 * @deprecated
	 */
	public boolean foiAprovado() {
		return getMedia() >= mediaMinimaAprovacao;
	}
	
	/**
	 * Retorna a real situa��o do aluno, em caso de aprova��o, reprova��o ou recupera��o.
	 * 
	 * @return "Aprovado", caso o aluno tenha m�dia aprovativa, maior ou igual ao atributo mediaMinimaAprovacao; "Recupera��o", caso a m�dia seja maior ou igual ao atributo mediaMinimaRecuperacao; "Reprovado", caso a m�dia do aluno seja menor que o atributo mediaMinimaRecuperacao
	 * @Since 2
	 */
	public String getSituacao() {
		if(getMedia() >= mediaMinimaAprovacao)
			return "Aprovado";
		else if (getMedia() >= mediaMinimaRecuperacao)
			return "Recupera��o";
		else
			return "Reprovado";
	}
}
