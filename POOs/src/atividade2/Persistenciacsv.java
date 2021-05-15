package atividade2;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Persistenciacsv {
	
	private static final String LOCALHOST = "csv/alunos.csv";
	
	@SuppressWarnings("resource")
	public boolean gerarArquivo(List<Aluno> aluno) {
		try {
			FileWriter fileWriter = new FileWriter(LOCALHOST);
			CSVWriter csvWriter = new CSVWriter(fileWriter);
			
			String[] headers = {"Nome", "Matrícula", "CPF", "Data de nascimento", "E-mail"};
			
			List<String[]> data = new ArrayList<String[]>();
			
			data.add(headers);
			
			for (int i = 0; i < aluno.size(); i++) {
				
				String[] item = {aluno.get(i).getNome(), 
						Integer.toString(aluno.get(i).getMatricula()),
						aluno.get(i).getCpf(),
						aluno.get(i).getDataNascimento(),
						aluno.get(i).getEmail()};
				
				data.add(item);
			}
			
			csvWriter.writeAll(data);
			fileWriter.close();	
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
}
