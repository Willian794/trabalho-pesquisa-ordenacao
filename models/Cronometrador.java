package models;

public class Cronometrador 
{
	public enum MedidaTempo {MILISEGUNDOS, SEGUNDOS, MINUTOS, HORAS};
	private Long tempoInicial, tempoFinal;
	
	public void iniciar() 
	{
		this.tempoInicial = System.currentTimeMillis();
	}
	
	public void finalizar()
	{
		this.tempoFinal = System.currentTimeMillis();
	}
	
	public Double getDeltaTempo(MedidaTempo medidaTempo)
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
