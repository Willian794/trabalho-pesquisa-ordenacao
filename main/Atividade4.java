package main;

import java.io.IOException;
import java.util.ArrayList;

import models.Arquivo;
import models.Impressor;
import models.arvoreBinaria.Abb;
import models.arvoreBinaria.NoAbb;

public class Atividade4 
{
	public static void main(String[] args) throws IOException
	{
		Abb arvore = new Abb(new Arquivo("dados/multa50000alea.txt"));
		arvore.balancear();
		ArrayList<String> registros = new Arquivo("dados/placas.txt").lerLinhas();
		for (String registro : registros)
		{
			NoAbb noPesquisa = arvore.pesquisar(registro);
			if (noPesquisa == null)
				System.out.printf("PLACA %s:%nNAO TEM MULTA %n%n", registro);
			else
				Impressor.imprimir(noPesquisa);
		}
	}
}
