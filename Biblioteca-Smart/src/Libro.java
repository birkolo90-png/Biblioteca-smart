//Classe libro
public class Libro {
	
	//Attributi principali del libro
	private int id;
	private String titolo;
	private String autore;
	private int anno;
	private boolean disponibile;
	
	//Costruttore che crea un nuovo libro con i dati ricevuti
	public Libro(int id, String titolo, String autore, int anno) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.disponibile = true;
	}
	//Getter: permettono di leggere i dati privai del libro
	public int getId() {
			return id;
	}
	public String getTitolo() {
		return titolo;
	}
	public String getAutore() {
		return autore;
	}
	public int getAnno() {
		return anno;
	}
	@Override
	public String toString() {
		
		return ("Id: " + id + "\nTitolo: " + titolo + "\nAutore: " + autore + "\nAnno: " + anno);
	}
	//Metodo che controlla se un libro è disponibile
	public boolean isDisponibile() {
		return disponibile;
	}
	//Metodi di stato
	public void Presta() {
		disponibile = false;
	}
	public void Restituisci() {
		disponibile = true;
	}
	//Rappresentazione testuale del libro quando viene stampato
	public void setTitolo(String nuovoTitolo) {
		this.titolo = nuovoTitolo;	
	}
	public void setAutore(String nuovoAutore) {
		this.autore = nuovoAutore;	
	}
	public void setAnno(int nuovoAnno) {
		this.anno = nuovoAnno;	
	}
}
