package edu.ics4u.TestProjet;
import java.util.Scanner;

public class Hangman {
	// Liste de objets
	static int compte = 0;
	static String[] mots = {"nuage", "banane", "ordinateur", "vache", "pluie", "eau", "maison"}; // Liste de mots viables
	static String mot = mots[(int) (Math.random() * mots.length)]; // Choisit au hasard un mot pour le jeu du pendu
	static String asterisque = new String(new char[mot.length()]).replace("\0", "*"); // Crée un objet qui est la même longueur du mot mais consist de seulement *

	// Fonction principale
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Bonjour! Bienvenue dans mon jeu de 'hangman', pour gagner vous devez deviner toutes les lettres du mot. Bonne chance!");
			
		// Boucle qui fonctionne jusqu'à temps vous avez pus de vies ou que vous avez la bonne réponse
		while (compte < 6 && asterisque.contains("*")) {
			System.out.print("Devinez une lettre dans le mot: ");
			System.out.println(asterisque);
			String devine = sc.next().toLowerCase();
			hang(devine);
		}
		sc.close();
	}

	// Fonction responsable pour afficher un message lorsque le joueur obtient une mauvaise réponse ou quand qu'il perd le jeu
	public static void faux() {
		if (compte >= 1 && compte <=5) { System.out.println("Mauvaise hypothese, reessayez, il te reste " + (6-compte) + " essaies"); }
		else { System.out.println("JEU TERMINER! le mot etait " + mot); }
	}

	public static void hang(String devine) {
		String nouveau_asterisque = "";
		// Boucle qui remplace * par votre lettre si tu as assumé une lettre dans le mot
		for (int i = 0; i < mot.length(); i++) {
			if (mot.charAt(i) == devine.charAt(0)) { nouveau_asterisque += devine.charAt(0); } 
			else if (asterisque.charAt(i) != '*') { nouveau_asterisque += mot.charAt(i); } 
			else { nouveau_asterisque += "*"; }
		}
		// Si la réponse que vous avez obtenue avant est la même que celle que vous avez maintenant, votre compte augmentera et la class faux() sera appelée
		if (asterisque.equals(nouveau_asterisque)) {
			compte++;
			faux();
		}
		else { asterisque = nouveau_asterisque; }
		// Si toutes les lettres du mot sont devinées, le message de victoire apparaîtra
		if (asterisque.equals(mot)) { System.out.println("Correct! Vous gagnez! Le mot etait " + mot); }
	}
}
