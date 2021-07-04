
public abstract class CompteNonBloque extends Compte {
	/******************************Constructeurs*****************************************************************/
	CompteNonBloque() {  super(); }
	
	 CompteNonBloque(Client client,double solde) {  super (client,solde); }
	 
	 /***************************************************Les M�thodes******************************************************************/
	 /***** Op�ration de retrait *****/
	 public abstract void retrait (double montant) ; //methode abstract
	 
	 /***** Op�ration de versement *****/
	 public void virement(Compte destinataire,double montant) { 
		 
		 if (montant>0 )
		 {   if(montant <= getSolde())
			 {
			 destinataire.setSolde(destinataire.getSolde()+montant);
			 setSolde(getSolde()-montant);
			 }
		 else System.err.println("Virement non autoris� : Solde insuffisant");
		 		
		 }
		 else System.err.println("Erreur de virement : montant n�gatif ou null");
	 }
	
}
