package models.ABB;

import models.interfaces.Item;

public class NoAbb
{
	protected Item item;
	protected NoAbb esq, dir;
	
	public NoAbb(Item item) 
	{
		this.item = item;
	}
	
	public Item getItem() {return item;}
	protected void setItem (Item novo) {this.item = novo;}
	public NoAbb getEsq() {return esq;}
	public void setEsq(NoAbb esq) {this.esq = esq;}
	public NoAbb getDir() {return dir;}
	public void setDir(NoAbb dir) {this.dir = dir;}
}
