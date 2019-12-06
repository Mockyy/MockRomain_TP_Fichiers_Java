import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.io.FileReader;

public class fichiersMain {

	public static void main(String[] args){
		
		//Initialistation des compteur de chaque voyelle
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		int y = 0;
		
		//Bloc catch au cas o� une erreur se produit
		try
		{
			//Lecture du fichier
			BufferedReader texte = new BufferedReader(new FileReader("./text.txt"));
			
			//Une chaine qui permet de lire le fichier ligne par ligne
			String ligne;
			
			//Tant que nous ne sommes pas � la fin du fichier...
			while ((ligne = texte.readLine()) != null)
			{				
				//On met la ligne en minuscule
				ligne = ligne.toLowerCase();
				//Et on remplace les caract�res sp�ciaux (�, �, �, �...) par leur �quivalent (a, e, i, o, u)
				ligne = Normalizer.normalize(ligne, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
				
				//On parcourt la ligne
				for(int cpt = 0; cpt < ligne.length(); cpt++)
				{
					//Pour chaque caract�re, on incr�mente le compteur correspondant
					switch(ligne.charAt(cpt))
					{
						case 'a':
							a++;
							break;
						case 'e':
							e++;
							break;
						case 'i':
							i++;
							break;
						case 'o':
							o++;
							break;
						case 'u':
							u++;
							break;
						case 'y':
							y++;
							break;
					}
				}
			}
			
			//On ferme le fichier
			texte.close();
			
			//On passe les compteur � une fonction
			EcrireFichier(a, e, i, o, u, y);
			
			System.out.println("Travail termin� !");
		}
		//Gestion des exceptions
		catch(Exception f) 
		{
			System.out.println(f.getMessage());
		}

	}
	
	//On reporte les compteur dans le fichier
	public static void EcrireFichier(int a, int e, int i, int o, int u, int y)
	{
		try
		{
			//On ouvre le fichier pour �crire dedans
			PrintWriter resultat = new PrintWriter(new FileWriter("./resultat.txt"));
			
			//On �crit les r�sultats
			resultat.write("Nombre de A : " + a + "\n");
			resultat.write("Nombre de E : " + e + "\n");
			resultat.write("Nombre de I : " + i + "\n");
			resultat.write("Nombre de O : " + o + "\n");
			resultat.write("Nombre de U : " + u + "\n");
			resultat.write("Nombre de Y : " + y + "\n");
			
			//On ferme le fichier
			resultat.close();
			
		}
		//Gestion des exceptions
		catch(Exception f)
		{
			System.out.println("Erreur");
			System.out.println(f.getMessage());
		}
	}

}
