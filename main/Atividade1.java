package main;

import java.io.IOException;

import models.Arquivo;
import models.ConjuntoMultas;
import models.Multa;
import models.Ordenador;
import models.Cronometrador;
import models.Cronometrador.MedidaTempo;

public class Atividade1
{
	public static void main(String[] args) throws IOException
	{
		ConjuntoMultas multas = new ConjuntoMultas(new Arquivo("dados/originais/multa20iguais.txt"));
		Cronometrador cronometrador = new Cronometrador();
		
		cronometrador.iniciar();
		
		Ordenador.ordenarComHeapSort(multas);
		
		Arquivo arquivoResultado = new Arquivo("dados/gerados/multa20iguais_ord.txt");
		for (Multa multa : multas)
			arquivoResultado.escrever(multa.toString());
		
		cronometrador.finalizar();
		
		System.out.println("\nTempo para ordenar: " + cronometrador.getDeltaTempo(MedidaTempo.MILISEGUNDOS) + " milisegundos.");
	}
}
