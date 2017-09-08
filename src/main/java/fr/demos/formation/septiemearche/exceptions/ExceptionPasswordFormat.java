package fr.demos.formation.septiemearche.exceptions;

public class ExceptionPasswordFormat extends Exception {
	
	private int passwordLength;
	
	public ExceptionPasswordFormat (String message) {
		super(message);
	}
	
	public ExceptionPasswordFormat (String message, int passwordLength){
		super(message);
		this.passwordLength = passwordLength;
	}	
}
