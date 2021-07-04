import java.util.Date;
public class Principale {

	public static void main(String[] args) {
		//Créer une banque
		Banque B;
        B=new Banque ();
        
        /***************************************************Créer les clients Ahmed et Mohamed******************************************************************/ 
        Client c1,c2;
		c1= new Client("a","ahmed","",new Date());
		c2=new Client("b","mohamed","",new Date());
	
		/***** Ajouter les clients à la banque *****/
	    B.ajouterClient(c1);
	    B.ajouterClient(c2);
	
	    /***************************************************Créer les comptes******************************************************************/
	    Compte x1,x2,x3 ;
	    
	    /**Compte Courant de Ahmed**/
	    x1= new CompteCourant(c1,0,-500);
	    B.NouvCompte(x1);
	    //Ajouter 1000 sur le compte
	    B.Créditer(1000,x1.getNumero());
	    //Retirer 100
		B.Débiter(100,x1.getNumero());
		//Retirer 2000
		B.Débiter(2000,x1.getNumero());
	    
		/**Compte Epargne logement de Ahmed**/
	    x3= new ComptePEL(c1,0);
	    ComptePEL.pourcentageInterets=3 ;
	    B.NouvCompte(x3);
	    //Ajouter 200
	    B.Créditer(200,x3.getNumero());
         
	  /**Compte Courant de Ahmed**/
	    x2 =new CompteCourant(c1,0,0);
	    B.NouvCompte(x2);
	   //Ajouter 800
	    B.Créditer(800,x2.getNumero());
	   
	    /***********************************Afficher le contenu de la banque*************************************************************/
	    B.afficherBan();
	
	}

	}


