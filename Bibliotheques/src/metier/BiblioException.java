package metier;

public class BiblioException extends Exception {

	public BiblioException(){
		this("Une erreur est survenue lors du processus.");
	}
	
	public BiblioException(String message){
		super(message);
	}
	
}
