package main;

import java.io.IOException;
import java.util.LinkedList;

import models.Arquivo;
import models.Impressor;
import models.ABB.NoAbb;
import models.AVL.ArvoreAVL;

public class Atividade5 
{
	public static void main(String[] args) throws IOException
	{
		ArvoreAVL arvore = new ArvoreAVL(new Arquivo("dados/multa50000inv.txt"));
		arvore.balancear();
		LinkedList<String> registros = new Arquivo("dados/placas.txt").lerLinhas();
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
