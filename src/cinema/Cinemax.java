package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cinemax {

	public static void main(String[] args) {
		
		// palinsesto
		Palinsesto pal;
		
		String sep = File.separator;
		
		try {
			//costruzione dello stream di caratteri
			//FileReader frd = new FileReader("."+sep+"docs"+sep+"test.txt");
			
			File f = new File("."+sep+"data"+sep+"proiezioni.csv");
			
			//calcola il numero di righe nel file CSV
			BufferedReader bfr = new BufferedReader(new FileReader(f));
			String str;
			int i = 0;
			bfr.readLine();
			while ((str = bfr.readLine()) != null) {
				i++;
			}
			
			String [] dati = new String [i];
			
			// occorre resettare il reader!
			// legge il file ".csv" riga per riga
			BufferedReader bfr2 = new BufferedReader(new FileReader(f));
			String str2;
			int i2 = 0;
			bfr2.readLine();
			while ((str2 = bfr2.readLine()) != null) {
				dati[i2++] = str2;
			}

			// caricare i dati nel palinsesto
			pal = new Palinsesto (dati);
			
			// cercare proiezione con data odierna
			Palinsesto pal_oggi = pal.cercaProiezione();
			
			// stampa
			// "Proiezione di " + pro.getData().toString() + pro.getTitolo()
			// "Proiezione di 16-05-2026: Star Wars: The Mandalorian and Grogu"
			if (pal_oggi == null)
				System.err.println("Nessuna proiezione trovata per oggi");
			else
				System.out.println("Proiezione/i di oggi:");
				for (Proiezione tmp : pal_oggi)
					System.out.println(tmp.visualizzaProiezione());
			
			//chiusura dello stream
			bfr.close();
			bfr2.close();
		
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato :-(");
		} catch (IOException e) {
			System.err.println("Errore I/O imprevisto :-(");
		}
		

	}

	
}
