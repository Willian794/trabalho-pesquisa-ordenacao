package models.AVL;

import java.util.LinkedList;

import models.Arquivo;
import models.Data;
import models.Horario;
import models.Multa;
import models.ABB.ArvoreABB;
import models.interfaces.Item;

public class ArvoreAVL extends ArvoreABB 
{
	private boolean h;

	public ArvoreAVL(Arquivo arquivo)
	{
		LinkedList<String> linhas = arquivo.lerLinhas();
		String[] vetCampos;
		for (String linha : linhas)
		{
			vetCampos = linha.split(";");
			this.inserir(
				new Multa(
					vetCampos[0],
					vetCampos[1],
					vetCampos[2],
					new Data(vetCampos[3]),
					new Horario(vetCampos[4])
				)
			);
		}
	}
	
	public ArvoreAVL() 
	{
		super.raiz = null;
		super.quant = 0;
	}
	
	@Override
	public void inserir(Item item)
	{
		this.raiz = this.inserir (item, (NoAVL) super.raiz);
		this.quant++;
	}

	private NoAVL inserir (Item item, NoAVL no)
	{
		if (no == null)
		{
			NoAVL novo = new NoAVL(item);
			this.h = true;
			return novo;
		} 
		else
		{
			if (((String) item.getChavePrimaria()).compareTo((String) no.getItem().getChavePrimaria()) < 0)
			{
				// Insere à esquerda e verifica se precisa
				// balancear à direita
				no.setEsq(this.inserir (item,(NoAVL) no.getEsq()));
				no = this.balancearDir(no);
				return no;
			} 
			else
			{
				// Insere à direita e verifica se precisa
				// balancear à esquerda
				no.setDir(this.inserir (item,(NoAVL) no.getDir()));
				no = this.balancearEsq (no);
				return no;
			}
		}
	}
	
	private NoAVL balancearDir (NoAVL no)
	{
		if (this.h) 
		{
			switch (no.getFatorBalanceamento())
			{
				case 1 : 
					no.setFatorBalanceamento(0);
					this.h = false;
					break;
				case 0 : 
					no.setFatorBalanceamento(-1); 
					break;
				case -1 : 
					no = this.rotacaoDireita (no);
			}
		}
		return no;
	}
	
	private NoAVL balancearEsq (NoAVL no)
	{
		if (this.h) 
		{
			switch (no.getFatorBalanceamento())
			{
				case -1: 
					no.setFatorBalanceamento(0);
					this.h = false;
					break;
				case 0: 
					no.setFatorBalanceamento(1); 
					break;
				case 1: 
					no = this.rotacaoEsquerda(no);
			}
		}
		return no;
	}
	
	private NoAVL rotacaoDireita(NoAVL no)
	{
		NoAVL temp1, temp2;
		temp1 = (NoAVL) no.getEsq();
		if (temp1.getFatorBalanceamento() == -1)
		{
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento(0);
			no = temp1;
		} 
		else 
		{
			temp2 = (NoAVL) temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp2.getFatorBalanceamento() == -1)
				no.setFatorBalanceamento(1);
			else
				no.setFatorBalanceamento(0);
			if (temp2.getFatorBalanceamento() == 1)
				temp1.setFatorBalanceamento(-1);
			else
				temp1.setFatorBalanceamento(0);
			no = temp2;
		}
		no.setFatorBalanceamento(0);
		this.h = false;
		return no;
	}
	
	private NoAVL rotacaoEsquerda (NoAVL no)
	{
		NoAVL temp1, temp2;
		temp1 = (NoAVL) no.getDir();
		if (temp1.getFatorBalanceamento() == 1)
		{
			no.setDir (temp1.getEsq());
			temp1.setEsq(no);
			no.setFatorBalanceamento(0);
			no = temp1;
		} 
		else 
		{
			temp2 = (NoAVL) temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1)
				no.setFatorBalanceamento(-1);
			else
				no. setFatorBalanceamento(0);
			if (temp2. getFatorBalanceamento() == -1)
				temp1. setFatorBalanceamento(1);
			else
				temp1. setFatorBalanceamento(0);
			no = temp2;
		}
		no.setFatorBalanceamento(0);
		this.h = false;
		return no;
	}
}
