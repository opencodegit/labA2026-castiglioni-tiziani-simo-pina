package cinema;

public class Cinemax2 {

	public static void main(String[] args) {
		// palinsesto
		Palinsesto pal;

		// dati
		// un insieme di proiezioni in formato array di stringhe
		String [] dati = 	{"2026-05-13, Il diavolo veste Prada 2",
							 "2026-05-14, Michael",
							 "2026-05-15, Star Wars: The Mandalorian and Grogu",
							 "2026-05-16, Mortal Kombat II",
							 "2026-05-17, Il diavolo veste Prada 2",
							 "2026-05-18, Michael",
							 "2026-05-19, Star Wars: The Mandalorian and Grogu"};
		
		// aggiungere proiezione
		pal = new Palinsesto (dati);
		
		// cercare proiezione con data odierna
		Palinsesto pal_oggi = pal.cercaProiezione();
		
		// stampa
		// "Proiezione di " + pro.getData().toString() + pro.getTitolo()
		// "Proiezione di 16-05-2026: Star Wars: The Mandalorian and Grogu"
		if (pal_oggi == null)
			System.err.println("Proiezione di oggi: Nessuna proiezione trovata");
		else
			System.out.println("Proiezione di oggi: " + pal_oggi.toString());
	}

}
