package models.ABB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import models.Arquivo;
import models.Data;
import models.Horario;
import models.Multa;
import models.interfaces.Item;

public class ArvoreABB
{
	protected NoAbb raiz;
	protected int quant;
	
	public ArvoreABB() 
	{
		this.raiz = null;
		this.quant = 0;
	}
	
	public ArvoreABB(Arquivo arquivo)
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
	
	public NoAbb pesquisar(String chave) 
	{
		return pesquisar (chave, this.raiz);
	}
	
	private NoAbb pesquisar(String chave, NoAbb no) 
	{
	    while (no != null) 
	    {
	        int comparacao = chave.compareTo((String) no.getItem().getChavePrimaria());
	        
	        if (comparacao == 0)
	            return no;
	        else if (comparacao > 0)
	            no = no.getDir();
	        else
	            no = no.getEsq();
	    }
	    return null;
	}
		
	public void inserir (Item item) 
	{
		this.raiz = inserir (item, this.raiz);
		this.quant++;
	}
	
	private NoAbb inserir(Item item, NoAbb no) 
	{
		NoAbb atual = no;
		NoAbb pai = null;

		while (atual != null) 
		{
			pai = atual;
			if (((String) item.getChavePrimaria()).compareTo((String) atual.getItem().getChavePrimaria()) > 0)
				atual = atual.getDir();
			else
				atual = atual.getEsq();
		}

		if (pai == null)
			return new NoAbb(item);
		else if (((String) item.getChavePrimaria()).compareTo((String) pai.getItem().getChavePrimaria()) > 0)
			pai.setDir(new NoAbb(item));
		else
			pai.setEsq(new NoAbb(item));

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
	
	private ArrayList<Item> fazCamCentral(NoAbb no, ArrayList<Item> vetor) {
	    Stack<NoAbb> stack = new Stack<>();
	    NoAbb atual = no;

	    while (atual != null || !stack.isEmpty()) 
	    {
	        while (atual != null) 
	        {
	            stack.push(atual);
	            atual = atual.getEsq();
	        }

	        atual = stack.pop();
	        vetor.add(atual.getItem());
	        atual = atual.getDir();
	    }

	    return vetor;
	}
	
	public ArvoreABB balancear () 
	{
		ArvoreABB arv = new ArvoreABB();
		ArrayList<Item> vetor = CamCentral();
		balancear (vetor, arv, 0, quant-1);
		return arv;
	}

	private void balancear (ArrayList<Item> vetor, ArvoreABB arv,int inicio, int fim) 
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
