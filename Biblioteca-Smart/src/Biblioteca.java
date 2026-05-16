import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class Biblioteca {

	//Attributi 
	ArrayList<Libro> listaLibri = new ArrayList<>();	
	
	//Costruttore
	public Biblioteca() {
			caricaFile();
	}
	//Metodo che consente di aggiungere un nuovo libro e controlla che non sia già presente
	public boolean aggiungiLibro(Libro libro) {

		if(cercaLibroPerId(libro.getId()) == null) {
			
			listaLibri.add(libro);
			return true;
		} else {
			return false;
	   }
	}
	//Metodo che mostra i libri gia presenti
	public void mostraLibri() {
		
		if(listaLibri.isEmpty()) {
			System.out.println("Nessun libro presente");
		}else {
			for(Libro libro : listaLibri) {
				System.out.println(libro);
			}
		}
	}
	//Metodo che ricerca un libro per ID
	public Libro cercaLibroPerId(int id) {
		
		for( int i = 0; i < listaLibri.size(); i++) {
			Libro libro = listaLibri.get(i);
			if(libro.getId() == id) {
				System.out.println("id trovato: " + id);	
				return libro;
			}
			if(libro != null) {
				
			}
		}
		return null;
	}
	//Metodo che permette di cercare per Autore 
	public ArrayList<Libro> cercaAutore(String Autore) {
		
		ArrayList<Libro> listaRisultati = new ArrayList<>();
		for( int i = 0; i < listaLibri.size(); i++) {
			Libro libro = listaLibri.get(i);
			if(libro.getAutore().equals(Autore)) {	
				listaRisultati.add(libro);
			}
		}
		return listaRisultati;
	}
	//Metodo che permette di rimuovere un libro dalla biblioeca usando l'Id
	public boolean remuvePerId(int id) {
		
		for(int i = 0; i < listaLibri.size(); i++ ) {
			 listaLibri.get(i);
			 Libro libro = listaLibri.get(i);
			if(libro.getId() == id) {
				listaLibri.remove(i);
			return true;
			}
		}
			return false;
	}
	//Metodo che permette di modificare il libro andando a modificare i parametri che lo compongono
	public boolean modificaLibro(int id, String nuovoTitolo, String nuovoAutore, int nuovoAnno) {
		
		for(int i = 0; i < listaLibri.size(); i++) {
			Libro libro = listaLibri.get(i);
			
			if(libro.getId() == id) {
				libro.setTitolo(nuovoTitolo);
				libro.setAutore(nuovoAutore);
				libro.setAnno(nuovoAnno);
				
				return true;
			}
		}
		return false;
	}
	//Verifica se un libro è disponibile e se c'è lo presta
	 public boolean prestaLibro(int id) {
		 
		 Libro libro = cercaLibroPerId(id);
		 if(libro != null) {
		 if(libro.isDisponibile()) {
			 libro.Presta();
			 return true;
		 }
	   }
		 return false;
	 }
	 //Verifica se un libro non è disponibile e se non c'è lo inserisce 
	public boolean restituisciLibro(int id) {
		
		Libro libro = cercaLibroPerId(id);
		if(libro != null) {
			if(!libro.isDisponibile()) {
				
				libro.Restituisci();
				return true;
			} 
				
		}
		return false;
	}
	/*
	 * Salva tutti i libri presenti nella lista
	 * all'interno del file biblioteca.txt.
	 * 
	 * Ogni libro viene convertito in una riga separata
	 * da ";" per poter essere riletta successivamente.
	 */
	public void salvaFile() {
		
		try {
			FileWriter salva = new FileWriter("biblioteca.txt");
			for(Libro libro : listaLibri) {
				String riga = libro.getId() + ";" +
							  libro.getTitolo() + ";" +
			                  libro.getAutore() + ";" + 
			                  libro.getAnno() + ";" + 
			                  libro.isDisponibile() + "\n";
					salva.write(riga);
					} 
			salva.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
   }
	/*
	 * Carica i libri del file biblioteca.txt e li reinserisce
	 * nella listaLibri.
	 * 
	 * Ogni riga del file viene separata tramite split(";")
	 * per ricostruire gli oggetti Libro.
	 */
	public void caricaFile() {
		
		try {
		BufferedReader lettore = new BufferedReader (new FileReader("biblioteca.txt"));

		String riga = lettore.readLine();
		
		while(riga != null) {
			String[] dati = riga.split(";");
			int id = Integer.parseInt(dati[0]);
			String titolo = dati[1];
			String autore = dati[2];
			int anno = Integer.parseInt(dati[3]);
			boolean disponibile = Boolean.parseBoolean(dati[4]);
			Libro libro = new Libro(id, titolo, autore, anno);
			listaLibri.add(libro);
			if(disponibile == false) {
				libro.Presta();
			}
			riga = lettore.readLine();
		}
			lettore.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}