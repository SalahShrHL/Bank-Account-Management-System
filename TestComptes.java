import java.util.Date;

public class TestComptes {

	public static void main(String[] args) {
		
		/***** Créer des Clients *****/
		Client c1 = new Client("aithmed","samir","dd",new Date(1970-1900,03,12));
		Client c2 = new Client("belhi","salah","dd",new Date(2002-1900,01,01));
		
		/***** Créer CompteCourant *****/
		System.out.println("Test des méthodes de la classe CompteCourant :");
		CompteCourant a = new CompteCourant(c1,0,-700);
		//Tester les méthodes de la classe CompteCourant
		a.depot(1000);
		a.retrait(100);		//retrait (montant<solde)
		a.retrait(1200);	//retrait (montant>solde)==>Compte Decouvert
		a.retrait(900);		//retrait non autorisé (montant>solde + depassement de seuil)
		System.out.println(a.toString());
		
		/***** Créer CompteLDD *****/
		System.out.println("Test des méthodes de la classe CompteLDD :");
		CompteLDD b = new CompteLDD(c1,500);
		//Tester les méthodes de la classe CompteLDD
		b.depot(300);
		b.retrait(50);
		b.retrait(800);
		System.out.println(b.toString());
		
		/***** Créer ComptePEL *****/
		System.out.println("Test des méthodes de la classe ComptePEL :");
		ComptePEL c = new ComptePEL(c2,500);
		c.depot(800);
		c.actualiser();
		System.out.println(c.toString());
		
		/***** Tester la méthode virement de la classe CompteNonBloque *****/
		System.out.println("Test de la méthode de versement :");
		if(a.getTitulaire().equals(b.getTitulaire())) 	//Tester la méthode equals da la classe client
		{
			a.virement(b, 100);
		}

	}

}
