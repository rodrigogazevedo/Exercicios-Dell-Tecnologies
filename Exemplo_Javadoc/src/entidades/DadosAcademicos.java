package entidades;

/**
 * 
 * @author Rodrigo
 * @version 1
 */
public class DadosAcademicos {

	private double nota1;
	private double nota2;
	private double nota3;
	private String anotacoes;
	private Aluno aluno;
	
	public DadosAcademicos(Aluno aluno) {
		super();
		this.aluno = aluno;
	}

	public DadosAcademicos(double nota1, double nota2, double nota3, String anotacoes, Aluno aluno) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.anotacoes = anotacoes;
		this.aluno = aluno;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public String toString() {
		return "DadosAcademicos [nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", anotacoes=" + anotacoes
				+ ", aluno=" + aluno + "]";
	}
}
