import java.util.Vector;  // pour déclarer les attributs tablclient et tablcompte de type vector
public class Banque {
/*************************************************Les attributs**********************************************************/	
	
	
	
	private String nom;
	private String adresse;
	private Vector<Client> tablclient ;
	private Vector <Compte>tablcompte ;
	
	
	
	/******************************Constructeurs*****************************************************************/
	
	public Banque () { this("",""); }
	
	
	public Banque(String nom, String adresse){
		
		this.nom = nom;
		this.adresse = adresse;
		this.tablclient = new Vector<Client>();
		this.tablcompte = new Vector<Compte>();
	                                        
	                                         }
	
	/***********************************Accesseurs*************************************************************/
	public String getNom()                   { 	return this.nom; }
	public void setNom(String nom)           {  this.nom = nom;  }
	
	
	
	
	public String getAdresse()                {  return this.adresse;     }
	public void setAdresse(String adresse)    {   this.adresse = adresse; }
	
	
	
	public Vector<Client> geTtablclient()     {  return this.tablclient;  }
	public Vector<Compte> getTablcompte()     {   return this.tablcompte;  }

	

	
	
/***************************************************Les Méthodes******************************************************************/
	
	 /*************************************Ajouter client ************************************************************/
	
	
	
	// il faut d'aboprd assurer que le client n'existe pas
	
	
	// cherche un client par son nom ( le client est identifier d'une maniére unique par son nom )dans le tableau des clients
	
	public boolean chercherClient(String nom){
		
		Client cl;
		int i = 0;
		
		
		while ( i< tablclient.size()  )
		{
			cl = tablclient.get(i);
			if (nom==cl.getNom() ) { return true; }
			i++;		
		}
		
		return false ;

	                                              }
	
	
	                           /*----------------------------------*/
	
	//ajouter un client aprés assurer qu'il n'existe pas
	
	
	public void ajouterClient(Client cl){


		if (     this.chercherClient(cl.getNom())  ==false  )       {	tablclient.add(cl);	 }
		
		           else System.out.println(" Le client : "+ cl.toString() + " existe déjà  " );

	                                    }
	

	
	
	
	/*************************************************************************************************************/
	
	 /*************************************Ouvrire  un nouveau compte ************************************************************/
	
	
	//avant ajouter a un client un compte courant on doit assurer que ce client n'a pas un compte courant
	
	public boolean  chercherCompteCourant(Compte x){
		
		int i = 0;
		while ( i<tablcompte.size() )
		{
			Compte cp;
			cp = tablcompte.get(i);
			if (  (cp.getTitulaire()).getNom()==  (x.getTitulaire()).getNom()  )   {return true ; }
			         
			i++;
		}
		return false;
	}
	
	
	
                //Ajouter un compte	
	
	public void NouvCompte(Compte c){
		
		if(c instanceof CompteCourant )
			    if( chercherCompteCourant(c)==false )    {  tablcompte.add(c); }
			   else System.out.println(" Un client ne peut pas avoir deux comptes courants  " );
		else tablcompte.add(c);
		
	                                    } 

	
	
/************************************Débiter un compte dont on connait le numéro*****************************************/	
	
	
	public void Débiter(double montant,int num){
		
		Compte x;
		int i = 0;
		
		
		
		           while (i<tablcompte.size()){
			
    	x=	tablcompte.get(i);
    	
     if ( num == x.getNumero())		
	   { if(x instanceof CompteNonBloque ) {
		CompteNonBloque y ;
		y=    (CompteNonBloque) tablcompte.get(i);
	    y.retrait(montant);
	    }else System.out.println("Retrait non autorisé");
	    }
                                     
				
                      i++;
	
	                                               }
	}
	
	
	
	/************************************Créditer un compte dont on connait le numéro*****************************************/	
	
	
	
	
public void Créditer(double montant,int num){
		
		Compte x;
		int i = 0;
		
		
		
		           while (i<tablcompte.size() ){
			
    	x=	tablcompte.get(i);
    	
    /* if (x instanceof CompteLDD && num == x.getNumero())		
	   {  
		CompteLDD y ;
		y=   (CompteLDD) tablcompte.get(i);
	    y.depot(montant);
		cpt=1;
	    }  else */ if( num== x.getNumero()) { x.depot(montant); } 
                                     
				
                      i++;
	
	                                               }

}
/***********************Afficher le solde et le nom du titulaire d'un compte dont on connait le numéro***********************/
		
	
	

	
	
	
	public void afficher(int num){
		
		

		Compte x;
		int i = 0;
		int cpt=0;
		
		
		           while (i<tablcompte.size() && cpt==0){
			
    	x=	tablcompte.get(i);
	if(x.getNumero()==num)	{
	    
		             System.out.println("le nom du titulaire : "+(x.getTitulaire()).getNom()+" .le solde = "+x.getSolde()+" DA");
	                             cpt=1;                          }
                                                     
				
                      i++;
		
		           }
		
		
			
		                            }
	
	
	        /*************************************************/
  /* Chercher dans listeCompte s'il existe un compte dont le numéro est 
	 indiqué en paramètre à la méthode. Cette méthode retourne ce compte s'il en existe un
	 retourne null sinon
  */
	
	
	
	public Compte chercherCompte(int numero){
		
		Compte c;
		int i = 0;
		
		while (i<tablcompte.size())
		{
			c = tablcompte.get(i);
			if (numero == c.getNumero()){return c;}
			i++;
		}
		return null ;
	
	                                      }
	
	
	/********************************Afficher la liste des comptes qui sont à découvert***********************************/
	
	
	
	
	
     public void afficherCompteDecouvert()
     {
    	 Compte c;
    	 int i = 0;
    	 int cpt=0;
    	 System.out.println("Liste des comptes à decouvert :");
 		
 		while (i<tablcompte.size())
 		{
 			c = tablcompte.get(i);
 			if(c.getSolde()<0)
 			{   
 				System.out.println(c.getNumero());
 				cpt=cpt+1;
 			}
 			i++;
 		}
    	 if (cpt==0) {
    		 System.out.println("Pas de Compte");
    	 }
    	 
    	 
	 }
     
 /*****************Affichier les clients et les comptes***************************************/
     
     public void afficherBan()
     {
    	 Compte c;
    	 Client cl;
    	 int i = 0;
 		
    	 System.out.println("LA LISTE DES COMPTES :");
    	 
 		while (i<tablcompte.size())
 		{
 			c = tablcompte.get(i);
 			System.out.println(c.toString());
 			i++;
 		}
 		System.out.println("LA LISTE DES CLIENTS :");
    	 i=0;
 		while (i<tablclient.size())
 		{
 			cl = tablclient.get(i);
 			System.out.println(cl.toString());
 			i++;
 		}
    	 
	 }


}
