package models.arvoreBinaria;

import java.util.ArrayList;

import models.Arquivo;
import models.Data;
import models.Horario;
import models.Multa;
import models.interfaces.Item;

public class Abb 
{
	private NoAbb raiz;
	private int quant;
	
	public Abb() 
	{
		this.raiz = null;
		this.quant = 0;
	}
	
	public Abb(Arquivo arquivo)
	{
		ArrayList<String> linhas = arquivo.lerLinhas();
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
	
	public NoAbb pesquisar(String chave) 
	{
		return pesquisar (chave, this.raiz);
	}
	
	private NoAbb pesquisar(String chave, NoAbb no) 
	{
		if (no == null)
			return null;
		
		int comparacao = chave.compareTo((String) no.getItem().getChavePrimaria());
		
		if (comparacao == 0)
			return no;
		else if (comparacao > 0)
			return pesquisar(chave, no.getDir());
		else
			return pesquisar(chave, no.getEsq());
	}
		
	public boolean inserir (Item item) 
	{
		this.raiz = inserir (item, this.raiz);
		this.quant++;
		return true;
	}
	
	private NoAbb inserir (Item item, NoAbb no) 
	{
		if (no == null) 
		{
			no = new NoAbb(item);
		} else if (((String) item.getChavePrimaria()).compareTo((String) no.getItem().getChavePrimaria()) > 0) {
			no.setDir(inserir (item, no.getDir()));
		} else {
			no.setEsq(inserir (item, no.getEsq()));
		}
		return no;
	}
	
	public void remover (String chave) 
	{
		this.remover(chave, this.raiz);
		this.quant--;
	}
	
	private NoAbb remover (String chave, NoAbb no) 
	{
		if (no == null)
			return null;
		else if (chave.compareTo((String) no.getItem().getChavePrimaria()) > 0)
			no.setDir(remover(chave, no.getDir()));
		else if (chave.compareTo((String) no.getItem().getChavePrimaria()) < 0)
			no.setEsq(remover(chave, no.getEsq()));
		else if (no.getEsq() == null)
			return no.getDir();
		else if (no.getDir() == null)
			return no.getEsq();
		else
			no.setEsq(arruma (no, no.getEsq()));
		return no;
	}
	
	private NoAbb arruma (NoAbb no, NoAbb maior) 
	{
		if (maior.getDir() != null)
			maior.setDir(arruma(no, maior.getDir()));
		else 
		{
			no.setItem(maior.getItem());
			maior = maior.getEsq();
		}
		return maior;
	}
	
	public ArrayList<Item> CamCentral () 
	{
		ArrayList<Item> vetor = new ArrayList<>();
		return (fazCamCentral(this.raiz, vetor));
	}
	
	private ArrayList<Item> fazCamCentral (NoAbb no, ArrayList<Item> vetor) 
	{
		if (no != null) 
		{
			vetor = this.fazCamCentral(no.getEsq(), vetor);
			vetor.add(no.getItem());
			vetor = this.fazCamCentral(no.getDir(), vetor);
		}
		return vetor;
	}
	
	public Abb balancear () 
	{
		Abb arv = new Abb();
		ArrayList<Item> vetor = CamCentral();
		balancear (vetor, arv, 0, quant-1);
		return arv;
	}

	private void balancear (ArrayList<Item> vetor, Abb arv,int inicio, int fim) 
	{
		int meio;
		if (inicio <= fim) 
		{
			meio = (inicio+fim)/2;
			arv.inserir(vetor.get(meio));
			balancear (vetor, arv, inicio, meio-1);
			balancear(vetor, arv, meio+1, fim);
		}
	}
}
