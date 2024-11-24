package main;

import java.io.IOException;

import models.Arquivo;
import models.ColecaoMultas;
import models.Cronometrador;
import models.Cronometrador.MedidaTempo;
import models.Multa;
import models.Ordenador;

public class Atividade2 
{
	public static void main(String[] args) throws IOException
	{
		ColecaoMultas multas = new ColecaoMultas(new Arquivo("dados/multa50000alea.txt"));
		Cronometrador cronometrador = new Cronometrador();
		
		cronometrador.iniciar();
		
		Ordenador.ordenarComQuickSort(multas);
		
		for (Multa multa : multas)
			System.out.println(multa);
		
		cronometrador.finalizar();
		
		System.out.println("\nTempo para ordenar: " + cronometrador.getDeltaTempo(MedidaTempo.SEGUNDOS) + " segundos.");
	}
}
