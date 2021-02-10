package test;

import knowledgeengine.*;

/**
 * TestDriver Class
 * Class with main method used for testing the Knowledge Engine.
 *
 * @author Philip Lin
 */
public class TestDriver{

	/**
	 * Main method
	 * Takes command line arguments and uses them to set up the KnowledgeGraph,
	 * run queries against the KnowledgeGraph, and print out the results of queries.
	 *
	 * @param args names of the files to enter as command line arguments
	 */
	public static void main(String[] args){

	    	Importer importer = new Importer();
	    	importer.importTripleFile(args[0]);

	    KnowledgeGraph.getInstance().importTriples(importer.getTripleIdentifierList());

	    QueryEngine queryEngine = new QueryEngine();
	    	queryEngine.importQueryFile(args[1]);
	    	queryEngine.printResults();
	}

}
