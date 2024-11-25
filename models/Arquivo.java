package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Arquivo extends File
{
	private static final long serialVersionUID = 1L;

	public Arquivo(String caminhoArquivo) throws IOException
	{
		super(caminhoArquivo);
	}
	
	public LinkedList<String> lerLinhas()
	{
		try 
		{
			LinkedList<String> conteudo = new LinkedList<>();
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
	
	public void sobreescrever(String conteudo) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(super.getPath()));
		writer.write(conteudo);
		writer.close();
	}
	
	public boolean escrever(String conteudo)
	{
		return this.escrever(this.contarLinhas(), conteudo);
	}
	
	public boolean escrever(long linha, String conteudo)
	{
		try
		{
			if (!super.exists())
				super.createNewFile();
			
			BufferedReader reader = new BufferedReader(new FileReader(super.getPath()));
			String conteudoLinha = reader.readLine(), arquivo = "";
			int contador = 0;
			
			while (conteudoLinha != null)
			{
				if (contador == linha)
				{
					arquivo += conteudo + "\n";
					break;
				}
				arquivo	+= conteudoLinha + "\n";
				conteudoLinha = reader.readLine();
				contador++;
			}
			
			while (conteudoLinha != null)
			{
				arquivo	+= conteudoLinha + "\n";
				conteudoLinha = reader.readLine();
			}
			
			if (linha >= this.contarLinhas())
				arquivo += conteudo + "\n";
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(super.getPath()));
			writer.write(arquivo);
			
			reader.close();
			writer.close();
		}
		catch (IOException e) {return false;}
		return true;
	}
}
