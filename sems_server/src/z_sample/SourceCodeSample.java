package z_sample;
import java.util.*;

/**
 * Let us implement all source code in English.
 * <br />
 * Exemplu de indentare si de comentare a claselor si metodelor proiect.
 * <br />
 * <br />
 * Obligatoriu de folosit!!
 * <br />
 * Acest comentariu deserveste clasa din acest fisier.
 * <br />
 * Aici apare descrierea clasei
 * <br />
 * A se avea in vedere:
 * <br />
 * - acolada apare la sfarsitul randului
 * <br />
 * - pe rand nou, tabul este de 4 spatii
 * <br />
 * - cuvintele si simbolurile sunt despartite de spatii
 * <br />
 * - linia are maxim 80 de caractere, indiferent ca e vorba de cod sau comment
 * <br />
 * - numele metodelor incepe cu litera mica
 * <br />
 * - al doilea cuvant din denumiri incepe cu litera mare
 * <br />
 * taguri: 
 * 
 * @author nume_autor
 * aici putem pune semigrupa 221/2, sau fiecare isi pune numele pe clasa 
 * creata de el. stabilim ulterior :)
 *  
 * @version 1.0
 * sau alta versiune, sau renuntam la versiune
 * 
 * 
 */

public class SourceCodeSample {
	/**
	 * Comentariul acesa deserveste atributul i. Daca aveti ceva
	 * de zis despre el, aici este locul
	 * 
	 * javadoc proceseaza doar campurile publice si protejate, nu si cele
	 * private, by default
	 * 
	 * in ce priveste atributele, folositi alt tip de acces decat cel privat
	 * doar pentru cele statice, atunci cand este necesar
	 */
	public static int i = 1;
	
	/**
	 * Comentariu care deserveste metoda de mai jos - descrierea metodei
	 * <br />
	 * taguri pentru metoda:
	 *  
	 * @param args Descrierea parametrului cu numele args. In cazul de fata
	 * putem zice ca: Parametrul este un Array de stringuri.
	 * Descrierea parametrului se termina la intalnirea utmatorului tag
	 * 
	 * @return Aici nu e cazul, dar tagul acesta explica ce returneaza metoda
	 * in cauza. da un warning la generare javadoc din cauza ca metoda 
	 * returneaza void
	 * 
	 * @throws exceptions No exceptions thrown.
	 * in cazul in care se arunca o exceptie, primul cuvant dupa tag-ul throws
	 * este numele clasei din care face parte exceptia aruncata 
	 * (ex: IOException in loc de exceptions)
	 * 
	 */
	public static void main (String[] args) {
		if (i == 1){
			System.out.print("Azi e: ");
			System.out.println(new Date ());
		}
	}
	/*
	 * Acest comment nu va intra in javadoc. Daca cineva mai are alte obervatii
	 * sau recomandari legate de indentare, spatiere sau commenturi, completati
	 * si/sau modificati acest fisier exemplu.
	 */
	
	//Nu mai adaugati clase in acest pachet!!!
	
}
