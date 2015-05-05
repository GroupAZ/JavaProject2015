
package It.Unibs.Engineer;
import java.util.ArrayList;
import MyClass.*;
/**
 * Questa classe setta un album con dei brani e offre alcune funzionalità fra cui:
 * _Aggiunge un brano in un lista di brani (che formano l'album);
 * _Get un brano a caso dell'album;
 * _Get titolo album;
 * _Selezione di un brano dell'album;
 * _Get descrizione completa dell'album (con i relativi brani);
 * _Get descrione parziale dell'album (senza brani);
 * @author Andrea e Tiziano
 *
 */

public class Album {

	private String titoloAlbum, autore;
	private ArrayList<Brano> brani;
	
/**
 * Costruttore della classe Album
 * @param titoloAlbum
 * @param autore
 */
	public Album(String titoloAlbum, String autore){
		this.titoloAlbum = titoloAlbum;
		this.autore = autore;
		brani = new ArrayList<>();
	}
	
	/**
	 * Riceve in ingresso un oggetto di tipo Brano e lo aggiunge all'array di brani. Se esiste già un brano 
	 * con lo stesso nome, non lo aggiunge.
	 * @param canzone arraylist contenente titolo e durata del brano.
	 */
	public void addBrano(Brano canzone){
		
		boolean esiste = false;
		
		for(int i = 0; i < brani.size(); i++){
			   if(canzone.getTitolo().equals(brani.get(i).getTitolo())){
				   esiste = true;
			   }
		}	
		
		if(esiste == false){
			brani.add(canzone);
		}		
	}
	
	/**
	 * Ritorna un brano a caso dell'album.
	 * @return branoRandom ritorna il titolo e la durata di un brano a caso dell'album
	 */
	public Brano branoRandom(){
		int indice = MyVarie.interoCasuale(brani.size() - 1, 0);
		Brano branoRandom = brani.get(indice);
		return branoRandom;
		
	}

	/**
	 * Ritorna il titolo dell'album.
	 * @return titoloAlbum.
	 */
	public String getTitolo() {
		return titoloAlbum;
	}
	
/**
 * Seleziona un brano dell'album
 * @param n Brano selezionato
 * @return branoSelezionato se valido, null se inserimento invalido
 * 
 */
	public Brano selezionaBrano(int n) throws IndexOutOfBoundsException{

			Brano branoSelezionato = brani.get(n);
		    return branoSelezionato;
	
	}

/**
 * 
 * @return Descrizione completa dell'album con autore e brani
 */
     public String toString(){
    	 String inizio = ("Titolo Album : " + titoloAlbum + "\nAutore : " + autore + "\n");
         String listaBrani = "";
    	 for(int i = 0; i < brani.size(); i++){
    		 listaBrani = listaBrani + brani.get(i).toString();
    	 }
    	 return (inizio + listaBrani);
     }
     
     
 /**
  * Descrizione parziale dell'album senza titoli dei brani    
  * @return breve descrizipone parziale album
  */
     
     public String toStringBreve(){
    	 String breve = ("Titolo Album : " + titoloAlbum + "\nAutore : " + autore + "\n");
    	 return breve;
     }
	
}
