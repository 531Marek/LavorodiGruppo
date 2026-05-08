package com.generation.spesa;

import java.util.Scanner;

public class GestioneListaSpesa {

	public static void main(String[] args) {
		
		String ArticoloSpesa[];
		int numeroArticoli = 0;
		int esci = 0;
		int scelta = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("---  BENVENUTO!  ---\n\n");
			System.out.println("---  COSA VUOI FARE OGGI?  ---\n");
			System.out.println("1. AGGIUNGI UN ARTICOLO ALLA LISTA\n"
							+ "2. VISUALIZZA TUTTA LA LISTA DELLA SPESA\n"
							+ "3. CERCA UN ARTICOLO PER NOME\n"
							+ "4. MODIFICA LA QUANTITA DI UN ARTICOLO\n"
							+ "5. AGGIORNA IL PREZZO DI UN ARTICOLO\n"
				         	+ "6. APPLICA UNO SCONTO A UN ARTICOLO\n"
				         	+ "7. SEGNA UN ARTICOLO COME ACQUISTATO\n"
				         	+ "8. SEGNA UN ARTICOLO COME ANCORA DA ACQUISTARE\n"
				         	+ "9. VISUALIZZA SOLO GLI ARTICOLI ANCORA DA ACQUISTARE\n"
				         	+ "10 VISUALIZZA SOLO GLI ARTICOLI GIA ACUISTATI\n"
				         	+ "11. VISUALIZZA IL TOTALE STIMATO DELLA SPESA\n"
				         	+ "12. VISUALIZZA IL TOTALE DEGLI ARTICOLI GIA ACQUISTATI\n"
				         	+ "13. VISUALIZZA L'ARTICOLO PIU COSTOSO DELLA LISTA\n"
				         	+ "14. ELIMINA UN ARTICOLO DALLA LISTA\n"
				         	+ "15. ESCI\n");
			
			System.out.print("Inserisci la tua scelta: ");
			scelta = scanner.nextInt();
			
		
		
			switch (scelta) 
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			default:
				System.out.print("Scelta non valida\n\n");
			}
		
		} while(scelta != 15);
		
		
		
	}

}
