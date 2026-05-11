package com.generation.spesa;

public class Utility {
	
	//Classe dove inseriremo i metodi del main
	
	// 1. Aggiungere un articolo all’array
	
	public static int aggiungiArticolo(ArticoloSpesa[] lista, int numeroArticoli, ArticoloSpesa nuovoArticolo)
	{
		for(int i = 0; i<=numeroArticoli; i++)
		{
			if(lista[i] == null)
			{
				lista[i] = nuovoArticolo;
				numeroArticoli++;
				break;
			}
		}
		
		
		
		return numeroArticoli;
	}
	
	// 2. Cercare un articolo per nome
	public static int cercaIndiceArticolo(ArticoloSpesa[] lista, int numeroArticoli, String nome)
	{
		
		
		for(int i = 0; i < numeroArticoli; i++)
		{
			if(lista[i].nome.equalsIgnoreCase(nome))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	// 3. Calcolare il totale stimato della lista
	
	public static double calcolaTotaleLista(ArticoloSpesa[] lista, int numeroArticoli)
	{
		double totale = 0.0;
		
		for(int i=0; i < numeroArticoli; i++)
		{
			totale += lista[i].calcolaTotaleArticolo();
		}
		
		return totale;
	}
	
	// 4. Calcolare il totale degli articoli acquistati
	
	public static double calcolaTotaleAcquistati(ArticoloSpesa[] lista, int numeroArticoli)
	{
		double totaleAcquistati = 0.0;
		for(int i = 0; i < numeroArticoli; i++)
		{
			if(lista[i].acquistato == true)
			{
				totaleAcquistati+=lista[i].calcolaTotaleArticolo();
			}
			
		}
		
		return totaleAcquistati;
	}
	
	// 5. Calcolare il totale degli articoli ancora da acquistare
	
	public static double calcolaTotaleDaAcquistare(ArticoloSpesa[] lista, int numeroArticoli)
	{
		double totaleNonAcquistati = 0.0;
		for(int i = 0; i < numeroArticoli; i++)
		{
			if(lista[i].acquistato == false)
			{
				totaleNonAcquistati+=lista[i].calcolaTotaleArticolo();
			}
			
		}
		
		return totaleNonAcquistati;
	}
	
	//6.  Trovare l’articolo più costoso 
	
	public static ArticoloSpesa trovaArticoloPiuCostoso(ArticoloSpesa[] lista, int numeroArticoli)
	{
		ArticoloSpesa max = lista[0];
		
		for(int i = 1; i < numeroArticoli; i++)
		{
			if(lista[i].calcolaTotaleArticolo() > max.calcolaTotaleArticolo())
			{
				max = lista[i];
			}
		}
		
		return max;
	}
	
	//7. Eliminare un articolo dalla lista 
	
	public static int eliminaArticolo(ArticoloSpesa[] lista, int numeroArticoli, String nome)
	{
		for(int i = 0; i<numeroArticoli; i++)
		{
			if(lista[i] != null && lista[i].nome.equalsIgnoreCase(nome))
			{
				lista[i] = null;
				
				for(int j = i; j<numeroArticoli - 1; j++)
				{
					lista[j]=lista[j+1];
				}
				
				lista[numeroArticoli - 1] = null;
			}
			
		}
		
		return numeroArticoli;
		
	}
	
	
}
