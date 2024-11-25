package main;

import java.io.IOException;

import models.Arquivo;
import models.ColecaoMultas;
import models.Cronometrador;
import models.Impressor;
import models.Cronometrador.MedidaTempo;
import models.Multa;
import models.Ordenador;

public class Atividade2 
{
	public static void main(String[] args) throws IOException
	{
		rodarExercicio2();
	}
	
	public static void rodarExercicio2() throws IOException
	{
		String algoritmo = "quicksort";
		Arquivo arquivoEntrada, arquivoResultado;
		String nomeArquivo;
		
		nomeArquivo = "multa10000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa10000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa10000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa1000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa50000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000alea.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000inv.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
		
		nomeArquivo = "multa5000ord.txt";
		arquivoEntrada = new Arquivo(nomeArquivo);
		arquivoResultado = new Arquivo(Todos.gerarNomeSaida(algoritmo, nomeArquivo));
		Impressor.imprimirResultadoAlgoritmo(algoritmo, nomeArquivo, ordenar(arquivoEntrada, arquivoResultado));
	}
	
	public static void quicksort(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		ColecaoMultas multas = new ColecaoMultas(arquivoEntrada);
		Ordenador.ordenarComQuickSort(multas);
		arquivoSaida.sobreescrever(multas.toString());
	}
	
	public static double ordenar(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		int vezes = 5;
		Cronometrador cronometro = new Cronometrador();
		
		cronometro.iniciar();
		for (int i = 0; i < vezes; i++)
			quicksort(arquivoEntrada, arquivoSaida);
		cronometro.finalizar();
		
		return cronometro.getDeltaTempo(MedidaTempo.MILISEGUNDOS) / vezes;
	}
}
