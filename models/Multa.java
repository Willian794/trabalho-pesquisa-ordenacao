package models;

public class Multa 
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

	public String getPlaca() {
		return placa;
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}

	public Data getData() {
		return data;
	}

	public Horario getHorario() {
		return horario;
	}
	
	@Override
	public String toString() {
		return placa + ", " + data + ", " + horario + ", " + nome + ", " + local + ".";
	}
}
