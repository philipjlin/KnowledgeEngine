package knowledgeengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@SuppressWarnings("resource")

/**
 * QueryEngine class
 * Handles and reads content of input query text files. Individual Strings queries are
 * extracted individually from the input file and placed in a list to be used by the
 * KnowledgeGraph.
 *
 * The queries are used by the KnowledgeGraph class to map queries to Triples.
 *
 * @author Philip Lin
 */
public class QueryEngine{

	private List<String> queryList = new ArrayList<String>();
	String query;


	/**
	 * Executes and prints an individual query using the KnowledgeGraph.
	 * The results of the query are printed if the query exists in the KnowledgeGraph.
	 *
	 * @param query String query to execute
	 */
	public void executeQuery(String query){

		System.out.println(query);

		//check if query is in the KnowledgeGraph
		if( KnowledgeGraph.getInstance().getQueryMapSet().containsKey(query) ){

			//print all Triples associated with query
			for( Triple t : KnowledgeGraph.getInstance().executeQuery(query) ){

	    			System.out.println(t.getIdentifier());
			}
		}
		else
			System.out.println("<null>");

		System.out.println("");
	}

	/**
	 * Imports the query file specified by the filename. The input file is scanned
	 * with a Scanner object using a delimiter, which produces individual queries.
	 * These queries are checked for proper formatting and passed into a List that
	 * the KnowledgeGraph class uses to construct its query Map.
	 *
	 * An exception is thrown if any of the query Strings are improperly formatted
	 * An exception is also thrown if the file to import can't be found.
	 *
	 * @param filename name of the input file with triples
	 */
	public void importQueryFile(String filename){

		try{

			File file = new File(filename);

			Scanner importedQueries = new Scanner(file).useDelimiter("\\."); //split file by "."

			while( importedQueries.hasNext() ){ //iterate through all queries

				query = importedQueries.next().toLowerCase().trim();

				 //check that query isn't a blank line at end of file and is properly formatted
				if( !query.equals("") ){

					if ( query.matches("(\\w+|\\?)(\\s)(\\w+|\\?)(\\s)(\\w+|\\?)") )
						queryList.add(query);
					else
						throw new QueryEngineException(); //throw exception if improperly formatted
				}
			}
	    }
	    catch( FileNotFoundException fnfe ){

	    		System.out.println("Exception: Query File Not Found");
	    		System.exit(1);
	    }
	    catch( QueryEngineException qee ){

	    		System.out.println(qee.getMessage());
	    		System.out.println("Exception@Line: " + query);
	    		System.exit(1);
	    }

	}

	/**
	 * Getter method
	 *
	 * @return List of queries to execute
	 */
	public List<String> getQueryList(){

	    return queryList;
	}

	/**
	 * Method for printing the results of a query file.
	 */
	public void printResults(){

		for( String query : getQueryList() ){

    			executeQuery(query);
		}

	}

}
