package cinema;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

	// CAMPI
	private int giorno;
	private int mese;
	private int anno;
	private static char separatore = '-';
	
	// COSTRUTTORI
	public Data () {
		GregorianCalendar oggi = new GregorianCalendar ();
		this.giorno = oggi.get(Calendar.DAY_OF_MONTH);
		this.mese = oggi.get(Calendar.MONTH)+1; 				// aggiungere "+1" a "MONTH" perche' "MONTH" e' un ENUM e quindi il suo valore numerico va da "0" a "11", ovvero, "JANUARY" ha il valore "0"
		this.anno = oggi.get(Calendar.YEAR);
	}
	
	public Data (String data) {
		// dati nel file      - > "2026-05-19", "The Blues Brothers"
        // substring position - > 01234567890
		this.giorno = Integer.parseInt(data.substring(9,11));  	// substring incomincia all'indice 8 e si ferma all'indice 10-1=9 
		this.mese = Integer.parseInt(data.substring(6,8));		// substring incomincia all'indice 5 e si ferma all'indice 7-1=6
		this.anno = Integer.parseInt(data.substring(1,5));		// substring incomincia all'indice 0 e si ferma all'indice 4-1=3
	}
	// METODI
	public int getGiorno () {
		return this.giorno;
	}
	
	public int getMese () {
		return this.mese;
	}
	
	public int getAnno () {
		return this.anno;
	}
	
	public static char getSeparatore () {
		return separatore;
	}
	
	public static void setSeparatore (char c) {
		separatore = c;
	}
	
	public boolean equals (Data d) {
		return this.anno == d.getAnno() && this.mese == d.getMese() && this.giorno == d.getGiorno(); 
	}
	
	public boolean isMaggiore (Data d) {
		return this.anno > d.getAnno() || (this.anno == d.getAnno() && this.mese > d.getMese()) || (this.anno == d.getAnno() && this.mese == d.getMese() && this.giorno > d.getGiorno());
	}
	
	@Override
	public String toString () {
		// return giorno + "-" + mese + "-" + anno
		String ris ="";
		String stringaGiorno = (this.giorno < 10 ? "0" : "") + this.giorno;
		String stringaMese = (this.mese < 10 ? "0" : "") + this.mese;
		ris = stringaGiorno + separatore + stringaMese + separatore + String.valueOf(this.anno);
		return ris;
	}
}
