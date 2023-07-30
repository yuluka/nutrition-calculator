package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindow implements Initializable {
    
    @FXML
    private Pane MAIN_PANE;

    @FXML
    private Label LBL_TITTLE;

    @FXML
    private ImageView BTTN_LESS_FIVE_YEARS;

    @FXML
    private ImageView BTTN_MORE_FIVE_YEARS;

    @FXML
    private ImageView BTTN_ADULT;

    @FXML
    private ImageView BTTN_PREGNANT;

    @FXML
    private ImageView BTTN_OLDIE;

    @FXML
    public void goToAdultMenu(MouseEvent event) {
    	
    }

    @FXML
    public void goToBabyCalculations(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Baby-calculations.fxml"));
    	loader.setController(new BabyCalculations());
    	Parent root = loader.load();
    	
    	Scene sc = new Scene(root);
    	Stage st = new Stage();
    	st.setScene(sc);
    	st.setMaximized(true);
    	st.show();
    	
    	Stage aux = (Stage) BTTN_ADULT.getScene().getWindow();
    	aux.close();
    }

    @FXML
    public void goToChildCalculations(MouseEvent event) {
    	
    }

    @FXML
    public void goToOldieMenu(MouseEvent event) {
    	
    }

    @FXML
    public void goToPregnantMenu(MouseEvent event) {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		installTooltips();
	}
	
    @FXML
    void showBttnHoverEffect(MouseEvent event) {
		String currentBttn = event.getTarget().toString();
    	
		ScaleTransition scaleIn = new ScaleTransition(Duration.millis(100));
        scaleIn.setToX(1.2);
        scaleIn.setToY(1.2);
        
    	ScaleTransition scaleOut = new ScaleTransition(Duration.millis(100));
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);
        
    	if(currentBttn.contains("BTTN_LESS_FIVE_YEARS")) {
    		scaleIn.setNode(BTTN_LESS_FIVE_YEARS);
    		scaleOut.setNode(BTTN_LESS_FIVE_YEARS);

			BTTN_LESS_FIVE_YEARS.setOnMouseExited(e -> scaleOut.playFromStart());
			
    	} else if (currentBttn.contains("BTTN_MORE_FIVE_YEARS")) {
    		scaleIn.setNode(BTTN_MORE_FIVE_YEARS);
    		scaleOut.setNode(BTTN_MORE_FIVE_YEARS);

			BTTN_MORE_FIVE_YEARS.setOnMouseExited(e -> scaleOut.playFromStart());
			
		} else if (currentBttn.contains("BTTN_ADULT")) {
			scaleIn.setNode(BTTN_ADULT);
			scaleOut.setNode(BTTN_ADULT);

			BTTN_ADULT.setOnMouseExited(e -> scaleOut.playFromStart());
			
		} else if (currentBttn.contains("BTTN_PREGNANT")) {
			scaleIn.setNode(BTTN_PREGNANT);
			scaleOut.setNode(BTTN_PREGNANT);

			BTTN_PREGNANT.setOnMouseExited(e -> scaleOut.playFromStart());
			
		} else if (currentBttn.contains("BTTN_OLDIE")) {
			scaleIn.setNode(BTTN_OLDIE);
			scaleOut.setNode(BTTN_OLDIE);

			BTTN_OLDIE.setOnMouseExited(e -> scaleOut.playFromStart());
		}
    	
    	scaleIn.playFromStart();
    }
    
    public void installTooltips() {
    		Tooltip t = new Tooltip("Ir a cálculos para menores de 5 años");
        	Tooltip.install(BTTN_LESS_FIVE_YEARS, t);
        	
    		t = new Tooltip("Ir a cálculos para mayores de 5 años");
        	Tooltip.install(BTTN_MORE_FIVE_YEARS, t);
        	
			t = new Tooltip("Ir al menú de cálculos para adultos");
        	Tooltip.install(BTTN_ADULT, t);
        	
			t = new Tooltip("Ir al menú de cálculos para gestantes");
        	Tooltip.install(BTTN_PREGNANT, t);
        	
			t = new Tooltip("Ir al menú de cálculos para adultos mayores");
        	Tooltip.install(BTTN_OLDIE, t);
    }
}
