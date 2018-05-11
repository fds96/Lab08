/**
 * Sample Skeleton for 'DizionarioGraph.fxml' Controller Class
 */

package it.polito.tdp.dizionariograph;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtLetter"
    private TextField txtLetter; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	try {
    		model.createGraph(Integer.parseInt(txtLetter.getText()));
    		txtResult.appendText("Grafo creato!\n");
    	}
    	catch (Exception e) {
    		txtResult.appendText("Inserire un numero di lettere con cui creare il grafo!\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtLetter.clear();
    	txtParola.clear();
    }

    @FXML
    void doTrovaGradoMassimo(ActionEvent event) {
    	try {
    		String parola = model.findMaxDegree();
    		txtResult.appendText("La parola con più vicini è: ");
    		txtResult.appendText(parola + "\n");
    		parola = model.findVertexMaxDegree();
    		List<String> vicini = model.displayNeighbours(parola);
	    	txtResult.appendText("I vicini di "+ parola +" sono: [");
	    	String risultato = "";
	    	for(String s : vicini) {
	    		risultato+=(s + "; ");
	    	}
	    	risultato = risultato.substring(0,risultato.length()-2);
	    	txtResult.appendText(risultato);
	    	txtResult.appendText("]\n");
    	}
    	catch(Exception e){
    		txtResult.appendText("Assicurarsi di aver creato il grafo!\n");
    	}
    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	try {
	    	List<String> vicini = model.displayNeighbours(txtParola.getText());
	    	txtResult.appendText("I vicini di "+ txtParola.getText() +" sono: [");
	    	String risultato = "";
	    	for(String s : vicini) {
	    		risultato+=(s + "; ");
	    	}
	    	risultato = risultato.substring(0,risultato.length()-2);
	    	txtResult.appendText(risultato);
	    	txtResult.appendText("]\n");
    	}
    	catch(Exception e){
    		txtResult.appendText("Assicurarsi di aver creato il grafo e che la parola da cercare sia compresa nel dizionario!\n");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtLetter != null : "fx:id=\"txtLetter\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
