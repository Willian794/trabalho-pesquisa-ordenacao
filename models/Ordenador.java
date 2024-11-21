package models;

public class Ordenador
{
	// Método de Ordenção HeapSort
	public static void ordenarComHeapSort(ConjuntoMultas multas)
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

		if (esquerda < n && comparar(multas.get(esquerda),multas.get(maior)) > 0)
		//if (esquerda < n && multas.get(esquerda).getPlaca().compareTo(multas.get(maior).getPlaca()) > 0)
			maior = esquerda;

		if (direita < n && comparar(multas.get(direita),multas.get(maior)) > 0)
		//if (direita < n && multas.get(direita).getPlaca().compareTo(multas.get(maior).getPlaca()) > 0)
			maior = direita;

		if (maior != i) 
		{
			multas.trocar(i, maior);
			refazHeap(multas, n, maior);
		}
	}
	
	private static int comparar(Multa multa1, Multa multa2)
	{
		String placa1 = multa1.getPlaca(); 
		String placa2 = multa2.getPlaca();
		int comparacaoPlaca = placa1.compareTo(placa2); 
		
		if (comparacaoPlaca != 0)
			return comparacaoPlaca;
		else 
		{
			Data data1 = multa1.getData();
			Data data2 = multa2.getData();
			int comparacaoData = data1.compareTo(data2);
			
			if (comparacaoData != 0)
				return comparacaoData;
			else
			{
				Horario horario1 = multa1.getHorario();
				Horario horario2 = multa2.getHorario();
				return horario1.compareTo(horario2);
			}
		}
	}
}
