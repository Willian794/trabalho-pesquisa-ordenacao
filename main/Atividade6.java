package main;

import java.io.IOException;
import java.util.LinkedList;

import models.Arquivo;
import models.Cronometrador;
import models.Cronometrador.MedidaTempo;
import models.Data;
import models.Horario;
import models.Impressor;
import models.Multa;
import models.VetorEncadeado.VetorEncadeado;
import models.interfaces.Item;

public class Atividade6 
{
	public static void main(String[] args) throws IOException
	{
		rodarExercicio6();
	}
	
	public static void rodarExercicio6() throws IOException
	{
		String estrutura = "VetorEncadeado";
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
	
	public static void pesquisaVetorEncadeado(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		String resultado = "";
		VetorEncadeado<Multa> multas = construirVetorEncadeadoMulta(arquivoEntrada);
		LinkedList<String> placas = new Arquivo("placas.txt").lerLinhas(); 
		
		for (String placa : placas)
		{
			resultado += String.format("PLACA: %s%n", placa);
			resultado += imprimir(multas.get(placa));
		}
		
		arquivoSaida.sobreescrever(resultado);
	}
	
	public static VetorEncadeado<Multa> construirVetorEncadeadoMulta(Arquivo arquivo)
	{
		LinkedList<String> registros = arquivo.lerLinhas();
		VetorEncadeado<Multa> vetorEncadeado = new VetorEncadeado<Multa>(registros.size());
		
		Multa multaAux;
		String vetorAux[];
		for (String registro : registros)
		{
			vetorAux = registro.split(";");
			multaAux = new Multa(
				vetorAux[0],
				vetorAux[1],
				vetorAux[2],
				new Data(vetorAux[3]),
				new Horario(vetorAux[4])
			);
			vetorEncadeado.add(multaAux);
		}
		return vetorEncadeado;
	}
	
	public static double pesquisar(Arquivo arquivoEntrada, Arquivo arquivoSaida) throws IOException
	{
		int vezes = 5;
		Cronometrador cronometro = new Cronometrador();
		
		cronometro.iniciar();
		for (int i = 0; i < vezes; i++)
			pesquisaVetorEncadeado(arquivoEntrada, arquivoSaida);
		cronometro.finalizar();
		
		return cronometro.getDeltaTempo(MedidaTempo.MILISEGUNDOS) / vezes;
	}
	
	private static String adicionarPularProximaColuna(String conteudo)
	{
		while (conteudo.length() < 50)
			conteudo += " ";
		return conteudo;
	}
	
	public static String imprimir(LinkedList<? extends Item> lista)
	{
		String conteudo = "";
		if (lista != null && lista.size() > 0)
		{
			for (Item item : lista)
			{
				String local = (String) item.getUltimaChave();
				String data = (String) item.getChaveSecundaria().toString(); 
				String horario = (String) item.getChaveTerciaria().toString(); 
				
				conteudo += adicionarPularProximaColuna("Local: " + local);
				conteudo += adicionarPularProximaColuna("Data: " + data);
				conteudo += adicionarPularProximaColuna("Horario: " + horario);
				conteudo += "\n";
			}
		}
		else
			conteudo += "NÃO TEM MULTA\n";
		return conteudo + "\n";
	}
}
