package controladores;

import entidades.Aluno;
import entidades.DadosAcademicos;

/**
 * Modela e realiza operações de cálculo e recuperação de dados acadêmicos de um aluno
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
	 * Retorna a média aritmética simples das notas do aluno.
	 * 
	 * @return media aritmética dos atributos nota1, nota2 e nota3 do aluno 
	 */
	public double getMedia() {
		return (dadosAcademicos.getNota1() + dadosAcademicos.getNota2() + dadosAcademicos.getNota3())/3;
	}
	
	/**
	 * Adiciona informações ou observações sobre o aluno.
	 * 
	 * @param anotacoes recebe informações utéis sobre o aluno, que não são adicionadas em outros campos.
	 */
	public void adicionarAnotacoes(String anotacoes) {
		dadosAcademicos.setAnotacoes(anotacoes);
	}
	
	public void atualizarDadosAluno(Aluno aluno) {
		dadosAcademicos.setAluno(aluno);
	}
	
	/**
	 * Retorna a situação de aprovação do aluno.
	 * 
	 * @return true, caso o aluno tenha sido aprovado, e false, caso o aluno tenha sido reprovado.
	 * @deprecated
	 */
	public boolean foiAprovado() {
		return getMedia() >= mediaMinimaAprovacao;
	}
	
	/**
	 * Retorna a real situação do aluno, em caso de aprovação, reprovação ou recuperação.
	 * 
	 * @return "Aprovado", caso o aluno tenha média aprovativa, maior ou igual ao atributo mediaMinimaAprovacao; "Recuperação", caso a média seja maior ou igual ao atributo mediaMinimaRecuperacao; "Reprovado", caso a média do aluno seja menor que o atributo mediaMinimaRecuperacao
	 * @Since 2
	 */
	public String getSituacao() {
		if(getMedia() >= mediaMinimaAprovacao)
			return "Aprovado";
		else if (getMedia() >= mediaMinimaRecuperacao)
			return "Recuperação";
		else
			return "Reprovado";
	}
}
