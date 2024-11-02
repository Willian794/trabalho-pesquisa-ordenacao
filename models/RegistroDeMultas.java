package models;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistroDeMultas implements Iterable<Multa>
{
	private ArrayList<Multa> multas;
	
	public RegistroDeMultas(Arquivo arquivo)
	{
		multas = new ArrayList<>();
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
		}
	}

	@Override
	public Iterator<Multa> iterator() 
	{
		return new RegistroDeMultasIterator(this.multas);
	}
}
