package entidades;

import java.util.Date;

/**
 * 
 * @author Rodrigo
 * @version 1
 */
public class Aluno {
	private int id;
	private String matricula;
	private String nome;
	private Date dataDeNascimento;
	
	public Aluno() {
		super();
	}
	
	public Aluno(int id, String matricula, String nome, Date dataDeNascimento) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", dataDeNascimento="
				+ dataDeNascimento + "]";
	}
	
}
