package metier;

import java.util.Date;

public class Employe extends Utilisateur {

	/** Variable qui d�finit le code identifiant d'un employ� */
	private String codeMatricule;
	/** Variable qui d�finit la cat�gorie d'un employ� */
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
	 * Constructeur par d�faut d'un employ�
	 */
	public Employe(){
		this("Code matricule", EnumCategorieEmploye.BIBLIOTHECAIRE);
	}
	
	/**
	 * Constructeur d'un employ� avec param�tres
	 * @param codeMat Code matricule de l'employ�
	 * @param enumEmploye Cat�gorie de l'employ�
	 */
	public Employe(String codeMat, EnumCategorieEmploye enumEmploye){
		this.setCodeMatricule(codeMat);
		this.setCategorieEmploye(enumEmploye);
	}
	
	/**
	 * Constructeur d'un employ� avec tous les param�tres des classes h�rit�es
	 * @param nom Nom de l'employ�
	 * @param prenom Pr�nom de l'employ�
	 * @param dateNaiss Date de naissance de l'employ�
	 * @param sexe Sexe de l'employ�
	 * @param id Identifiant de l'employ�
	 * @param Pseudo Pseudonym de l'employ�
	 * @param mdp Mot de passe de l'employ�
	 * @param codeMat Code matricule de l'employ�
	 * @param categorie Cat�gorie de l'employ�
	 */
	public Employe(String nom, String prenom, Date dateNaiss, String sexe, int id, String Pseudo, String mdp,String codeMat, EnumCategorieEmploye categorie){
		super(nom, prenom, dateNaiss, sexe, id, Pseudo, mdp);
		this.setCodeMatricule(codeMat);
		this.setCategorieEmploye(categorie);
	}
	
	/**
	 * M�thode qui v�rifie les conditions d'emprunt d'un employ�
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
