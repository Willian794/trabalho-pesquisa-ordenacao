package models;

import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoMultasIterator implements Iterator<Multa>
{
	private int indice;
	private ArrayList<Multa> multas;
	
	public ConjuntoMultasIterator(ArrayList<Multa> multas)
	{
		this.indice = -1;
		this.multas = multas;
	}
	
	@Override
	public boolean hasNext() 
	{
		return (indice + 1) < multas.size(); 
	}

	@Override
	public Multa next() 
	{
		indice++;
		return multas.get(indice);
	}
}
