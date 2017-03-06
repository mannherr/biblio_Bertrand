package metier;

import java.util.Date;

public class Employe extends Utilisateur {

	/** Variable qui définit le code identifiant d'un employé */
	private String codeMatricule;
	/** Variable qui définit la catégorie d'un employé */
	private EnumCategorieEmploye categorieEmploye;
	
	public String getCodeMatricule() {
		return codeMatricule;
	}
	public void setCodeMatricule(String codeMatricule) {
		this.codeMatricule = codeMatricule;
	}
	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}
	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {
		this.categorieEmploye = categorieEmploye;
	}
	
	/**
	 * Constructeur par défaut d'un employé
	 */
	public Employe(){
		this("Code matricule", EnumCategorieEmploye.BIBLIOTHECAIRE);
	}
	
	/**
	 * Constructeur d'un employé avec paramètres
	 * @param codeMat Code matricule de l'employé
	 * @param enumEmploye Catégorie de l'employé
	 */
	public Employe(String codeMat, EnumCategorieEmploye enumEmploye){
		this.setCodeMatricule(codeMat);
		this.setCategorieEmploye(enumEmploye);
	}
	
	/**
	 * Constructeur d'un employé avec tous les paramètres des classes héritées
	 * @param nom Nom de l'employé
	 * @param prenom Prénom de l'employé
	 * @param dateNaiss Date de naissance de l'employé
	 * @param sexe Sexe de l'employé
	 * @param id Identifiant de l'employé
	 * @param Pseudo Pseudonym de l'employé
	 * @param mdp Mot de passe de l'employé
	 * @param codeMat Code matricule de l'employé
	 * @param categorie Catégorie de l'employé
	 */
	public Employe(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp,String codeMat, EnumCategorieEmploye categorie){
		super(nom, prenom, dateNaiss, sexe, id, Pseudo, mdp);
		this.setCodeMatricule(codeMat);
		this.setCategorieEmploye(categorie);
	}
	
	/**
	 * Méthode qui vérifie les conditions d'emprunt d'un employé
	 * @return Retourne l'acceptation des conditions
	 */
	public boolean isConditionsPretAcceptees(){
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + "Employe [codeMatricule=" + codeMatricule + ", categorieEmploye=" + categorieEmploye + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeMatricule == null) ? 0 : codeMatricule.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (codeMatricule == null) {
			if (other.codeMatricule != null)
				return false;
		} else if (!codeMatricule.equals(other.codeMatricule))
			return false;
		return true;
	} 
}
