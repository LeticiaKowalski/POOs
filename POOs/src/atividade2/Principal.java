package atividade2;

import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
				
			Persistencia p1 = new Persistencia();
			Injecao i1 = new Injecao(p1);
				
			Persistencia p2 = new Persistencia();
			Injecao i2 = new Injecao(p2);
				
			Persistencia p3 = new Persistencia();
			Injecao i3 = new Injecao(p3);
			
			Lista alunos = new Lista();
			Aluno aluno = new Aluno();
				
			aluno.setNome("Letícia");
			aluno.setMatricula("2020006749");
			aluno.setCpf("111.111.111-11");
			aluno.setDataNascimento("12/02/2001");
			aluno.setEmail("lehh.kowalski@gmail.com");
			Lista.inserir(aluno);

			i1.gerarPersistencia(Lista.getLista());
			i2.gerarPersistencia(Lista.getLista());
			i3.gerarPersistencia(Lista.getLista());

			System.out.println(Lista.getLista().toString());
	}

}
