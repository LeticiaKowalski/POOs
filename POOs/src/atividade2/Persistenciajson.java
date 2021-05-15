package atividade2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Persistenciajson {
	
	GsonBuilder b = new GsonBuilder();
	Gson g = b.create();
	
	List<Aluno> listas = new ArrayList<Aluno>();
	
	public Persistenciajson() {
		
	}
	
	public boolean adiciona(Aluno aluno) {
		return (listas.add(aluno));
	}
	
	public String leitura() throws FileNotFoundException {
		
		b = new GsonBuilder();
		g = b.create();
		
		BufferedReader bf = new BufferedReader (new FileReader("json/alunos.json"));
		Type listType = new TypeToken<ArrayList<Aluno>>(){}.getType();
		
		listas = new ArrayList<Aluno>();
		listas = new Gson().fromJson(bf, listType);
		
		String mensagem = "";
		for (Iterator<Aluno> iterator = listas.iterator(); iterator.hasNext();) {
			
			Aluno aluno = (Aluno) iterator.next();
			mensagem += aluno.toString() + "\n";
		}
		
		return (mensagem);
	}
	
	public void mostra() throws IOException {
		
		FileWriter w = new FileWriter("json/alunos.json");
		
		w.write(g.toJson(listas));
		w.close();
	}
	
	public String resultado() {
		
		return g.toJson(listas);
	}
}
