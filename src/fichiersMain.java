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
		
		//Bloc catch au cas où une erreur se produit
		try
		{
			//Lecture du fichier
			BufferedReader texte = new BufferedReader(new FileReader("./text.txt"));
			
			//Une chaine qui permet de lire le fichier ligne par ligne
			String ligne;
			
			//Tant que nous ne sommes pas à la fin du fichier...
			while ((ligne = texte.readLine()) != null)
			{				
				//On met la ligne en minuscule
				ligne = ligne.toLowerCase();
				//Et on remplace les caractères spéciaux (é, è, à, ù...) par leur équivalent (a, e, i, o, u)
				ligne = Normalizer.normalize(ligne, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
				
				//On parcourt la ligne
				for(int cpt = 0; cpt < ligne.length(); cpt++)
				{
					//Pour chaque caractère, on incrémente le compteur correspondant
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
			
			//On passe les compteur à une fonction
			EcrireFichier(a, e, i, o, u, y);
			
			System.out.println("Travail terminé !");
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
			//On ouvre le fichier pour écrire dedans
			PrintWriter resultat = new PrintWriter(new FileWriter("./resultat.txt"));
			
			//On écrit les résultats
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
