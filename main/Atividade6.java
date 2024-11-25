package main;

import java.io.IOException;
import java.util.LinkedList;

import models.Arquivo;
import models.Data;
import models.Horario;
import models.Impressor;
import models.Multa;
import models.VetorEncadeado.VetorEncadeado;

public class Atividade6 
{
	public static void main(String[] args) throws IOException
	{
		VetorEncadeado<Multa> multas = construirVetorEncadeadoMulta(new Arquivo("dados/multa10000alea.txt")); 
		LinkedList<String> placas = new Arquivo("dados/placas.txt").lerLinhas();
		
		for (String placa : placas)
		{
			System.out.printf("PLACA: %s%n", placa);
			Impressor.imprimir(multas.get(placa));
		}
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
}
