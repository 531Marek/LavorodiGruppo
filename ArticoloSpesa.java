package com.generation.spesa;

public class ArticoloSpesa {

	//attributi - Punto 1
	
	String nome, categoria;
	double prezzoUnitario;
	int quantita;
	boolean acquistato;
	
	//costruttori - Punto 2
	
	//Costruttore senza parametri - Punto 2.1
	
	public ArticoloSpesa() {};
	
	
	//Costruttore con solo nome - Punto 2.2
	
	public ArticoloSpesa(String nome)
	{
		this.nome = nome;
	};
	
	
	//Costruttore con nome, categoria e prezzo - Punto 2.3
	
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario)
	{
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
		
		quantita = 0;
		acquistato = false;
	};
	
	 //Costruttore completo - Punto 2.4
	
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario, int quantita, boolean acquistato)
	{
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.acquistato = acquistato;
	};
	
	
	//Metodi d’istanza - Punto 3
	
	//Stampare i dettagli dell’articolo - Punto 3.1
	
	public String toString()
	{
		return  " Nome: "            + nome                    +
				" Categoria: "       + categoria               +
				" Prezzo unitario: " + prezzoUnitario          +
				" Quantità: "        + quantita                +
				" Totale articolo: " + calcolaTotaleArticolo() +
				" Stato: "           + acquistato              ;
	} 
	
	//Calcolare il totale dell’articolo - Punto 3.2
	
	public double calcolaTotaleArticolo()
	{
		return prezzoUnitario*quantita;
	}
	
	
	//Aumentare la quantità - Punto 3.3
	
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
	
	
	//Ridurre la quantità - Punto 3.4
	
	public void riduciQuantita(int quantitaDatogliere)
	{
		if(quantitaDatogliere<=0)
			System.out.println("ERRORE: il numero inserito è minore o uguale a 0.");
		else
		{
			// quantita-=quantitaDatogliere; Riportato sotto a riga 105
			if(quantita<=0)
				System.out.println("ERRORE: quantità negativa!");
			else
			{
				System.out.println(nome+", quantità iniziale: "+quantita);
				System.out.println("Tolgo "+quantitaDatogliere+" confezioni.");
				quantita-=quantitaDatogliere;
				System.out.println("Nuova quantità: "+quantita+".");
			}
		
		}
		
	}
	
	
	//Aggiornare il prezzo unitario - Punto 3.5
	
	public void aggiornaPrezzoUnitario(double nuovoPrezzo)
	{
		System.out.println("Prezzo stimato del "+nome+": "+prezzoUnitario);
		System.out.println("Prezzo reale al supermercato: "+nuovoPrezzo);
		System.out.println("Aggiorno il prezzo unitario.");
		
		prezzoUnitario=nuovoPrezzo;
		
	}
	
	//Applicare uno sconto percentuale - Punto 3.6
	
	public void applicaSconto(double percentuale) {
	
	if(0 > percentuale || 100 < percentuale){ 
		System.out.println("ERRORE: percentuale non realistica!");
	}else {
		System.out.println("Prezzo iniziale: "+prezzoUnitario);
		System.out.println("Sconto: "+percentuale+"%");
		
		prezzoUnitario -= (prezzoUnitario * percentuale / 100);
		
		System.out.println("Nuovo prezzo: "+prezzoUnitario+" euro.");
	}
	}
	
	//Segnare l’articolo come acquistato - Punto 3.7
	
	public void segnaComeAcquistato()
	{
		acquistato = true;
	}
	
	//Segnare l’articolo come ancora da acquistare - Punto 3.8
	
	public void segnaComeDaAcquistare()
	{
		acquistato = false;
	}
	
	//Controllare se l’articolo è costoso - Punto 3.9
	
	public boolean isCostoso(double prezzoUnit, int quantita)
	{
		if(prezzoUnit*quantita>=20) //return calcolaTotaleArticolo() >= 20; per essere piu veloci e tecnici usando il nostro metodo (consiglio ai)
		{
			return true;
		} else 
		{
		
			return false;
		}
	}
	
	//Metodi statici nella classe ArticoloSpesa - Punto 4
	
	//Controllare se un prezzo è valido - Punto 4.1
	
	static boolean prezzoValido(double prezzo) 
	{
		if(prezzo>=0)
		{
			return true;
		} else 
		{
		
			return false;
		}
	}
	
	//Controllare se una quantità è valida - Punto 4.2
	
	static boolean quantitaValida(int quantita) 
	{
		if(quantita>0)
		{
			return true;
		} else 
		{
		
			return false;
		}
	}
	
	//Confrontare due articoli in base al totale - Punto 4.3
	
	static ArticoloSpesa articoloConTotaleMaggiore(ArticoloSpesa a1, ArticoloSpesa a2)
	{
		
		if(a1.calcolaTotaleArticolo() > a2.calcolaTotaleArticolo())
		{
			return a1;
		} else if(a1.calcolaTotaleArticolo() < a2.calcolaTotaleArticolo())
		{
			return a2;
		} else
		{
			System.out.print("Gli articoli confrontati hanno lo stesso prezzo");
			return a1;
		}
	}

}
