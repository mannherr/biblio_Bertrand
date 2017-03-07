package metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EmpruntEnCours {

	/** Variable qui d�finit la date d'emprunt d'un emprunt en cours */
	private Date dateEmprunt;
	/** Variable qui d�finit l'emprunteur d'un emprunt en cours */
	private Utilisateur emprunteur = new Utilisateur();
	/** Variable qui d�finit l'exemplaire emprunt� lors d'un emprunt en cours */
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
	 * M�thode qui d�finit l'emprunteur de l'emprunt en cours
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
	 * M�thode qui d�finit l'exemplaire concern� par l'emprunt en cours
	 * @param exemplaire Exemplaire concern� par l'emprunt en cours
	 * @throws BiblioException
	 */
	public void setExemplaire(Exemplaire exemplaire) throws BiblioException {
		if(exemplaire.getStatus().equals(EnumStatusExemplaire.PRETE))
			throw new BiblioException("Le livre n'est pas disponible");
		else{
			this.exemplaire = exemplaire;
			exemplaire.setEmpruntEnCours(this);
			exemplaire.setStatus(EnumStatusExemplaire.PRETE);
		}
	}

	/**
	 * Constructeur par d�faut d'un emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours() throws BiblioException{
		this(new Utilisateur());
	}

	/**
	 * Constructeur avec param�tre Utilisateur d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(new Date());
	}

	/**
	 * Constructeur avec param�tres d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @param date Date d'emprunt de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
	}

	/**
	 * Constructeur avec param�tres d'un emprunt en cours
	 * @param utilisateur Utilisateur de l'emprunt en cours
	 * @param exemplaire Exemplaire concern� par l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setExemplaire(exemplaire);
	}

	/**
	 * Constructeur avec param�tres d'un emprunt en cours
	 * @param utilisateur Utilisateur concern� par l'emprunt en cours
	 * @param exemplaire Exemplaire concern� par l'emprunt en cours
	 * @param date Date d'emprunt de l'emprunt en cours
	 * @throws BiblioException
	 */
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
		this.setExemplaire(exemplaire);
	}

	/**
	 * M�thode qui d�finit si le pr�t est en retard ou pas
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

	@Override
	public String toString() {
		return "EmpruntEnCours [dateEmprunt=" + dateEmprunt + ", exemplaire="
				+ exemplaire + "]";
	}

}
