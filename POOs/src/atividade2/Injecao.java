package atividade2;

import java.util.List;

public class Injecao {
	
	protected Persistencia persistencia;
		
	public Injecao(Persistencia persistencia) {
		this.persistencia = persistencia;
	}
		
	public boolean gerarPersistencia(List<Aluno> aluno) {
		return this.persistencia.gerarArquivo(aluno);
	}
	
}
