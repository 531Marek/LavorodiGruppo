package com.generation.spesa;

import java.util.Scanner;

public class GestioneListaSpesa {

	public static void main(String[] args) {
		
		//Nel main devi creare un array di oggetti ArticoloSpesa. L’array deve contenere al 
		//massimo 20 articoli. 
		
		ArticoloSpesa []listaArticoli;
		listaArticoli= new ArticoloSpesa[20];
		
		//variabile per contare articoli realmente inseriti
		int numeroArticoli = 0;
		int scelta = 0;
		Scanner tastiera;
		tastiera = new Scanner(System.in);
		
		do
		{
			System.out.println("BENVENUTO NEL MENU: \n"
					+ "1. Aggiungi un articolo alla lista \r\n"
					+ "2. Visualizza tutta la lista della spesa \r\n"
					+ "3. Cerca un articolo per nome \r\n"
					+ "4. Modifica la quantità di un articolo \r\n"
					+ "5. Aggiorna il prezzo di un articolo \r\n"
					+ "6. Applica uno sconto a un articolo \r\n"
					+ "7. Segna un articolo come acquistato \r\n"
					+ "8. Segna un articolo come ancora da acquistare \r\n"
					+ "9. Visualizza solo gli articoli ancora da acquistare \r\n"
					+ "10. Visualizza solo gli articoli già acquistati \r\n"
					+ "11. Visualizza il totale stimato della spesa \r\n"
					+ "12. Visualizza il totale degli articoli già acquistati \r\n"
					+ "13. Visualizza l’articolo più costoso della lista \r\n"
					+ "14. Elimina un articolo dalla lista \r\n"
					+ "15. Esci \n");
			scelta = Integer.parseInt(tastiera.nextLine());
			
			//creo uno switch per far scegliere all' utente cosa fare e un do while per farglielo fare quante volte vuole.
			
			switch(scelta)
			{
			case 1:
				if(numeroArticoli > 20)
				{
					System.out.println("Il tuo carrello della spesa è pieno.");
				}
				else
				{
					ArticoloSpesa nuovoArticolo = new ArticoloSpesa();
					System.out.println("Inserisci il nome articolo: ");
					nuovoArticolo.nome = tastiera.nextLine();
					System.out.println("Inserisci la categoria articolo: ");
					nuovoArticolo.categoria = tastiera.nextLine();
					do
					{
					System.out.println("Inserisci il prezzo unitario: ");
					nuovoArticolo.prezzoUnitario = Double.parseDouble(tastiera.nextLine());
					}while(nuovoArticolo.prezzoUnitario <= 0);
					
					do
					{
					System.out.println("Inserisci la quantità: ");
					nuovoArticolo.quantita = Integer.parseInt(tastiera.nextLine());
					}while(nuovoArticolo.quantita <= 0);
					nuovoArticolo.acquistato = false;
					numeroArticoli = Utility.aggiungiArticolo(listaArticoli, numeroArticoli, nuovoArticolo);
					
					System.out.println("\nArticolo aggiunto. \n");
				}
				
				break;
			case 2:
				for(int i = 0; i<numeroArticoli; i++)
				{
					if(listaArticoli[i] != null)
					System.out.println("\n" +listaArticoli[i].toString()+"\n");
				}
				
				break;
			case 3:
				System.out.println("Inserisci nome articolo che vuoi cercare: ");
				String nomeTemp = tastiera.nextLine();
				
				int tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				if(tempInt != -1)
				{
				    System.out.println(listaArticoli[tempInt]);
				}
				else
				{
				    System.out.println("Articolo non trovato");
				}
				
				break;
			case 4:
				System.out.println("Inserisci nome articolo che vuoi modificare la quantità: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				if(tempInt != -1)
				{
					System.out.println("Vuoi aggiungere o togliere: ");
					String risposta = tastiera.nextLine();
					
					if(risposta.equalsIgnoreCase("aggiungere"))
					{
						System.out.println("Quanto vuoi aggiungere? ");
						int quantita = Integer.parseInt(tastiera.nextLine());
						
						listaArticoli[tempInt].aumentaQuantita(quantita);
					}
					else
					{
						System.out.println("Quanto vuoi togliere? ");
						int quantita = Integer.parseInt(tastiera.nextLine());
						
						listaArticoli[tempInt].riduciQuantita(quantita);
					}
				}
				else
				{
				    System.out.println("Articolo non trovato");
				}
				
				
				break;
			case 5:
				System.out.println("Inserisci nome articolo che vuoi aggiornare il prezzo: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				System.out.println("Inserire importo nuovo: ");
				double importoTemp = Double.parseDouble(tastiera.nextLine());
				
				listaArticoli[tempInt].aggiornaPrezzoUnitario(importoTemp);
				
				break;
			case 6:
				System.out.println("Inserisci nome articolo che vuoi scontare: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				System.out.println("Inserire lo sconto in % che si vuole applicare: ");
				double tempSconto = Double.parseDouble(tastiera.nextLine());
				break;
			case 7:
				System.out.println("Quale articolo vuoi segnare come acquistato: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				listaArticoli[tempInt].segnaComeAcquistato();
				
				break;
			case 8:
				System.out.println("Quale articolo vuoi segnare come ancora da acquistare: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				listaArticoli[tempInt].segnaComeDaAcquistare();
				
				break;
			case 9:
				for(int i = 0; i <numeroArticoli; i++)
				{
					if(listaArticoli[i].acquistato == false)
					{
						System.out.println(listaArticoli[i].toString());
					}
				}
				
				break;
			case 10:
				for(int i = 0; i <numeroArticoli; i++)
				{
					if(listaArticoli[i].acquistato == true)
					{
						System.out.println(listaArticoli[i].toString());
					}
				}
				
				break;
			case 11:
				if(numeroArticoli <=0)
				{
					System.out.println("La tua lista della spesa è vuota.");
				}
				else
				{
					double totale = Utility.calcolaTotaleLista(listaArticoli, numeroArticoli);
					System.out.println("Totale stimato spesa: "+totale);
					
				}
				
				break;
			case 12:
				double totaleAcquistati = Utility.calcolaTotaleAcquistati(listaArticoli, numeroArticoli);
				System.out.println("Totale spesa prodotti acquistati: "+totaleAcquistati);
				
				break;
			case 13:
				if(numeroArticoli <=0)
				{
					System.out.println("La tua lista della spesa è vuota.");
				}
				else
				{
					ArticoloSpesa tempArticolo;
					tempArticolo = listaArticoli[0];
					for (int i = 0; i < numeroArticoli; i++)
					{

				        if (listaArticoli[i].calcolaTotaleArticolo() > tempArticolo.calcolaTotaleArticolo()) {

				            tempArticolo = listaArticoli[i];
				        }
					}
					
					System.out.println(tempArticolo.toString());
				}
				
				
				break;
			case 14:
				System.out.println("Quale articolo vuoi eliminare: ");
				nomeTemp = tastiera.nextLine();
				tempInt = Utility.cercaIndiceArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				numeroArticoli = Utility.eliminaArticolo(listaArticoli, numeroArticoli, nomeTemp);
				
				break;
			case 15:
				System.out.println("Uscita dal menu.");
				
				break;
				
				
			default:
				System.out.println("ERRORE: il numero inserito non corrisponde a nessuna voce.");
				
			}
		}while(!(scelta == 15));

	}

}
