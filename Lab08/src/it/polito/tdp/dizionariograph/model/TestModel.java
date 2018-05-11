package it.polito.tdp.dizionariograph.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.createGraph(4);
		System.out.println(String.format("**Grafo creato**\n"));
		
		List<String> vicini = model.displayNeighbours("fila");
		System.out.println("Neighbours di casa: " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findVertexMaxDegree() + ": " + model.findDegree(model.findVertexMaxDegree()));
		
	}

}
