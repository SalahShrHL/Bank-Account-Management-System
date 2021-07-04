
public class ComptePEL extends Compte {
	
	/*************************************************Les attributs**********************************************************/
	public static int pourcentageInterets=3;
	
	/******************************Constructeurs*****************************************************************/
	public ComptePEL() {super();     }
	
	public ComptePEL(Client client, double solde ) {super(client,solde);  }
	
	/***************************************************Les M�thodes******************************************************************/
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}

	public static void setPourcentageInterets(int pourcentageInterets) {
		ComptePEL.pourcentageInterets = pourcentageInterets;
	}
	
	/***************************************************Les M�thodes******************************************************************/
	
	/***** Actualiser le solde (Mise � jour) *****/
	public void actualiser() //Red�finition de la m�thode actualiser
	{  
	  this.setSolde(this.getSolde()+this.getSolde()*pourcentageInterets*0.01); 
	
	}
	
	/***** Red�finition de la m�thode toString *****/
	public String toString ()
	{
	 return ( super.toString()+"ce compte est de type PEL , pourcentage Interets = "+ComptePEL.getPourcentageInterets());
	}

}
