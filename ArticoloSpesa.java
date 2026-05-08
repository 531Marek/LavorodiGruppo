package com.generation.spesa;

public class ArticoloSpesa {

	//attributi
	
	String nome, categoria;
	double prezzoUnitario;
	int quantita;
	boolean acquistato;
	
	//costruttori
	
	//Costruttore senza parametri
	public ArticoloSpesa() {};
	
	
	//Costruttore con solo nome 
	public ArticoloSpesa(String nome)
	{
		this.nome = nome;
	};
	
	
	//Costruttore con nome, categoria e prezzo
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario)
	{
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
		
		quantita = 0;
		acquistato = false;
	};
	
	 //Costruttore completo
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario, int quantita, boolean acquistato)
	{
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.acquistato = acquistato;
	};
	
	
	//Metodi d’istanza
	
	//Stampare i dettagli dell’articolo 
	public String toString()
	{
		return "Nome: "+nome+
				" Categoria: "+categoria+
				" Prezzo unitario: "+prezzoUnitario+
				"Quantità: "+quantita+
				"Totale articolo: "+calcolaTotaleArticolo()+
				"Stato: "+acquistato;
	}
	
	public double calcolaTotaleArticolo()
	{
		return prezzoUnitario*quantita;
	}
	
	public void aumentaQuantita(int quantitaDaAggiungere)
	{
		if(quantitaDaAggiungere<=0)
			System.out.println("ERRORE: il numero inserito è minore o uguale a 0.");
		else
		{
		System.out.println(nome+", quantità iniziale: "+quantita);
		System.out.println("Aggiungo "+quantitaDaAggiungere+" confezione.");
		quantita+=quantitaDaAggiungere;
		System.out.println("Nuova quantità: "+quantita+".");
		}
		
	}
	
	public void riduciQuantita(int quantitaDatogliere)
	{
		if(quantitaDatogliere<=0)
			System.out.println("ERRORE: il numero inserito è minore o uguale a 0.");
		else
		{
			quantita-=quantitaDatogliere;
			if(quantita<=0)
				System.out.println("ERRORE: quantità negativa!");
			else
			{
				System.out.println(nome+", quantità iniziale: "+quantita);
				System.out.println("Tolgo "+quantitaDatogliere+" confezioni.");
				System.out.println("Nuova quantità: "+quantita+".");
			}
		
		}
		
	}
	
	public void aggiornaPrezzoUnitario(double nuovoPrezzo)
	{
		System.out.println("Prezzo stimato del "+nome+": "+prezzoUnitario);
		System.out.println("Prezzo real al supermercato: "+nuovoPrezzo);
		System.out.println("Aggiorno il prezzo unitario.");
		
		prezzoUnitario=nuovoPrezzo;
		
	}
				
	
}
