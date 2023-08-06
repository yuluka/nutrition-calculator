package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Calculator;

public class AdultIdealWeight implements Initializable {
	
    @FXML
    private Pane MAIN_PANE;

    @FXML
    private Label LBL_TITTLE;

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
    private Button BTTN_MALE;

    @FXML
    private Button BTTN_FEMALE;

    @FXML
    private TextField TXT_HEIGHT;

    @FXML
    private TextField TXT_CARPUS;

    @FXML
    private Button BTTN_CALCULATE;

    @FXML
    private Label LBL_RESULT;

    @FXML
    private Button BTTN_SIDE_MENU;

    @FXML
    private ImageView BTTN_GO_HOME_PAGE;

    private Boolean selectedGender;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		MAIN_PANE.setOnMouseMoved(e -> configureSideMenu());	
		
		try {
			Font kalamFont = Font.loadFont(new FileInputStream(new File("src/fonts/Kalam-Regular.ttf")), 30);
			BTTN_CALCULATE.setFont(kalamFont);
			
		} catch (FileNotFoundException e) {
			
		}
		
		setSideMenuBttnEffects();
		setBttnEffects();
		setGenderButtnsEffects();
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
    
	// --- METHODS FOR HANDLING THE CURRENT SCREEN CALCULATIONS ---
    
    @FXML
    void calculateClassification(MouseEvent event) {
    	try {
    		double height = Double.parseDouble(TXT_HEIGHT.getText());
    		double carpus = Double.parseDouble(TXT_CARPUS.getText());
    		
    		String normalIdealWeight = "Por Complexión: " + Calculator.adultIdealWeight(height, carpus, selectedGender);
    		String lorentzIdealWeight = "Lorentz: " + Calculator.adultIdealWeightLorentz(height, selectedGender);
    		String regressionIdealWeight = "Por Regresión: " + Calculator.adultIdealWeightRegression((height/100), carpus, selectedGender);
    		
    		LBL_RESULT.setText(normalIdealWeight + "\n\n"
    				+ lorentzIdealWeight + "\n\n"
    				+ regressionIdealWeight);
    		
    	} catch (Exception e) {
    		if(TXT_HEIGHT.getText().isEmpty() || TXT_CARPUS.getText().isEmpty() || selectedGender != null) {
    			showInvalidIndicatorAlert();
    			
    			TXT_CARPUS.clear();
    			TXT_HEIGHT.clear();
    		}
    	}
    }
    
    public void showInvalidIndicatorAlert() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Indicador antropométrico inválido");
		a.setHeaderText("Error por indicador antropométrico inválido o género no seleccionado.");
		a.setContentText("Has introducido un indicador antropométrico que no es válido o no has seleccionado el género.\n"
				+ "Asegúrate de solo escribir números."
				+ "Asegúrate de que los decimales los escribas con punto y no con coma.");
		a.show();
	}

    @FXML
    void checkKey(KeyEvent event) {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		calculateClassification(null);
    	}
    }
    
    @FXML
    void selectGender(MouseEvent event) {
    	Button b = (Button) event.getSource();
    	
    	if(b.equals(BTTN_FEMALE)) {
    		selectedGender = true;
    		
    		BTTN_MALE.setStyle("-fx-background-color: transparent;"
        			+ "-fx-border-color: transparent;");
    	} else {
    		selectedGender = false;
    		
    		BTTN_FEMALE.setStyle("-fx-background-color: transparent;"
        			+ "-fx-border-color: transparent;");
    	}
    	
    	b.setStyle("-fx-background-color: transparent;"
    			+ "-fx-border-color: purple;"
    			+ "-fx-border-width: 2;");
    }
    
 // --- METHODS FOR VISUAL EFFECTS ---
    
 	/**
 	 * Sets the hover effects for the button to make the calculations.
 	 */
 	public void setBttnEffects() {
         BTTN_CALCULATE.setOnMouseEntered(e -> {
             BTTN_CALCULATE.setStyle(
                 "-fx-background-color: #e9e9e9;" +
         		"-fx-background-radius: 10;"
             );
         });

         BTTN_CALCULATE.setOnMousePressed(e -> {
             BTTN_CALCULATE.setStyle(
                 "-fx-background-color: #d0d0d0, #b6b6b6, #b6b6b6, #d0d0d0;" +
         		"-fx-background-radius: 10;"
             );
         });

         BTTN_CALCULATE.setOnMouseReleased(e -> {
             BTTN_CALCULATE.setStyle(
 	    		"-fx-background-color: #e9e9e9;" +
 				"-fx-background-radius: 10;"
             );
         });
         
         BTTN_CALCULATE.setOnMouseExited(e -> {
             BTTN_CALCULATE.setStyle(
                 "-fx-background-color: white;" +
                 "-fx-background-radius: 10;"
             );
         });
 	}
 	
 	public void setGenderButtnsEffects() {
 		ImageView gender = new ImageView(new Image("images/Male 2.png"));
 		BTTN_MALE.setGraphic(gender);
 		
 		gender = new ImageView(new Image("images/Female 2.png"));
 		BTTN_FEMALE.setGraphic(gender);
 		
 		String styleWithBorder = "-fx-background-color: transparent;"
     			+ "-fx-border-color: purple;"
    			+ "-fx-border-width: 2;";
 		
 		BTTN_FEMALE.setOnMouseEntered(e -> {
             BTTN_FEMALE.setStyle(
                 "-fx-background-color: rgba(233, 233, 233, 0.3);"
             );
         });

         BTTN_FEMALE.setOnMousePressed(e -> {
             BTTN_FEMALE.setStyle(
                 "-fx-background-color: rgba(208, 208, 208, 0.3), rgba(182, 182, 182, 0.3), rgba(182, 182, 182, 0.3), rgba(208, 208, 208, 0.3);"
             );
         });

         BTTN_FEMALE.setOnMouseReleased(e -> {
             BTTN_FEMALE.setStyle(
 	    		"-fx-background-color: rgba(233, 233, 233, 0.3);"
             );
         });
         
         BTTN_FEMALE.setOnMouseExited(e -> {
        	 try {
        		 if(selectedGender == null || !selectedGender) {
            		 BTTN_FEMALE.setStyle(
                             "-fx-background-color: transparent;"
                         );
            	 } else {
            		 BTTN_FEMALE.setStyle(styleWithBorder);
            	 }
        	 } catch (Exception e1) {
        		 
        	 }
         });
         
         BTTN_MALE.setOnMouseEntered(e -> {
             BTTN_MALE.setStyle(
                 "-fx-background-color: rgba(233, 233, 233, 0.3);"
             );
         });

         BTTN_MALE.setOnMousePressed(e -> {
             BTTN_MALE.setStyle(
                 "-fx-background-color: rgba(208, 208, 208, 0.3), rgba(182, 182, 182, 0.3), rgba(182, 182, 182, 0.3), rgba(208, 208, 208, 0.3);"
             );
         });

         BTTN_MALE.setOnMouseReleased(e -> {
             BTTN_MALE.setStyle(
 	    		"-fx-background-color: rgba(233, 233, 233, 0.3);"
             );
         });
         
         BTTN_MALE.setOnMouseExited(e -> {
        	 try {
        		 if(selectedGender == null || selectedGender) {
        			 BTTN_MALE.setStyle(
                             "-fx-background-color: transparent;"
                         );
            	 } else {
            		 BTTN_MALE.setStyle(styleWithBorder);
            	 }
        	 } catch (Exception e1) {
        		 
        	 }
         });
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

         // Desplazar hacia la izquierda para ocultar el menú o hacia la derecha para mostrarlo
         translateTransition.setToX(translateX == 0 ? -SIDE_MENU_PANE.getWidth() : 0);

         // Iniciar la animación
         translateTransition.play();
     }
}
