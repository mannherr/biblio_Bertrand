package metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EmpruntEnCours {
	
	private Date dateEmprunt;	
	private Utilisateur emprunteur = new Utilisateur();
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

	public void setEmprunteur(Utilisateur emprunteur) throws BiblioException {
		this.emprunteur = emprunteur;
		if(!emprunteur.getEmpruntEnCours().contains(this)){
			emprunteur.addEmpruntEnCours(this);	
		}
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) throws BiblioException {
		if(exemplaire.getStatus().equals(EnumStatusExemplaire.PRETE))
			throw new BiblioException("Le livre n'est pas disponible");
		else{
			this.exemplaire = exemplaire;
			this.exemplaire.setStatus(EnumStatusExemplaire.PRETE);
		}	
	}

	public EmpruntEnCours() throws BiblioException{
		this(new Utilisateur());
	}
	
	public EmpruntEnCours(Utilisateur utilisateur) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(new Date());
	}
	
	public EmpruntEnCours(Utilisateur utilisateur, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
	}
	
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setExemplaire(exemplaire);
	}
	
	public EmpruntEnCours(Utilisateur utilisateur, Exemplaire exemplaire, Date date) throws BiblioException{
		this.setEmprunteur(utilisateur);
		this.setDateEmprunt(date);
		this.setExemplaire(exemplaire);
	}
	
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
