package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import models.interfaces.Colecao;

public class ColecaoMultas implements Colecao<Multa>
{
	private ArrayList<Multa> multas;
	private int quant;
	
	public ColecaoMultas(Arquivo arquivo)
	{
		this.multas = new ArrayList<>();
		this.quant = 0;
		LinkedList<String> linhas = arquivo.lerLinhas();
		String[] vetCampos;
		for (String linha : linhas)
		{
			vetCampos = linha.split(";");
			multas.add(
				new Multa(
					vetCampos[0],
					vetCampos[1],
					vetCampos[2],
					new Data(vetCampos[3]),
					new Horario(vetCampos[4])
				)
			);
			this.quant++;
		}
	}

	@Override
	public Iterator<Multa> iterator() {
		return new ColecaoMultasIterator(this.multas);
	}

	@Override
	public boolean add(Multa elem) {
		return this.multas.add(elem);
	}

	@Override
	public boolean add(int indice, Multa elem) {
		if (indice >= this.quant || indice < 0)
			return false;
		this.quant++;
		this.multas.add(indice, elem);
		return true;
	}

	@Override
	public int size() {
		return this.quant;
	}

	@Override
	public Multa get(int indice) {
		if (indice >= quant || indice < 0)
			return null;
		
		return multas.get(indice);
	}

	@Override
	public boolean set(int indice, Multa elem) {
		if (indice >= quant || indice < 0)
			return false;
		multas.remove(indice);
		multas.add(indice, elem);
		return true;
	}

	@Override
	public boolean trocar(int indice1, int indice2) {
		if ((indice1 >= this.quant || indice1 < 0) || (indice2 >= this.quant || indice2 < 0))
			return false;
		Multa multa = multas.get(indice1);
		this.set(indice1, this.get(indice2));
		this.set(indice2, multa);
		return true;
	}

	@Override
	public Multa remove(int indice) {
		if (indice >= quant || indice < 0)
			return null;
		quant--;
		return multas.remove(indice);
	}
}
