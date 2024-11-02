package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Arquivo extends File
{
	private static final long serialVersionUID = 1L;

	public Arquivo(String caminhoArquivo) throws IOException
	{
		super(caminhoArquivo);
	}
	
	public ArrayList<String> lerLinhas()
	{
		try 
		{
			ArrayList<String> conteudo = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader(super.getPath()));
			String conteudoLinha = reader.readLine();
			
			while (conteudoLinha != null)
			{
				conteudo.add(conteudoLinha);
				conteudoLinha = reader.readLine();
			}
			
			reader.close();
			return conteudo;
		} catch (IOException e) {return null;}
	}

	public long contarLinhas()
	{
		long contador = -1;
		try 
		{
			contador = Files.lines(Paths.get(super.getPath())).count();
		} catch (IOException e) {}
		return contador;
	}
}
