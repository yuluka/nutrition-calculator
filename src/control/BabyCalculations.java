package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

public class BabyCalculations implements Initializable {

    @FXML
    private Pane MAIN_PANE;

    @FXML
    private Label LBL_TITTLE;

    @FXML
    private RadioButton RB_WEIGHT_FOR_SIZE;
    
    @FXML
    private ToggleGroup calculations;

    @FXML
    private RadioButton RB_SIZE_FOR_AGE;

    @FXML
    private RadioButton RB_HEAD_FOR_AGE;

    @FXML
    private RadioButton RB_BMI_FOR_AGE;

    @FXML
    private RadioButton RB_WEIGHT_FOR_AGE;

    @FXML
    private TextField TXT_INDICATOR;
    
    @FXML
    private Button BTTN_CALCULATE;
    
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
    private Label LBL_RESULT;
    
    @FXML
    private ImageView BTTN_GO_HOME_PAGE;

    @FXML
    private Button BTTN_SIDE_MENU;

    @FXML
    private VBox SIDE_MENU_PANE;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Font kalamFont = Font.loadFont(new FileInputStream(new File("src/fonts/Kalam-Regular.ttf")), 30);
			BTTN_CALCULATE.setFont(kalamFont);
			
		} catch (FileNotFoundException e) {
			
		}
		
		BTTN_BABY_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_CHILD_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_ADULT_CALCULATE_CARDIO_RISK.setText("Riesgo\nCardiovascular");
		
		setBttnEffects();
		setSideMenuBttnEffects();
	}
    
	// --- METHODS FOR HANDLING THE CURRENT SCREEN CALCULATIONS ---
	
    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
		loader.setController(new MainWindow());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setMaximized(true);
		
		st.show();
		
		Stage aux = (Stage) BTTN_GO_HOME_PAGE.getScene().getWindow();
		aux.close();
    }
    
    @FXML
    void calculateClassification(MouseEvent event) {
    	try {
    		double indicator = Double.parseDouble(TXT_INDICATOR.getText());
    		
    		String result = "Resultado: ";
    		
    		if (RB_WEIGHT_FOR_SIZE.isSelected()) {
				result += Calculator.weightForSize(indicator);
			} else if (RB_SIZE_FOR_AGE.isSelected()) {
				result += Calculator.sizeForAge(indicator);
			} else if (RB_HEAD_FOR_AGE.isSelected()) {
				result += Calculator.headCircumferenceForAge(indicator);
			} else if (RB_BMI_FOR_AGE.isSelected()) {
				result += Calculator.BMIForAge(indicator);
			} else if (RB_WEIGHT_FOR_AGE.isSelected()) {
				result += Calculator.weightForAge(indicator);
			} else {
				showNoClassificationSelectedAlert();
			}
    		
    		LBL_RESULT.setText(result);
    		
    	} catch (Exception e) {
    		if(!TXT_INDICATOR.getText().isEmpty()) {
    			showInvalidIndicatorAlert();
    			
    			TXT_INDICATOR.clear();
    		}
    	}
    }
    
    public void showInvalidIndicatorAlert() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Indicador antropométrico inválido");
		a.setHeaderText("Error por indicador antropométrico inválido.");
		a.setContentText("Has introducido un indicador antropométrico que no es válido.\n"
				+ "Asegúrate de solo escribir números."
				+ "Asegúrate de que los decimales los escribas con punto y no con coma.");
		a.show();
	}
    
    public void showNoClassificationSelectedAlert() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Clasificación antropométrica no seleccionada");
		a.setHeaderText("Error por no selección de clasificación antropométrica.");
		a.setContentText("No has seleccionado ninguna clasificación antropométrica para calcular.");
		a.show();
	}
    
    @FXML
    void checkKey(KeyEvent event) {
    	if(event.getCode().equals(KeyCode.ENTER)) {
    		calculateClassification(null);
    	}
    }

// -------------------- METHODS FOR HANDLING SIDE MENU BUTTONS --------------------
    
    // --- ON ACTION METHODS FOR BABY CALCULATIONS BUTTONS ---
    
    @FXML
    void goToBabyCalcs(MouseEvent event) {
    	// No code here 'cause we're already in the target screen of this method.
    }

    // --- ON ACTION METHODS FOR CHILD CALCULATIONS BUTTONS ---
    
    @FXML
    void goToChildClacs(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Child-calculations.fxml"));
		loader.setController(new ChildCalculations());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setMaximized(true);
		
		st.show();
		
		Stage aux = (Stage) BTTN_GO_HOME_PAGE.getScene().getWindow();
		aux.close();
    }

    // --- ON ACTION METHODS FOR ADULT CALCULATIONS BUTTONS ---
    
    @FXML
    void goToAdultBMICalc(MouseEvent event) {

    }

    @FXML
    void goToAdultBodyFatCalc(MouseEvent event) {

    }

    @FXML
    void goToAdultCardiovascularRiskCalc(MouseEvent event) {

    }

    @FXML
    void goToAdultIdealWeightCalc(MouseEvent event) {

    }

    @FXML
    void goToAdultMenu(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-menu.fxml"));
		loader.setController(new AdultMenu());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setMaximized(true);
		
		st.show();
		
		Stage aux = (Stage) BTTN_GO_HOME_PAGE.getScene().getWindow();
		aux.close();
    }

    // --- ON ACTION METHODS FOR PREGNANT CALCULATIONS BUTTONS ---
    
    @FXML
    void goToPregnantBMICalc(MouseEvent event) {

    }

    @FXML
    void goToPregnantMenu(MouseEvent event) {

    }

    @FXML
    void goToPregnantWeightGainCalc(MouseEvent event) {

    }

    // --- ON ACTION METHODS FOR OLDIE CALCULATIONS BUTTONS ---
    
    @FXML
    void goToOldieMenu(MouseEvent event) {

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
