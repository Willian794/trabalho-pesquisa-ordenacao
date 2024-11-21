package models;

public class Data 
{
	private int dia, mes, ano;

	public Data(int dia, int mes, int ano) 
	{
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

	public int compareTo(Data comparacao) // retorna em dias
	{
		return (this.ano - comparacao.ano) * 365 + (this.mes - comparacao.mes) * 30 + (this.dia - comparacao.dia);
	}
	
	@Override
	public String toString() 
	{
		return (dia < 10 ? "0" + dia : dia)  + "/" + (mes < 10 ? "0" + mes : mes) + "/" + (ano < 10 ? "0" + ano : ano);
	}
}
