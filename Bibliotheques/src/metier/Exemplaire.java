package metier;

import java.util.Date;

public class Exemplaire {

	/** Variable qui d�finit l'identifiant d'un exemplaire */
	private int idExemplaire;
	/** Variable qui d�finit la date d'achat d'un exemplaire */
	private Date dateAchat;
	/** Variable qui d�finit le statut d'un exemplaire */
	private EnumStatusExemplaire status;
	/** Variable qui d�finit le num�ro ISBN d'un exemplaire */
	private String isbn;
	/** Variable qui d�finit un emprunt en cours associ� � un exemplaire */
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

	public void setEmpruntEnCours(EmpruntEnCours empruntEnCours) throws BiblioException {
		this.empruntEnCours = empruntEnCours;
		if(empruntEnCours.getExemplaire()==null)
			empruntEnCours.setExemplaire(this);
	}

	/**
	 * Constructeur par d�faut d'un exemplaire
	 */
	public Exemplaire(){
		this(0, new Date(0), EnumStatusExemplaire.DISPONIBLE, "0");
	}

	/**
	 * Constructeur avec param�tres d'un exemplaire
	 * @param id Identifiant de l'exemplaire
	 * @param achat Date d'achat de l'exemplaire
	 * @param status Statut de l'exemplaire
	 * @param isbn Num�ro ISBN de l'exemplaire
	 */
	public Exemplaire(int id, Date achat, EnumStatusExemplaire status, String isbn){
		this.setIdExemplaire(id);
		this.setDateAchat(achat);
		this.setStatus(status);
		this.setIsbn(isbn);
	}

	/**
	 * M�thode qui repr�sente le retour d'un exemplaire par un utilisateur
	 * @throws BiblioException
	 */
	public void retourEmprunt() throws BiblioException{
		EmpruntArchive ea = new EmpruntArchive(this, new Date(), this.getEmpruntEnCours().getDateEmprunt());
		this.getEmpruntEnCours().getEmprunteur().getEmpruntEnCours().remove(this.getEmpruntEnCours());
		this.setStatus(EnumStatusExemplaire.DISPONIBLE);
		this.empruntEnCours = null;
	}

	@Override
	public String toString() {
		return "Exemplaire [idExemplaire=" + idExemplaire + ", dateAchat=" + dateAchat + ", status=" + status
				+ ", isbn=" + isbn + "]";
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
