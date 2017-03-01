package metier;

import java.util.Date;

public class EmpruntArchive {
	
	private Date dateRestitutionEff;
	private Date dateEmprunt;
	private Utilisateur emprunteur = new Utilisateur();
	private Exemplaire exemplaire = new Exemplaire();
	
	
	
	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}
	
	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}
	
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public EmpruntArchive(){
		this(new Date(), new Date(0));
	}
	
	public EmpruntArchive(Date dateRestitution, Date dateEmprunt){
		this.setDateRestitutionEff(dateRestitution);
		this.setDateEmprunt(dateEmprunt);		
	}
	
	public static void main (String [] args){
		
		
		EmpruntArchive ea = new EmpruntArchive () ;
		ea.getEmprunteur().
		
		
	} //main
	
		
} //class>
