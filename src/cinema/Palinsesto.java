package cinema;

import java.util.Iterator;
import java.util.LinkedList;

public class Palinsesto implements Iterable <Proiezione>{

	// CAMPI
	private String nome_cinema;
	private LinkedList <Proiezione> lista; // lista di proiezioni
	
	// COSTRUTTORI
	public Palinsesto () {
		this.nome_cinema = "Cinemax";
		this.lista = new LinkedList <Proiezione> ();
	}

	public Palinsesto (String nome_cinema) {
		this.nome_cinema = nome_cinema;
		this.lista = new LinkedList <Proiezione> ();
	}
	
	public Palinsesto (String [] dati) {
		this.nome_cinema = "Cinemax";
		this.lista = new LinkedList <Proiezione> ();	// istanziare la lista di proiezioni
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
	
	public Palinsesto cercaProiezione () {										// cercare la proiezione con la data odierna
		Palinsesto lista_oggi = new Palinsesto ("Cinemax oggi");
		Data oggi = new Data ();												// data odierna
		for (Proiezione tmp : lista)
			if (tmp.getData().equals(oggi))
				lista_oggi.aggiungiProiezione(tmp);
		return lista_oggi;
	}

	@Override
	public Iterator<Proiezione> iterator() {
		return lista.iterator();
	}

	@Override
	public String toString () {
		String ris = "";
		for (Proiezione tmp : lista)
			ris += "\n " + tmp.toString();
		return "Palinsesto di " + nome_cinema + ris;
	}
}
