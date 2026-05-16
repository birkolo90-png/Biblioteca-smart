import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner per leggere input da tastiere 
		Scanner scanner = new Scanner(System.in);
		//Creazione dell'oggetto biblioteca
		Biblioteca biblioteca = new Biblioteca();
		/*Classe principale:
		 * gestisce il menu e l'iterazione  con l'utente
		 * continua finché l'utente non sceglie di uscire
		*/
		boolean running = true;
		
		while(running) {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Aggiungi libro");
			System.out.println("2. Cerca per ID");
			System.out.println("3. Cerca per autore");
			System.out.println("4. Mostra tutti i libri");
			System.out.println("5. Elimina Libro per Id");
			System.out.println("6. Modifica Libro");
			System.out.println("7. Presta Libro");
			System.out.println("8. Restituisci Libro");
			System.out.println("0. Esci");
			System.out.println("------------------");
			System.out.println("Inserisci scelta: ");
		
		int scelta = scanner.nextInt();
		scanner.nextLine();
		//Gestione delle scelte del menu
		switch (scelta) {
		//Aggiunta nuovo libro
		case 1: {
			System.out.println("Inserisci Id");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Inserisci titolo");
			String titolo = scanner.nextLine();
			System.out.println("Inserisci autore");
			String autore= scanner.nextLine();
			System.out.println("Insersici anno");
			int anno = scanner.nextInt();
			scanner.nextLine();
			
			Libro libro = new Libro(id, titolo, autore, anno);
			boolean aggiungi = biblioteca.aggiungiLibro(libro);
			
			if(aggiungi) {
				System.out.println("Libro aggiunto");
			} else {
				System.out.println("Id presente");

			}
			break;
		}
		//Ricerca libro tramite id
		case 2: {
			System.out.println("Inserisci Id");
			int id = scanner.nextInt();
			biblioteca.cercaLibroPerId(id);
			break;
		}
		//Ricerca un libro tramite autore
		case 3: {
			System.out.println("Inserisci autore");
			String autore = scanner.nextLine();
			biblioteca.cercaAutore(autore);
			break;
		}
		//Mostra i libri presenti 
		case 4: {
			biblioteca.mostraLibri();
			break;
		}
		//Eliminazione del libro tramite Id
		case 5: {
			System.out.println("Inserisci Id del libro da eliminare");
			int id = scanner.nextInt();
			scanner.nextLine();
			boolean eliminato = biblioteca.remuvePerId(id);
			
			if(eliminato) {
				System.out.println("Libro eliminato correttamente");
			} else {
				System.out.println("Libro non trovato");
			}
			break;
		}
		//Modifica dati di un libro
		case 6: {
			System.out.println("Inserisci Id");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Inserisci titolo");
			String nuovoTitolo = scanner.nextLine();
			System.out.println("Inserisci autore");
			String nuovoAutore = scanner.nextLine();
			System.out.println("Inserisci anno");
			int nuovoAnno = scanner.nextInt();
			scanner.nextLine();
			
			boolean modifica = biblioteca.modificaLibro(id, nuovoTitolo, nuovoAutore, nuovoAnno);
			
			if(modifica) {
				System.out.println("Libro modificato!");
			} else {
				System.out.println("Libro non trovato");
			}
			break;
		}
		//Cerca un libro e lo da in prestito
		case 7: {
			System.out.println("Inserisci Id");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			boolean prestato = biblioteca.prestaLibro(id);
			if(prestato) {
				System.out.println("Libro trovato, buona lettura");
			} else {
				System.out.println("Il Libro desiderato non c'è o è stato prestato");
			}
			break;
		}
		//Controlla che il libro non sia in catalogo, se non lo è lo prende in consegna
		case 8: {
			System.out.println("Inserisci Id");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			boolean restituisci = biblioteca.restituisciLibro(id);
			if(restituisci) {
				System.out.println("Libro Restituito correttamente");
			} else {
				System.out.println("Libro non trovato oppure già disponibile");
			}
			break;
		}
		//L'uscita dal ciclio
		case 0: {
			biblioteca.salvaFile();
			running = false;
			System.out.println("Programma terminato");
			break;
		}
		default:
			System.out.println("Scelta non valida");
			
			}
		}
		scanner.close();

	}
}
