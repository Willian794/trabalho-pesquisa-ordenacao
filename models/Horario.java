package models;

public class Horario 
{
	private int hora, minuto;

	public Horario(int hora, int minuto) 
	{
		this.hora = hora % 24;
		this.minuto = minuto % 60;
	}
	
	public Horario(String hora)
	{
		String[] vetCampos = hora.split(":");
		this.hora = Integer.parseInt(vetCampos[0]) % 24;
		this.minuto = Integer.parseInt(vetCampos[1]) % 60;
	}

	public int getHora() {return hora;}

	public int getMinuto() {return minuto;}

	public int compareTo(Horario comparacao) // retorna em minutos
	{
		return (this.hora - comparacao.hora) * 60 + (this.minuto - comparacao.minuto);
	}
	
	@Override
	public String toString() 
	{
		return (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto);
	}
}
