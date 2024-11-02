package models;

public class Horario 
{
	private int hora, minuto;

	public Horario(int hora, int minuto) {
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
}
