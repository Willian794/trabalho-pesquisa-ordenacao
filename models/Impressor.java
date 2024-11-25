package models;

import java.util.LinkedList;

import models.ABB.NoAbb;
import models.interfaces.Item;

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
		String local = (String) no.getItem().getUltimaChave();
		String data = (String) no.getItem().getChaveSecundaria().toString(); 
		String horario = (String) no.getItem().getChaveTerciaria().toString(); 
		
		System.out.print("Local: ");
		imprimirPularProximaColuna(local);
		
		System.out.print("Data: ");
		imprimirPularProximaColuna(data);
		
		System.out.print("Horario: ");
		imprimirPularProximaColuna(horario);
		System.out.println();
		
		if (no.getEsq() != null)
		{
			String chavePrimaria = (String) no.getItem().getChavePrimaria();
			String aux = (String) no.getEsq().getItem().getChavePrimaria();
			if (chavePrimaria.equals(aux))
				imprimirItem(no.getEsq());
		}
	}
	
	private static void imprimirPularProximaColuna(String conteudo)
	{
		while (conteudo.length() < 50)
			conteudo += " ";
		System.out.print(conteudo);
	}
	
	public static void imprimir(LinkedList<? extends Item> lista)
	{
		if (lista != null && lista.size() > 0)
		{
			for (Item item : lista)
			{
				String local = (String) item.getUltimaChave();
				String data = (String) item.getChaveSecundaria().toString(); 
				String horario = (String) item.getChaveTerciaria().toString(); 
				
				System.out.print("Local: ");
				imprimirPularProximaColuna(local);
				
				System.out.print("Data: ");
				imprimirPularProximaColuna(data);
				
				System.out.print("Horario: ");
				imprimirPularProximaColuna(horario);
				System.out.println();
			}
		}
		else
			System.out.println("NÃO TEM MULTA");
		System.out.println();
	}
}
