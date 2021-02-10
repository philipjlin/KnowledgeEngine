package knowledgeengine;

/**
 * QueryEngineException.java
 * Exception class for handling invalid query format in input query file.
 * 
 * @author Philip Lin
 */
@SuppressWarnings("serial")

public class QueryEngineException extends Exception{
	
	String message;
	
	/**
	 * Constructor 
	 * 
	 * Default with message
	 */
	public QueryEngineException(){
		
		super("Exception: Invalid Query Format.");
		message = super.getMessage();
	}
	
	/**
	 * Constructor
	 * 
	 * @param message message for exception
	 */
	public QueryEngineException(String message){
		
		super(message);
		this.message = message;
	}
	
	/**
	 * Returns message for exception
	 */
	public String getMessage(){
		
		return message;
	}
	
}