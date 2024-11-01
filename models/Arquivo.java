package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo 
{
	private String pathName;
	private BufferedReader reader;
	private BufferedWriter writer;

	public Arquivo(String pathName) throws IOException
	{
		if (new File(this.pathName).isFile() == false)
			throw new IOException("Caminho não leva a um arquivo, ou o arquivo é inexistente.");
		
		this.pathName = pathName;
		this.reader = new BufferedReader(new FileReader(this.pathName));
		this.writer = new BufferedWriter(new FileWriter(this.pathName));
	}
	
	public boolean escrever(String dado)
	{
		String conteudo = "";
		String linha;
		try 
		{
			linha = this.reader.readLine();
			while (linha != null)
			{
				conteudo += linha + "\n";
				linha = this.reader.readLine();
			}
			this.writer.write(conteudo);
			return true;
		}
		catch (IOException e) {return false;}
	}
	
	public boolean escrever(int linha, String dado)
	{
		String conteudo = "";
		String conteudoLinha;
		try 
		{
			conteudoLinha = this.reader.readLine();
			while (conteudoLinha != null)
			{
				conteudo += conteudoLinha + "\n";
				conteudoLinha = this.reader.readLine();
			}
			this.writer.write(conteudo);
			return true;
		}
		catch (IOException e) {return false;}
	}
	
	/*
	// INCOMPLETO
	public int getNumeroLinhas()
	{
		int i = 0;
		try 
		{
			while (this.reader.readLine() != null)
				i++;
			this.reader.
		}
		catch (IOException e) {return -1;}
	}
	*/
}
