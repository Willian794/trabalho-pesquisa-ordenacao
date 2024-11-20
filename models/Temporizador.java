package models;

public class Temporizador 
{
	public enum MedidaTempo {MILISEGUNDOS, SEGUNDOS, MINUTOS, HORAS};
	private Long tempoInicial, tempoFinal;
	
	public void iniciarContagem() 
	{
		this.tempoInicial = System.currentTimeMillis();
	}
	
	public void finalizarContagem()
	{
		this.tempoFinal = System.currentTimeMillis();
	}
	
	public Double calcularDeltaTempo(MedidaTempo medidaTempo)
	{
		if (tempoInicial == null || tempoFinal == null)
			return null;
		
		switch (medidaTempo)
		{
			case MILISEGUNDOS ->
			{
				return (double)(tempoFinal - tempoInicial);
			}
			case SEGUNDOS -> 
			{
				return ((double)(tempoFinal - tempoInicial)) / 1_000 ;
			}
			case MINUTOS ->
			{
				return ((double)(tempoFinal - tempoInicial)) / 60_000;
			}
			case HORAS -> 
			{
				return ((double)(tempoFinal - tempoInicial)) / 3_600_000;
			}
			default -> {return null;}
		}
	}
}
