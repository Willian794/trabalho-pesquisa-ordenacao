package models.AVL;

import models.ABB.NoAbb;
import models.interfaces.Item;

public class NoAVL extends NoAbb 
{
	private int fatorBalanceamento;
	
	public NoAVL(Item item) 
	{
		super(item);
	}
	
	protected int getFatorBalanceamento() 
	{
		return fatorBalanceamento;
	}

	protected void setFatorBalanceamento(int fatorBalanceamento) 
	{
		this.fatorBalanceamento = fatorBalanceamento;
	}
}
