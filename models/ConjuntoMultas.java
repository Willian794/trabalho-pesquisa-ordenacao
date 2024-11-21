package models;

import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoMultas implements Iterable<Multa>
{
	private ArrayList<Multa> multas;
	private int quant;
	
	public ConjuntoMultas(Arquivo arquivo)
	{
		this.multas = new ArrayList<>();
		this.quant = 0;
		ArrayList<String> linhas = arquivo.lerLinhas();
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

	public int getQuant()
	{
		return quant;
	}
	
	public Multa get(int indice)
	{
		if (indice >= quant)
			return null;
		
		return multas.get(indice);
	}
	
	public Multa remove(int indice)
	{
		if (indice >= quant || indice < 0)
			return null;
		quant--;
		return multas.remove(indice);
	}
	
	public boolean add(int indice, Multa multa)
	{
		if (indice >= quant || indice < 0)
			return false;
		quant++;
		multas.add(indice, multa);
		return true;
	}
	
	public boolean set(int indice, Multa multa)
	{
		if (indice >= quant || indice < 0)
			return false;
		multas.remove(indice);
		multas.add(indice, multa);
		return true;
	}
	
	public void trocar(int indice1, int indice2) 
	{
		Multa multa = multas.get(indice1);
		this.set(indice1, this.get(indice2));
		this.set(indice2, multa);
	}
	
	@Override
	public Iterator<Multa> iterator() 
	{
		return new ConjuntoMultasIterator(this.multas);
	}
}
