
public class CompteCourant extends CompteNonBloque {
	
	/*************************************************Les attributs**********************************************************/
	 public static int pourcentageAgios=5;
		private double seuilDecouvert;
		
		/******************************Constructeurs*****************************************************************/
		
		public CompteCourant()
		{
			super(); 
		}
		
		
		public CompteCourant(double seuilDecouvert)
		{
			super();
			this.seuilDecouvert = seuilDecouvert ; 
		}
		
		
		
		
		public CompteCourant(Client client,double solde,double seuilDecouvert)
		{
			super(client,solde);
			this.seuilDecouvert = seuilDecouvert ; 
		}
		
		/***********************************Accesseurs*************************************************************/
		
		public double getSeuilDecouvert()
		{
			return this.seuilDecouvert;
		}
		
		public void setSeuilDecouvert(double seuilDecouvert)
		{
			this.seuilDecouvert = seuilDecouvert;
		}
		
		public static int getPourcentageAgios()
		{
			return pourcentageAgios;
		}
		
		public static void setPourcentageAgios(int pourcentage)
		{
			pourcentageAgios = pourcentage ;
		}
		
		/***************************************************Les M�thodes******************************************************************/
		
		 /***** Retirer de l'argent *****/
		public void retrait(double montant)
		{
	       
	     
	      
			if(montant > 0)
			{  
				double x;
				x = this.getSolde() - montant;
				if (x<0) {
					if(x > this.seuilDecouvert)                                 
					{
			           this.setSolde(x);
			        // selon l'enonc� Le solde du compte est actualis� apr�s chaque op�ration en tenant compte des �ventuels frais de d�couvert	donc on  actualise le solde apres chaque retrait ou virement		
					   actualiser();
					   System.out.println("Il faut que tu payes les agios");
					} 
					else System.err.println("Vous ne pouvez pas retirait ce montant (Depassement du seuil de decouvert)");
				}else setSolde(x);
				
					
			} else System.err.println("ERREUR : la valeur du montant est n�gatif ou null");
			
		}
		
	 /***** Actualiser le solde en tenant compte les eventuelles frais de d�couvert *****/
		public void actualiser()
		
		{  
			double Agios ;
			 if(this.getSolde() < 0)
				 {        Agios=  this.getSolde() * pourcentageAgios*0.01;       
			
				         this.setSolde(this.getSolde() + Agios);
		            }
		
		}
		 /***** Red�finition de la m�thode toString *****/
		
		public String toString ()
		{
		 return ( super.toString()+" seuil de decouvert = "+this.getSeuilDecouvert()+" pourcentage Agios = "+CompteCourant.getPourcentageAgios());
		}

}
