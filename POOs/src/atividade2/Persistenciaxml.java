package atividade2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class Persistenciaxml implements Persistencia {

	final static String NOMEDOARQUIVO = "Alunos";
	final static String LOCALHOST = "xml/";
	
	public boolean gerarArquivo(List<Aluno> lista) {
		
	
		Element config = new Element("Alunos");
		Document documento = new Document(config);
		
		for(int i = 0; i < lista.size(); i++) {
			Element aluno = new Element("Aluno ");
			
			aluno.setAttribute("Matricula ", String.valueOf(lista.get(i).getMatricula()));
			
			Element nome = new Element("Nome ");
			nome.setText(lista.get(i).getNome());
			
			Element cpf = new Element("CPF ");
			cpf.setText(lista.get(i).getCpf());
			
			Element dataNascimento = new Element("Data de nascimento ");
			dataNascimento.setText(lista.get(i).getDataNascimento());
			
			Element email = new Element("E-mail ");
			email.setText(lista.get(i).getEmail());
			
			aluno.addContent(nome);
			aluno.addContent(cpf);
			aluno.addContent(dataNascimento);
			aluno.addContent(email);
			config.addContent(aluno);
		}
		
		XMLOutputter xout = new XMLOutputter();
		
		try {
			
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST + NOMEDOARQUIVO + ".xml"), "UTF-8"));
			xout.output(documento, arquivo);
			
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public List<Aluno> lerXML() {
		List<Aluno> lista_aluno = new ArrayList<Aluno>();
		Document documento = null;
		SAXBuilder builder = new SAXBuilder();
		
		try {
			documento = builder.build(LOCALHOST + NOMEDOARQUIVO + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Element config = documento.getRootElement();
		List lista = config.getChildren("Aluno ");
		
		for(Iterator iter = lista.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Aluno aluno = new Aluno();
			
			aluno.setNome(element.getChildText("Nome "));
			aluno.setMatricula(element.getChildText(("Matrícula ")));
			aluno.setCpf(element.getChildText("CPF "));
			aluno.setDataNascimento(element.getChildText("Data de nascimento "));
			aluno.setEmail(element.getChildText("E-mail "));
			lista_aluno.add(aluno);
		}
		
		return lista_aluno;
	}

}
