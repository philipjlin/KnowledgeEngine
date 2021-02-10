package knowledgeengine;

/**
 * ImportException.java
 * Exception class for handling invalid query format in input query file.
 * 
 * @author Philip Lin
 */
@SuppressWarnings("serial")

public class ImportException extends Exception{
	
	String message;
	
	/**
	 * Constructor 
	 * 
	 * Default with message
	 */
	public ImportException(){
		
		super("Exception: Invalid Input Triple Format.");
		message = super.getMessage();
	}
	
	/**
	 * Constructor
	 * 
	 * @param message message for exception
	 */
	public ImportException(String message){
		
		super(message);
		this.message = message;
	}
	
	/**
	 * Returns message associated with exception
	 */
	public String getMessage(){
		
		return message;
	}
	
}