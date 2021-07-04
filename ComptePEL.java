
public class ComptePEL extends Compte {
	
	/*************************************************Les attributs**********************************************************/
	public static int pourcentageInterets=3;
	
	/******************************Constructeurs*****************************************************************/
	public ComptePEL() {super();     }
	
	public ComptePEL(Client client, double solde ) {super(client,solde);  }
	
	/***************************************************Les Méthodes******************************************************************/
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}

	public static void setPourcentageInterets(int pourcentageInterets) {
		ComptePEL.pourcentageInterets = pourcentageInterets;
	}
	
	/***************************************************Les Méthodes******************************************************************/
	
	/***** Actualiser le solde (Mise à jour) *****/
	public void actualiser() //Redéfinition de la méthode actualiser
	{  
	  this.setSolde(this.getSolde()+this.getSolde()*pourcentageInterets*0.01); 
	
	}
	
	/***** Redéfinition de la méthode toString *****/
	public String toString ()
	{
	 return ( super.toString()+"ce compte est de type PEL , pourcentage Interets = "+ComptePEL.getPourcentageInterets());
	}

}
