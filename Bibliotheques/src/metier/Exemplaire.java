package metier;

import java.util.Date;

public class Exemplaire {
	
	/** Variable qui définit l'identifiant d'un exemplaire */
	private int idExemplaire;
	/** Variable qui définit la date d'achat d'un exemplaire */
	private Date dateAchat;
	/** Variable qui définit le statut d'un exemplaire */
	private EnumStatusExemplaire status;
	/** Variable qui définit le numéro ISBN d'un exemplaire */
	private String isbn;
	/** Variable qui définit un emprunt en cours associé à un exemplaire */
	private EmpruntEnCours empruntEnCours;
	
	public int getIdExemplaire() {
		return idExemplaire;
	}
	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public EnumStatusExemplaire getStatus() {
		return status;
	}
	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public EmpruntEnCours getEmpruntEnCours() {
		return empruntEnCours;
	}
	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours) {
		this.empruntEnCours = empruntEnCours;
	}
	
	/**
	 * Constructeur par défaut d'un exemplaire
	 */
	public Exemplaire(){
		this(0, new Date(0), EnumStatusExemplaire.DISPONIBLE, "0");
	}
	
	/**
	 * Constructeur avec paramètres d'un exemplaire
	 * @param id Identifiant de l'exemplaire
	 * @param achat Date d'achat de l'exemplaire
	 * @param status Statut de l'exemplaire
	 * @param isbn Numéro ISBN de l'exemplaire
	 */
	public Exemplaire(int id, Date achat, EnumStatusExemplaire status, String isbn){
		this.setIdExemplaire(id);
		this.setDateAchat(achat);
		this.setStatus(status);
		this.setIsbn(isbn);
	}
	
	@Override
	public String toString() {
		return "Exemplaire [idExemplaire=" + idExemplaire + ", dateAchat=" + dateAchat + ", status=" + status
				+ ", isbn=" + isbn + ", empruntEnCours=" + empruntEnCours + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idExemplaire;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (idExemplaire != other.idExemplaire)
			return false;
		return true;
	}
		
}
