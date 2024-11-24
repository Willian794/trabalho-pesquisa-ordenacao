package models;

import models.interfaces.Colecao;
import models.interfaces.Item;

public class Ordenador
{
	// Método de Ordenção HeapSort
	@SuppressWarnings("unchecked")
	public static void ordenarComHeapSort(Colecao<?> colecao)
	{ 
		int n = colecao.size();

		for (int i = n / 2 - 1; i >= 0; i--)
			refazHeap((Colecao<Item>) colecao, n, i);

		for (int i = n - 1; i > 0; i--) 
		{
			colecao.trocar(0, i);
			refazHeap((Colecao<Item>) colecao, i, 0);
		}
	}

	private static void refazHeap(Colecao<Item> colecao, int n, int i) 
	{
		int maior = i;
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		if (esquerda < n && colecao.get(esquerda).compareTo(colecao.get(maior)) > 0)
			maior = esquerda;

		if (direita < n && colecao.get(direita).compareTo(colecao.get(maior)) > 0)
			maior = direita;

		if (maior != i) 
		{
			colecao.trocar(i, maior);
			refazHeap(colecao, n, maior);
		}
	}

	// Método de ordenação QuickSort
	@SuppressWarnings("unchecked")
	public static void ordenarComQuickSort(Colecao<?> colecao) 
	{
		quickSort(0, colecao.size() - 1, (Colecao<Item>) colecao);
	}
	
	private static void quickSort (int esq, int dir, Colecao<Item> colecao)
	{
		Item pivo;
		int i = esq, j = dir;
		pivo = colecao.get((i + j) / 2);
		do 
		{
			while (colecao.get(i).compareTo(pivo) < 0)
				i++;
			while (colecao.get(j).compareTo(pivo) > 0)
				j--;
			if (i <= j) 
			{
				colecao.trocar(i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j)
			quickSort(esq, j, colecao);
		if (dir > i)
			quickSort(i, dir, colecao);
	}
	
	// Método de ordenção Inserção Direta
	private static void insercaoDireta(Colecao<Item> colecao)
	{
		int i, j; 
		Item temp;
		for (i=1; i < colecao.size(); i++)
		{
			temp = colecao.get(i);
			j = i - 1;
			while ((j >= 0) && (colecao.get(j).compareTo(temp) > 0))
			{
				colecao.set(j+1, colecao.get(j));
				j--;
			}
			colecao.set(j+1, temp);
		}
	}
	
	// Método de ordenação QuickSort com Inserção Direta
	@SuppressWarnings("unchecked")
	public static void ordenarComQuickSortInsercaoDireta(Colecao<?> colecao)
	{
		quickSortInsercaoDireta(0, colecao.size() - 1, (Colecao<Item>) colecao);
	}
	
	private static void quickSortInsercaoDireta(int esq, int dir, Colecao<Item> colecao)
	{
		if (dir - esq <= 20)
			insercaoDireta(colecao);
		else
		{
			Item pivo;
			int i = esq, j = dir;
			pivo = colecao.get((i+j)/2);
			do {
				while (colecao.get(i).compareTo(pivo) < 0)
					i++;
				while (colecao.get(j).compareTo(pivo) > 0)
					j--;
				if (i <= j) 
				{
					colecao.trocar(i, j);
					i++;
					j--;
				}
			} while (i <= j);
			if (esq < j)
				quickSortInsercaoDireta(esq, j, colecao);
			if (dir > i)
				quickSortInsercaoDireta(i, dir, colecao);
		}
	}
}
