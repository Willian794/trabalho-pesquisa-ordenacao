package main;

import java.io.IOException;
import java.util.LinkedList;

import models.Arquivo;
import models.Cronometrador;
import models.Cronometrador.MedidaTempo;
import models.Impressor;
import models.ABB.NoAbb;
import models.AVL.ArvoreAVL;

public class Atividade5 
{
	
	public static void main(String[] args) throws IOException
	{
		rodarExercicio5();
	}
	
	public static void rodarExercicio5() throws IOException
	{
		String estrutura = "AVL";
		Arquivo arquivoEntrada, arquivoResultado;
		String nomeArquivo;
		
		nomeArquivo = "multa10000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa10000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa10000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(estrutura, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(estrutura, nomeArquivo, pesquisar(arquivoEntrada, arquivoResultado));
	}
	
	public static void pesquisaBinariaEmAVL(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		String resultado = "";
		ArvoreAVL arvore = new ArvoreAVL(arquivoEntrada);
		LinkedList<String> placas = new Arquivo("placas.txt").lerLinhas(); 
		
		for (String placa : placas)
		{
			NoAbb noPesquisado = arvore.pesquisar(placa);
			if (noPesquisado == null)
				resultado += String.format("PLACA %s:%nNAO TEM MULTA %n%n", placa);
			else
				resultado += aglomerarMultas(noPesquisado);
		}
		
		arquivoSaida.sobreescrever(resultado);
	}
	
	public static double pesquisar(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		int vezes = 5;
		Cronometrador cronometro = new Cronometrador();
		
		cronometro.iniciar();
		for (int i = 0; i < vezes; i++)
			pesquisaBinariaEmAVL(arquivoEntrada, arquivoSaida);
		cronometro.finalizar();
		
		return cronometro.getDeltaTempo(MedidaTempo.MILISEGUNDOS) / vezes;
	}
	
	public static String aglomerarMultas(NoAbb no)
	{
		String multas = "";
		if (no != null)
		{
			multas += String.format("PLACA %s:%n", no.getItem().getChavePrimaria());
			multas += aglomerarMultasComCampos(no) + "\n";
		} 
		return multas;
	}
	
	private static String aglomerarMultasComCampos(NoAbb no)
	{
		String conteudo = "";
		String local = (String) no.getItem().getUltimaChave();
		String data = (String) no.getItem().getChaveSecundaria().toString(); 
		String horario = (String) no.getItem().getChaveTerciaria().toString(); 
		
		conteudo += "Local: " + adicionarPularProximaColuna(local);
		conteudo += "Data: " + data + adicionarPularProximaColuna(data);
		conteudo += "Horario: " + horario + adicionarPularProximaColuna(horario) + "\n";
		
		if (no.getEsq() != null)
		{
			String chavePrimaria = (String) no.getItem().getChavePrimaria();
			String aux = (String) no.getEsq().getItem().getChavePrimaria();
			if (chavePrimaria.equals(aux))
				conteudo += aglomerarMultasComCampos(no.getEsq());
		}
		return conteudo;
	}
	
	private static String adicionarPularProximaColuna(String conteudo)
	{
		while (conteudo.length() < 50)
			conteudo += " ";
		return conteudo;
	}
}
