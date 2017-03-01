package metier;

public class Employe extends Utilisateur {

	private String codeMatricule;
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
	
	public Employe(){
		this("Code matricule", EnumCategorieEmploye.BIBLIOTHECAIRE);
	}
	
	public Employe(String codeMat, EnumCategorieEmploye categorie){
		this.setCodeMatricule(codeMat);
		this.setCategorieEmploye(categorie);
	}
	
	@Override
	public String toString() {
		return "Employe [codeMatricule=" + codeMatricule + ", categorieEmploye=" + categorieEmploye + "]";
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
