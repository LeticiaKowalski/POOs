package atividade2;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	static List<Aluno> lista = new ArrayList<Aluno>();
		
	public static List<Aluno> getLista() {
			return lista;
	}
		
	public static void inserir(Aluno aluno) {
			lista.add(aluno);
	}
	
}
