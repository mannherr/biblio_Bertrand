package metier;

import java.util.Date;

public class EmpruntArchive {

	/** Variable qui d�finit la date de restitution effective d'un emprunt */
	private Date dateRestitutionEff;
	/** Variable qui d�finit la date d'emprunt d'un exemplaire */
	private Date dateEmprunt;
	/** Variable qui d�finit l'utilisateur concern� par l'emprunt */
	private Utilisateur emprunteur = new Utilisateur();
	/** Variable qui d�finit l'exemplaire concern� par l'emprunt */
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

	/**
	 * Constructeur par d�faut d'un emprunt archiv�
	 */
	public EmpruntArchive(){
		this(new Exemplaire(), new Date(), new Date(0));
	}

	/**
	 * Constructeur par d�faut d'un emprunt archiv�
	 * @param exemplaire Exemplaire concern� par l'emprunt � archiver
	 * @param dateRestitution Date de restitution effective de l'emprunt � archiver
	 * @param dateEmprunt Date d'emprunt de l'emprunt � archiver
	 */
	public EmpruntArchive(Exemplaire exemplaire, Date dateRestitution, Date dateEmprunt){
		this.setExemplaire(exemplaire);
		this.setDateRestitutionEff(dateRestitution);
		this.setDateEmprunt(dateEmprunt);
	}

	public static void main (String [] args){

		EmpruntArchive ea = new EmpruntArchive () ;

	}


}
