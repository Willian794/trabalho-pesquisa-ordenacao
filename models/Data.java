package models;

public class Data 
{
	private int dia, mes, ano;

	public Data(int dia, int mes, int ano) {
		this.dia = dia % 31;
		this.mes = mes % 12;
		this.ano = ano;
	}
	
	public Data(String data)
	{
		String[] vetCampos = data.split("/");
		this.dia = Integer.parseInt(vetCampos[0]) % 31;
		this.mes = Integer.parseInt(vetCampos[1]) % 12;
		this.ano = Integer.parseInt(vetCampos[2]);
	}
	
	public int getDia() {return dia;}

	public int getMes() {return mes;}

	public int getAno() {return ano;}
}
