package models.VetorEncadeado;

import java.util.LinkedList;

import models.interfaces.Item;

public class VetorEncadeado<E extends Item> 
{
	private LinkedList<E>[] vetor;
	private int tamanho;
	
	@SuppressWarnings("unchecked")
	public VetorEncadeado(int tamanho)
	{
		this.vetor = new LinkedList[(int) primoMaior(tamanho)];
		this.tamanho = tamanho;
	}
	
	public void add(E item) 
	{
		int chaveHash = constroeChaveHash((String) item.getChavePrimaria());
		
		if (this.vetor[chaveHash] == null)
			vetor[chaveHash] = new LinkedList<E>();
		
		vetor[chaveHash].add(item);
	}
	
	public LinkedList<E> get(String chavePesquisa)
	{
		int chavePrimaria = constroeChaveHash(chavePesquisa);
		LinkedList<E> listaPosicao = vetor[chavePrimaria];
		LinkedList<E> resultados = new LinkedList<E>();
		
		if (listaPosicao != null)
			for (E item : listaPosicao)
				if (((String) item.getChavePrimaria()).equals(chavePesquisa))
					resultados.add(item);
		return resultados;
	}
	
	private int constroeChaveHash(String chave)
	{
		char carac;
		int i, soma = 0;
		for (i = 0; i < chave.length(); i++)
		{
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		return soma % this.tamanho;
	}
	
	private static long primoMaior(long numero)
	{
		long numeroParaPrimo = numero + 1;
		while (!verificarPrimo(numeroParaPrimo))
			numeroParaPrimo += 1;
		return numeroParaPrimo;
	}
	
	private static boolean verificarPrimo(long numero) 
	{ 
		if (numero <= 1) 
			return false;
		for (int i = 2; i <= Math.sqrt(numero); i++)
			if (numero % i == 0)
				return false;
		return true; 
	}
}
