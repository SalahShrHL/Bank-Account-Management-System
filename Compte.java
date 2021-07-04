import java.util.concurrent.atomic.AtomicInteger ;
import java.util.Date;
public abstract class Compte {

	/*************************************************Les attributs**********************************************************/
private static final AtomicInteger ID = new AtomicInteger(0); //identificateur qui incremente d'une maniere automatique
	
	private Client titulaire;
    private  int numero;
	private double solde;
	/******************************Constructeurs*****************************************************************/
	public Compte() { 
		               this.titulaire=new Client("","","",new Date());
		               this.solde=0;
		              
	                 }
	

	public Compte(Client titulaire, double solde) 
	
	{
		if (solde>=0){
		this.titulaire = titulaire;
		this.solde = solde;
		this.numero= ID.incrementAndGet();
		          }
		 
		
		else System.err.println("vous ne pouvez pas crée un compte avec un solde négatif !!");
	}

	/***********************************Accesseurs*************************************************************/
     
	public Client getTitulaire() {
		return titulaire;
	}


	public int getNumero() {
		return numero;
	}

	
	
	
	
	public double getSolde() {
		return solde;
	}


	protected void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	
	/***************************************************Les Méthodes******************************************************************/
    /***** Déposer de l'argent *****/
	public void depot(double montant){
		//permet de déposer un montant positif dans le solde du compte, 
		if (montant > 0){
			this.setSolde(this.getSolde() + montant);
		                  }
		else{
			System.err.println("Erreur de dépot : montant négatif ou null");
		      }
	}
	 /***** Actualiser *****/
	  public abstract void actualiser() ;   //methode abstract	
	
	 
	
	  /***** toString *****/
	
	   public String toString ()
		{
		   return "Le compte N° "+ numero+ " à " + getSolde() + " da, son propriétaire est : " + getTitulaire().toString();
		}
		
	
	


}
