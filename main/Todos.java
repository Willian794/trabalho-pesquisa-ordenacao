package main;

import java.io.IOException;

public class Todos 
{
	public static void main(String[] args) throws IOException
	{
		Atividade1.rodarExercicio1();
		Atividade2.rodarExercicio2();
		Atividade3.rodarExercicio3();
		Atividade4.rodarExercicio4();
		Atividade5.rodarExercicio5();
		Atividade6.rodarExercicio6();
	}
	
	public static String gerarNomeSaida(String algoritmo, String entrada)
	{
		return algoritmo + entrada.substring(5);
	}
}
