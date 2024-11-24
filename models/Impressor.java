package models;

import models.arvoreBinaria.NoAbb;

public class Impressor 
{
	public static void imprimir(NoAbb no)
	{
		if (no != null)
		{
			System.out.printf("PLACA %s:%n", no.getItem().getChavePrimaria());
			imprimirItem(no);
			System.out.println();
		} 
	}
	
	private static void imprimirItem(NoAbb no)
	{
		System.out.printf(
			"Local: %s     " + "Data: %s     " + "Hora: %s%n",
			(String) no.getItem().getChavePrimaria(),
			(String) no.getItem().getChaveSecundaria().toString(),
			(String) no.getItem().getChaveTerciaria().toString()
		);
		
		if (no.getEsq() != null)
		{
			String chavePrimaria = (String) no.getItem().getChavePrimaria();
			String aux = (String) no.getEsq().getItem().getChavePrimaria();
			if (chavePrimaria.equals(aux))
				imprimirItem(no.getEsq());
		}
	}
}
