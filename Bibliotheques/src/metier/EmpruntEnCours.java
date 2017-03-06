package metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EmpruntEnCours {
	
	/** Variable qui définit la date d'emprunt d'un emprunt en cours */
	private Date dateEmprunt;	
	/** Variable qui définit l'emprunteur d'un emprunt en cours */
	private Utilisateur emprunteur = new Utilisateur();
	/** Variable qui définit l'exemplaire emprunté lors d'un emprunt en cours */
	private Exemplaire exemplaire;

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	/**
	 * Méthode qui définit l'emprunteur de l'emprunt en cours
	 * @param emprunteur Utilisateur de l'emprunt en cours
	 * @throws BiblioException
	 */
	public void setEmprunteur(Utilisateur emprunteur) throws BiblioException {
		this.emprunteur = emprunteur;
		if(!emprunteur.getEmpruntEnCours().contains(this)){
			emprunteur.addEmpruntEnCours(this);	
		}
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	/**
	 * Méthode qui définit l'exemplaire concerné par l'emprunt en cours
	 * @param exemplaire Exemplaire concerné par l'emprunt en cours
	 * @throws BiblioException
	 */
	public void setExemplaire(Exemplaire exemplaire) throws BiblioException {
		if(exemplaire.getStatus().equals(EnumStatusExemplaire.PRETE))
			throw new BiblioException("Le livre n'est pas disponible");
		else{
			this.exemplaire = exemplaire;
			this.exemplaire.setStatus(EnumStatusExemplaire.PRETE);
		}	
	}

	/**
	 * Constructeur par défaut d'un emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours() throws BiblioException{
		this(new Utilisateur());
	}
	
	/**
	 * Constructeur avec paramètre Utilisateur d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(new Date());
	}
	
	/**
	 * Constructeur avec paramètres d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @param date Date d'emprunt de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
	}
	
	/**
	 * Constructeur avec paramètres d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @param exemplaire Exemplaire concerné par l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setExemplaire(exemplaire);
	}
	
	/**
	 * Constructeur avec paramètres d'un emprunt en cours
	 * @param utilisateur Utilisateur concerné par l'emprunt en cours
	 * @param exemplaire Exemplaire concerné par l'emprunt en cours
	 * @param date Date d'emprunt de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
		this.setExemplaire(exemplaire);
	}
	
	/**
	 * Méthode qui définit si le prêt est en retard ou pas
	 * @return
	 */
	public boolean isPretEnRetard(){
		GregorianCalendar dateActuelle = new GregorianCalendar();
		dateActuelle.add(Calendar.DAY_OF_YEAR, -Adherent.getDureeMaxPrets());
		Date dateMinSansRetard = dateActuelle.getTime();
		if(dateMinSansRetard.after(this.getDateEmprunt())){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Méthode qui représente le retour d'un emprunt par un utilisateur
	 * @throws BiblioException
	 */
	public void retourEmprunt() throws BiblioException{
		this.getExemplaire().setStatus(EnumStatusExemplaire.DISPONIBLE);
		this.setEmprunteur(null);
		EmpruntArchive ea = new EmpruntArchive(this.getEmprunteur(),this.getExemplaire(),new Date(),this.getDateEmprunt());
		this.getEmprunteur().getEmpruntEnCours().remove(this);
	}

	@Override
	public String toString() {
		return "EmpruntEnCours [dateEmprunt=" + dateEmprunt + ", exemplaire="
				+ exemplaire + "]";
	}

}
