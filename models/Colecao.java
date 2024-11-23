package models;

public interface Colecao<T extends Item> extends Iterable<T>
{
	boolean add(T elem);
	boolean add(int indice, T elem);
	int size();
	T get(int indice);
	boolean set(int indice, T elem);
	boolean trocar(int indice1, int indice2);
	T remove(int indice);
}
