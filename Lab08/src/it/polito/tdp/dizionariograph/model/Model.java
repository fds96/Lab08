package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import it.polito.tdp.dizionariograph.db.WordDAO;


public class Model {
	
	private Graph<String,DefaultEdge> graph;
	private WordDAO dao;
	List<String> parole;

	public Model() {
		dao = new WordDAO();
	}
	
	public void createGraph(int numeroLettere) {
		graph = new SimpleWeightedGraph<>(DefaultEdge.class);
		parole = new ArrayList<>(dao.getAllWordsFixedLength(numeroLettere));
		Graphs.addAllVertices(this.graph, parole);
		
		for(int i=0;i<parole.size();i++) {
			for(int j=i+1;j<parole.size();j++) {
				String parola1 = parole.get(i);
				String parola2 = parole.get(j);
				int contatore=0;
				for(int k=0;k<numeroLettere;k++) {
					if(!(parola1.charAt(k)==parola2.charAt(k))) {
						contatore++;
					}
				}
				if(contatore==1) {
					graph.addEdge(parola1, parola2);
				}
			}
		}
	}
	
	

	public List<String> displayNeighbours(String parolaInserita) {
		return Graphs.neighborListOf(this.graph, parolaInserita);
	}

	public String findVertexMaxDegree() {
		int grado = -1;
		String max ="";
		for(String p : graph.vertexSet()) {
			if(graph.degreeOf(p)>grado) {
				grado=graph.degreeOf(p);
				max=p;	
			}
		}
		return max;
	}
	
	public int findDegree(String string) {
		if(!parole.contains(string)) {
			System.out.println("La parola non è contenuta!");
		}
		return graph.degreeOf(string);
	}
	
	public String findMaxDegree() {
		return (this.findVertexMaxDegree() + " con numero di vicini pari a " + this.findDegree(this.findVertexMaxDegree()));
	}
	
}
