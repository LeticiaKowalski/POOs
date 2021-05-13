package atividade2;

public class Aluno extends Pessoa {
	
	private String matricula;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, String matricula, String cpf, String dataNascimento, String email) {
		super(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEmail(email);
	}
	
	public Aluno(String nome) {
		super(nome);
	}
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.length() > 0)
			this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.length() > 0)
			this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		if (dataNascimento.length() > 0)
			this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() > 0)
			this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n- Matrícula: ");
		builder.append(matricula);
		builder.append("\n- CPF: ");
		builder.append(cpf);
		builder.append("\n- Data de Nascimento: ");
		builder.append(dataNascimento);
		builder.append("\n- E-mail: ");
		builder.append(email);
		return builder.toString();
	}
}
