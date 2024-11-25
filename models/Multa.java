package models;

import models.interfaces.Item;

public class Multa implements Item
{
	private String placa, nome, local; 
	private Data data;
	private Horario horario;
	
	public Multa(String placa, String nome, String local, Data data, Horario horario) 
	{
		this.placa = placa;
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
	}

	public String getPlaca() {return placa;}
	public String getNome() {return nome;}
	public String getLocal() {return local;}
	public Data getData() {return data;}
	public Horario getHorario() {return horario;}
	
	@Override
	public Object getChavePrimaria() {return this.getPlaca();}

	@Override
	public Object getChaveSecundaria() {return this.getData();}

	@Override
	public Object getChaveTerciaria() {return this.getHorario();}

	@Override
	public Object getChaveQuarternaria() {return this.getNome();}

	@Override
	public Object getUltimaChave() {return this.getLocal();}
	
	@Override
	public int compareTo(Item itemComparacao) {
		String placa1 = this.getPlaca(); 
		String placa2 = (String) itemComparacao.getChavePrimaria();
		int comparacaoPlaca = placa1.compareTo(placa2); 
		
		if (comparacaoPlaca != 0)
			return comparacaoPlaca;
		else 
		{
			Data data1 = this.getData();
			Data data2 = (Data) itemComparacao.getChaveSecundaria();
			int comparacaoData = data1.compareTo(data2);
			
			if (comparacaoData != 0)
				return comparacaoData;
			else
			{
				Horario horario1 = this.getHorario();
				Horario horario2 = (Horario) itemComparacao.getChaveTerciaria();
				return horario1.compareTo(horario2);
			}
		}
	}
	
	@Override
	public String toString() {
		return placa + ", " + data + ", " + horario + ", " + nome + ", " + local + ".";
	}
}
