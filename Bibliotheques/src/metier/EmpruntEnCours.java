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

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public EmpruntEnCours(){
		this(new Date());
	}
	
	public EmpruntEnCours(Date date){
		this.setDateEmprunt(date);
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
