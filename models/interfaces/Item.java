package models.interfaces;

public interface Item extends Comparable<Item> 
{
	Object getChavePrimaria();
	Object getChaveSecundaria();
	Object getChaveTerciaria();
}
