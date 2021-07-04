

	import java.util.Date;
import java.util.Objects;
import java.text.SimpleDateFormat;


	public class Client {

		/*************************************************Les attributs**********************************************************/	
		private String nom, prenom,adresse;
		private Date dateNaissance;
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd MMMM yyyy");//pour écrire la date sous la forme jour mois année

		/******************************Constructeurs*****************************************************************/
		public Client(String nom, String prenom, String adresse,Date dateNaissance) {
			
			this.nom = nom.toUpperCase();
			this.prenom = prenom.substring(0, 1).toUpperCase()+prenom.substring(1).toLowerCase();
			this.adresse = adresse;
			this.dateNaissance = dateNaissance;
			
		                            }
		/***********************************Accesseurs*************************************************************/


		public String getNom() {
			return nom;
		}



		public void setNom(String nom) {
			this.nom = nom;
		}



		public String getPrenom() {
			return prenom;
		}
		


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		

		public String getAdresse() {
			return adresse;
		}



		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}




		public Date getDateNaissance() {
			return dateNaissance;
		}



		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}
		
		
		

		/***************************************************Les Méthodes******************************************************************/
		 /***** toString *****/
		 public String toString ()
			{
				return ( prenom+" "+getNom()+" "+"("+ dateFormat.format(dateNaissance)+")."); //dateFormat.format pour ecrire la date sous la forme jj/mois/aaaa
				
			}

		 /***** Redefinition de la methode equals *****/
		
		 @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Client clt = (Client) obj;
			return Objects.equals(adresse, clt.adresse) && Objects.equals(dateNaissance, clt.dateNaissance) && Objects.equals(nom, clt.nom)
					&& Objects.equals(prenom, clt.prenom);
		}
		
		
	}
		
		

