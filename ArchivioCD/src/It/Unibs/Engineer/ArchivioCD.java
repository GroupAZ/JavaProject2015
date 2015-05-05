package It.Unibs.Engineer;

import java.util.ArrayList;
import MyClass.MyVarie;

/**
 * Questa classe setta un archivio CD e ha le seguenti funzionalità:
 * 
 * 
 * 
 * @author Fapanni Tiziano & Simaz Andrea
 *
 */
public class ArchivioCD {
	private ArrayList<Album> collezioneCd;
	
	/**
	 * COSTRUTTORE
	 * 
	 */
	public ArchivioCD() {
		collezioneCd = new ArrayList<Album>();
	}
	
	/**
	 * permette di inserire un nuovo album (CD) in memoria.
	 * @param cd
	 */
	public void inserisciCd(Album cd){		
		if(this.esisteIn(cd.getTitolo())==-1) collezioneCd.add(cd);
	}
	
	/**
	 * metodo di ricerca interna
	 * @param titolo
	 * @return
	 */
	private int esisteIn(String titolo){
		int esiste=-1;
		for(int i=0; i<collezioneCd.size(); i++){
			if(titolo.equals(collezioneCd.get(i).getTitolo())){
				esiste=i;
			}
		}
		return esiste;
	}
	public Album cercaCd(String titolo){
		int indice=esisteIn(titolo);
		
		if(indice>=0) return collezioneCd.get(indice);
		else return null;
	}
	
	public boolean eliminaCd(String titolo){
		return collezioneCd.remove(this.cercaCd(titolo));
	}
	
	public Album cdCasuale(){
		return collezioneCd.get(MyVarie.interoCasuale(collezioneCd.size() - 1, 0));
	}
	
	public String toString(){
		String ritorno = "Archivio CD";
		for(int i = 0; i < collezioneCd.size(); i++){
			ritorno = ritorno + "\n" + collezioneCd.get(i).toStringBreve();
		}
		return ritorno;
	}
}
