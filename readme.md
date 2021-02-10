# Knowledge Engine


## Repository
<https://github.com/philipjlin/KnowledgeEngine>


## Description
An engine that is used to collect information into a structure known as a knowledge graph. A knowledge graph acts as a collection that contains any number of items known as triples, which define a relationship (predicate) between two nodes. As a knowledge graph is populated with more nodes and predicates, triples will overlap and form a network of information that can be read by the engine, with queries returning useful results about the relationships in the graph.

A design document included in the project was provided as a part of CSCIE 97 class (Eric Geiseke), and provides further detailed information about the Knowledge Engine.


## Input Files
* inputQueries.txt
* inputQueriesException.txt
* inputTriples.nt
* inputTriplesException.nt


## Class Overview
Domain Objects <br>
    - Importer - handles and reads the content of input text files containing triples. <br>

    - KnowledgeGraph - manages the set of active triples and queries that match the triples, from the importer. Triples, with their the associated nodes and predicates are stored in separate maps in the knowledge graph. Queries are also stored in a map, with the value of each query being the set of triples that match that particular query. <br>

    - Node - represents a node in the knowledge graph. <br>

    - Predicate - represents a predicate in the knowledge graph. <br>

    - QueryEngine - reads the content of input query text files. Individual Strings queries are extracted individually from the input file and placed in a list, where the knowledge graph will map queries to matching triples. <br>

    - Triple - represents a triple in the knowledge graph. <br>

Exceptions <br>
    - ImportException - Defines exceptions thrown by importer. <br>
    - QueryEngineException - Defines exceptions thrown by the query engine. <br>


## Tests
A test driver class tests functionality of the knowledge engine, in populating the knowledge graph and running queries against it.
