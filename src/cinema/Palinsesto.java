package cinema;

import java.util.LinkedList;

public class Palinsesto {

	// CAMPI
	private String nome_cinema;
	private LinkedList <Proiezione> lista; // lista di proiezioni
	
	// COSTRUTTORI
	public Palinsesto () {
		nome_cinema = "Cinemax";
		lista = new LinkedList <Proiezione> ();
	}
	
	public Palinsesto (String [] dati) {
		nome_cinema = "Cinemax";
		lista = new LinkedList <Proiezione> ();	// istanziare la lista di proiezioni
		Proiezione pro;
		for (String tmp : dati) {				// un sottoelemento "tmp" dell'array "dati" contiene una stringa con dati di una proiezione
			pro = new Proiezione (tmp);			// chiamare il costruttore Proiezione (String dati), che istanzia una proiezione con tutti i dati contenuti in una unica stringa
			aggiungiProiezione (pro);			// chiamare il metodo "aggiungiProiezione (Proiezione pro)", che aggiunge una proiezione al palinsesto
		}
	}
	
	// METODI
	public String getNomeCinema () {
		return this.nome_cinema;
	}
	
	public void aggiungiProiezione (Proiezione pro) {
		lista.add(pro);
	}
	
	public Proiezione cercaProiezione () {		// cercare la proiezione con la data odierna
		Data oggi = new Data ();				// data odierna
		for (Proiezione tmp : lista)
			if (tmp.getData().equals(oggi))
				return tmp;
		return null;
	}
	
	@Override
	public String toString () {
		String ris = "";
		for (Proiezione tmp : lista)
			ris += "\n " + tmp.toString();
		return "Palinsesto di " + nome_cinema + ris;
	}
}
