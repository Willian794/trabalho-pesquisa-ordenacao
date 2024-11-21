package models;

public class Ordenador
{
	// Método de Ordenção HeapSort
	public static void heapSort(ConjuntoMultas multas) 
	{
		int n = multas.getQuant();

		for (int i = n / 2 - 1; i >= 0; i--)
			refazHeap(multas, n, i);

		for (int i = n - 1; i > 0; i--) 
		{
			multas.trocar(0, i);
			refazHeap(multas, i, 0);
		}
	}

	private static void refazHeap(ConjuntoMultas multas, int n, int i) 
	{
		int maior = i;
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		if (esquerda < n && multas.get(esquerda).getPlaca().compareTo(multas.get(maior).getPlaca()) > 0)
			maior = esquerda;

		if (direita < n && multas.get(direita).getPlaca().compareTo(multas.get(maior).getPlaca()) > 0)
			maior = direita;

		if (maior != i) 
		{
			multas.trocar(i, maior);
			refazHeap(multas, n, maior);
		}
	}
}
