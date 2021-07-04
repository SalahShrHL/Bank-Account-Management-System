
public class CompteLDD extends CompteNonBloque{
	
	/*************************************************Les attributs**********************************************************/
	 public static int pourcentageInterets=2;
	 private static  double seuil=1000;
 
	 /******************************Constructeurs*****************************************************************/
	 public CompteLDD()
		{
			super();
		}
	 
	 
	 public CompteLDD(Client client,double solde)
		{
		 super (client,solde);
		}
	 
	 /***********************************Accesseurs*************************************************************/
	public static int getPourcentageInterets() {
		return pourcentageInterets;
	}

	public static void setPourcentageInterets(int pourcentage) {
		CompteLDD.pourcentageInterets = pourcentage;
	}

	public static double getSeuil() {
		return seuil;
	}

	public static void setSeuil(double seuil) {
		CompteLDD.seuil = seuil;
	}
	 
	/***************************************************Les Méthodes******************************************************************/
	 /***** Redéfinition de la méthode retrait *****/
	public void retrait(double montant){
		//permet de retirer un montant positif du solde du compte,
		double solde=getSolde();
		if (montant>0){
			if (solde >= montant){
				if(montant<= seuil) {
					this.setSolde( solde - montant);
				} else System.err.println("Erreur de retrait : vous allez depassé le seuil");
				
			}else{System.err.println("Retrait non autorisé(solde insuffisant)");}
		}else{System.err.println("montant négatif ou null");}
	}

	 /***** Déposer de l'argent *****/
		public void depot(double montant){
			//permet de déposer un montant positif dans le solde du compte, 
			if (montant > 0){
				this.setSolde(this.getSolde() + montant);
				this.actualiser();
			                  }
			else System.err.println("Erreur de dépot : montant négatif ou null");
		}
	 
	/***** Actualiser le solde (Mise à jour) *****/
	public void actualiser()//Redéfinition de la méthode actualiser
	{  
	  this.setSolde(this.getSolde()+this.getSolde()*pourcentageInterets*0.01); 
	
	}
	
	/***** Redéfinition de la méthode toString *****/
	public String toString ()
	{
	 return ( super.toString()+" ce compte est de type LDD ,seuil (max) = "+CompteLDD.getSeuil()+" , pourcentage Interets = "+CompteLDD.getPourcentageInterets());
	}


}
