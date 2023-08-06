package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AdultMenu implements Initializable {
    @FXML
    private Pane MAIN_PANE;

    @FXML
    private Label LBL_TITTLE;

    @FXML
    private ImageView BTTN_BMI;

    @FXML
    private ImageView BTTN_IDEAL_WEIGHT;

    @FXML
    private ImageView BTTN_CARDIOVASCULAR_RISK;

    @FXML
    private ImageView BTTN_BODY_FAT;

    @FXML
    private Pane HOVER_PANE;

    @FXML
    private VBox SIDE_MENU_PANE;

    @FXML
    private ImageView BTTN_LESS_FIVE_YEARS;

    @FXML
    private Label BTTN_LBL_LESS_FIVE_YEARS;

    @FXML
    private Label BTTN_BABY_CALCULATIONS;

    @FXML
    private ImageView BTTN_CHILD;

    @FXML
    private Label BTTN_LBL_CHILD;

    @FXML
    private Label BTTN_CHILD_CALCULATIONS;

    @FXML
    private ImageView BTTN_ADULT;

    @FXML
    private Label BTTN_LBL_ADULT;

    @FXML
    private Label BTTN_ADULT_CALCULATE_BMI;

    @FXML
    private Label BTTN_ADULT_CALCULATE_IDEAL_WEIGHT;

    @FXML
    private Label BTTN_ADULT_CALCULATE_CARDIO_RISK;

    @FXML
    private Label BTTN_ADULT_CALCULATE_BODY_FAT;

    @FXML
    private ImageView BTTN_PREGNANT;

    @FXML
    private Label BTTN_LBL_PREGNANT;

    @FXML
    private Label BTTN_PREGNANT_CALCULATE_BMI;

    @FXML
    private Label BTTN_PREGNANT_WEIGHT_GAIN;

    @FXML
    private ImageView BTTN_OLDIE;

    @FXML
    private Label BTTN_LBL_OLDIE;

    @FXML
    private ImageView BTTN_GO_HOME_PAGE;

    @FXML
    private Button BTTN_SIDE_MENU;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		MAIN_PANE.setOnMouseMoved(e -> configureSideMenu());	
		
		installTooltips();
		
		setSideMenuBttnEffects();
	}
	
	public void configureSideMenu() {
		BTTN_BABY_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_CHILD_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_ADULT_CALCULATE_CARDIO_RISK.setText("Riesgo\nCardiovascular");

		@SuppressWarnings("unused")
		SideMenu smenu = new SideMenu((Stage) MAIN_PANE.getScene().getWindow(), 
    			BTTN_GO_HOME_PAGE,
    			BTTN_LESS_FIVE_YEARS, 
    			BTTN_LBL_LESS_FIVE_YEARS, 
    			BTTN_BABY_CALCULATIONS,
    			BTTN_CHILD, 
    			BTTN_LBL_CHILD, 
    			BTTN_CHILD_CALCULATIONS,
    			BTTN_ADULT, 
    			BTTN_LBL_ADULT, 
    			BTTN_ADULT_CALCULATE_BMI,
    			BTTN_ADULT_CALCULATE_IDEAL_WEIGHT, 
    			BTTN_ADULT_CALCULATE_CARDIO_RISK,
    			BTTN_ADULT_CALCULATE_BODY_FAT, 
    			BTTN_PREGNANT, 
    			BTTN_LBL_PREGNANT, 
    			BTTN_PREGNANT_CALCULATE_BMI, 
    			BTTN_PREGNANT_WEIGHT_GAIN, 
    			BTTN_OLDIE, 
    			BTTN_LBL_OLDIE);
	}
	
	// --- ON ACTION METHODS FOR THE CURRENT SCREEN ---
    
    @FXML
    void goToAdultBMICalc(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-BMI.fxml"));
		loader.setController(new AdultBMI());
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
    void goToAdultBodyFatCalc(MouseEvent event) {

    }

    @FXML
    void goToAdultCardiovascularRiskCalc(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-Cardiovascular-Risk.fxml"));
		loader.setController(new AdultCardiovascularRisk());
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
    void goToAdultIdealWeightCalc(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-Ideal-Weight.fxml"));
		loader.setController(new AdultIdealWeight());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setMaximized(true);
		
		st.show();
		
		Stage aux = (Stage) BTTN_ADULT.getScene().getWindow();
		aux.close();
    }
	
    // --- METHODS FOR VISUAL EFFECTS ---

    @FXML
    void showBttnHoverEffect(MouseEvent event) {
		String currentBttn = event.getTarget().toString();
    	
		ScaleTransition scaleIn = new ScaleTransition(Duration.millis(100));
        scaleIn.setToX(1.2);
        scaleIn.setToY(1.2);
        
    	ScaleTransition scaleOut = new ScaleTransition(Duration.millis(100));
        scaleOut.setToX(1.0);
        scaleOut.setToY(1.0);
        
    	if(currentBttn.contains("BTTN_BMI")) {
    		scaleIn.setNode(BTTN_BMI);
    		scaleOut.setNode(BTTN_BMI);

    		BTTN_BMI.setOnMouseExited(e -> scaleOut.playFromStart());
			
    	} else if (currentBttn.contains("BTTN_IDEAL_WEIGHT")) {
    		scaleIn.setNode(BTTN_IDEAL_WEIGHT);
    		scaleOut.setNode(BTTN_IDEAL_WEIGHT);

    		BTTN_IDEAL_WEIGHT.setOnMouseExited(e -> scaleOut.playFromStart());
			
		} else if (currentBttn.contains("BTTN_CARDIOVASCULAR_RISK")) {
			scaleIn.setNode(BTTN_CARDIOVASCULAR_RISK);
			scaleOut.setNode(BTTN_CARDIOVASCULAR_RISK);

			BTTN_CARDIOVASCULAR_RISK.setOnMouseExited(e -> scaleOut.playFromStart());
			
		} else if (currentBttn.contains("BTTN_BODY_FAT")) {
			scaleIn.setNode(BTTN_BODY_FAT);
			scaleOut.setNode(BTTN_BODY_FAT);

			BTTN_BODY_FAT.setOnMouseExited(e -> scaleOut.playFromStart());
			
		}
    	
    	scaleIn.playFromStart();
    }
    
    public void installTooltips() {
		Tooltip t = new Tooltip("Calcular IMC");
    	Tooltip.install(BTTN_BMI, t);
    	
		t = new Tooltip("Calcular peso ideal");
    	Tooltip.install(BTTN_IDEAL_WEIGHT, t);
    	
		t = new Tooltip("Calcular riesgo cardiovascular");
    	Tooltip.install(BTTN_CARDIOVASCULAR_RISK, t);
    	
		t = new Tooltip("Calcular grasa corporal");
    	Tooltip.install(BTTN_BODY_FAT, t);
    }
    
    public void setSideMenuBttnEffects() {
		ImageView icon = new ImageView(new Image("images/Options-bttn.png"));
		
		BTTN_SIDE_MENU.setGraphic(icon);
		
		BTTN_SIDE_MENU.setStyle("-fx-background-color: transparent;");
		
		BTTN_SIDE_MENU.setOnMouseEntered(e -> {
            BTTN_SIDE_MENU.setStyle(
                "-fx-background-color: #e9e9e9;" +
        		"-fx-background-radius: 100;" +
        		"-fx-border-width: 0;"
            );
        });

        BTTN_SIDE_MENU.setOnMousePressed(e -> {
            BTTN_SIDE_MENU.setStyle(
                "-fx-background-color: #d0d0d0, #b6b6b6, #b6b6b6, #d0d0d0;" +
        		"-fx-background-radius: 100;" +
        		"-fx-border-width: 0;"
            );
        });

        BTTN_SIDE_MENU.setOnMouseReleased(e -> {
            BTTN_SIDE_MENU.setStyle(
	    		"-fx-background-color: #e9e9e9;" +
				"-fx-background-radius: 100;" +
        		"-fx-border-width: 0;"
            );
        });
        
        BTTN_SIDE_MENU.setOnMouseExited(e -> {
            BTTN_SIDE_MENU.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 100;" +
        		"-fx-border-width: 0;"
            );
        });
        
        BTTN_SIDE_MENU.setOnAction(e -> toggleMenu());
	}
	
	private void toggleMenu() {
    	// Obtener el desplazamiento actual del menú lateral
        double translateX = SIDE_MENU_PANE.getTranslateX();

        // Configurar la animación
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), SIDE_MENU_PANE);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), HOVER_PANE);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(0.2);
        
        FadeTransition reverseFade = new FadeTransition(Duration.millis(300), HOVER_PANE);
        reverseFade.setFromValue(0.2);
        reverseFade.setToValue(0);
        
        // Desplazar hacia la izquierda para ocultar el menú o hacia la derecha para mostrarlo
        translateTransition.setToX(translateX == 0 ? -SIDE_MENU_PANE.getWidth() : 0);
        
        // Iniciar la animación
        translateTransition.play();
        
        if(translateX != 0) {
        	HOVER_PANE.setVisible(true);
        	fadeTransition.play();
        } else {
        	reverseFade.play();
        	reverseFade.setOnFinished(e -> HOVER_PANE.setVisible(false));
        }
	}
}
