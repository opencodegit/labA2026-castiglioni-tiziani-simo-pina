package cinema;

public class Proiezione {

	// CAMPI
	private Data data;
	private String titolo;
//  private LinkedList <Prenotazione> lista;
	
	// COSTRUTTORI
	public Proiezione (String data, String titolo) {
//		lista = new LinkedList <Prenotazione> ();
		this.data = new Data (data);
		this.titolo = titolo;
	}
	
	public Proiezione (String dati) {
//		lista = new LinkedList <Prenotazione> ();
		String [] array = dati.split(",");				// creare un array con le parti della stringa "dati" separate dalla virgola - ovvero dall'espressione regolare -regex- (",").
		this (array[0], array[1]);						// invocare il costruttore sopra "Proiezione (String, String)"
	}
	
	// METODI
	public Data getData () {
		return this.data;
	}
	
	public String getTitolo () {
		return this.titolo;
	}
	
	public String visualizzaProiezione () {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "Proiezione del " + this.data.toString() + ", titolo: " + this.titolo;
	}
	
}
