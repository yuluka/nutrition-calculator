package control;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SideMenu {

	private Stage currentStage;
	
    private ImageView BTTN_GO_HOME_PAGE;
    
    private ImageView BTTN_LESS_FIVE_YEARS;
    
    private Label BTTN_LBL_LESS_FIVE_YEARS;
    
    private Label BTTN_BABY_CALCULATIONS;
    
    private ImageView BTTN_CHILD;
    
    private Label BTTN_LBL_CHILD;
    
    private Label BTTN_CHILD_CALCULATIONS;
    
    private ImageView BTTN_ADULT;
    
    private Label BTTN_LBL_ADULT;
    
    private Label BTTN_ADULT_CALCULATE_BMI;
    
    private Label BTTN_ADULT_CALCULATE_IDEAL_WEIGHT;
    
    private Label BTTN_ADULT_CALCULATE_CARDIO_RISK;
    
    private Label BTTN_ADULT_CALCULATE_BODY_FAT;
    
    private ImageView BTTN_PREGNANT;
    
    private Label BTTN_LBL_PREGNANT;
    
    private Label BTTN_PREGNANT_CALCULATE_BMI;
    
    private Label BTTN_PREGNANT_WEIGHT_GAIN;
    
    private ImageView BTTN_OLDIE;
    
    private Label BTTN_LBL_OLDIE;
	
	public SideMenu(Stage currentStage,
			ImageView BTTN_GO_HOME_PAGE,
			ImageView BTTN_LESS_FIVE_YEARS, 
			Label BTTN_LBL_LESS_FIVE_YEARS, 
			Label BTTN_BABY_CALCULATIONS,
			ImageView BTTN_CHILD, 
			Label BTTN_LBL_CHILD, 
			Label BTTN_CHILD_CALCULATIONS,
			ImageView BTTN_ADULT, 
			Label BTTN_LBL_ADULT, 
			Label BTTN_ADULT_CALCULATE_BMI,
			Label BTTN_ADULT_CALCULATE_IDEAL_WEIGHT, 
			Label BTTN_ADULT_CALCULATE_CARDIO_RISK,
			Label BTTN_ADULT_CALCULATE_BODY_FAT, 
			ImageView BTTN_PREGNANT, 
			Label BTTN_LBL_PREGNANT, 
			Label BTTN_PREGNANT_CALCULATE_BMI, 
			Label BTTN_PREGNANT_WEIGHT_GAIN, 
			ImageView BTTN_OLDIE, 
			Label BTTN_LBL_OLDIE) {
		
		this.currentStage = currentStage;
		
		this.BTTN_GO_HOME_PAGE = BTTN_GO_HOME_PAGE;
		
		this.BTTN_LESS_FIVE_YEARS = BTTN_LESS_FIVE_YEARS;
		this.BTTN_LBL_LESS_FIVE_YEARS = BTTN_LBL_LESS_FIVE_YEARS;
		this.BTTN_BABY_CALCULATIONS = BTTN_BABY_CALCULATIONS;
		
		this.BTTN_CHILD = BTTN_CHILD;
		this.BTTN_LBL_CHILD = BTTN_LBL_CHILD;
		this.BTTN_CHILD_CALCULATIONS = BTTN_CHILD_CALCULATIONS;
		
		this.BTTN_ADULT = BTTN_ADULT;
		this.BTTN_LBL_ADULT = BTTN_LBL_ADULT;
		this.BTTN_ADULT_CALCULATE_BMI = BTTN_ADULT_CALCULATE_BMI;
		this.BTTN_ADULT_CALCULATE_IDEAL_WEIGHT = BTTN_ADULT_CALCULATE_IDEAL_WEIGHT;
		this.BTTN_ADULT_CALCULATE_CARDIO_RISK = BTTN_ADULT_CALCULATE_CARDIO_RISK;
		this.BTTN_ADULT_CALCULATE_BODY_FAT = BTTN_ADULT_CALCULATE_BODY_FAT;
		
		this.BTTN_PREGNANT = BTTN_PREGNANT;
		this.BTTN_LBL_PREGNANT = BTTN_LBL_PREGNANT;
		this.BTTN_PREGNANT_CALCULATE_BMI = BTTN_PREGNANT_CALCULATE_BMI;
		this.BTTN_PREGNANT_WEIGHT_GAIN = BTTN_PREGNANT_WEIGHT_GAIN;
		
		this.BTTN_OLDIE = BTTN_OLDIE;
		this.BTTN_LBL_OLDIE = BTTN_LBL_OLDIE;
		
		BTTN_BABY_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_CHILD_CALCULATIONS.setText("Clasificación\nAntropométrica");
		BTTN_ADULT_CALCULATE_CARDIO_RISK.setText("Riesgo\nCardiovascular");		
		
		setOnActionMethods();
	}
	
	private void setOnActionMethods() {
		BTTN_GO_HOME_PAGE.setOnMouseClicked(e -> goToHomePage());
		
		//Baby
		BTTN_LESS_FIVE_YEARS.setOnMouseClicked(e -> goToBabyCalcs());
		
		BTTN_LBL_LESS_FIVE_YEARS.setOnMouseClicked(e -> goToBabyCalcs());
		
		BTTN_BABY_CALCULATIONS.setOnMouseClicked(e -> goToBabyCalcs());
		
		//Child
		BTTN_CHILD.setOnMouseClicked(e -> goToChildClacs());
		
		BTTN_LBL_CHILD.setOnMouseClicked(e -> goToChildClacs());
		
		BTTN_CHILD_CALCULATIONS.setOnMouseClicked(e -> goToChildClacs());
		
		//Adult
		BTTN_ADULT.setOnMouseClicked(e -> goToAdultMenu());
		
		BTTN_LBL_ADULT.setOnMouseClicked(e -> goToAdultMenu());
		
		BTTN_ADULT_CALCULATE_BMI.setOnMouseClicked(e -> goToAdultBMICalc());
		
		BTTN_ADULT_CALCULATE_IDEAL_WEIGHT.setOnMouseClicked(e -> goToAdultIdealWeightCalc());
		
		BTTN_ADULT_CALCULATE_CARDIO_RISK.setOnMouseClicked(e -> goToAdultCardiovascularRiskCalc());

		BTTN_ADULT_CALCULATE_BODY_FAT.setOnMouseClicked(e -> goToAdultBodyFatCalc());
		
		//Pregnant
		BTTN_PREGNANT.setOnMouseClicked(e -> goToPregnantMenu());

		BTTN_LBL_PREGNANT.setOnMouseClicked(e -> goToPregnantMenu());
		
		BTTN_PREGNANT_CALCULATE_BMI.setOnMouseClicked(e -> goToPregnantBMICalc());
		
		BTTN_PREGNANT_WEIGHT_GAIN.setOnMouseClicked(e -> goToPregnantWeightGainCalc());
		
		//Oldie
		BTTN_OLDIE.setOnMouseClicked(e -> goToOldieMenu());
		
		BTTN_LBL_OLDIE.setOnMouseClicked(e -> goToOldieMenu());
	}
	
	public void goToHomePage() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
			loader.setController(new MainWindow());
			Parent root = loader.load();
			
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.setScene(sc);
			st.setMaximized(true);
			
			st.show();
			
			currentStage.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
// -------------------- METHODS FOR HANDLING SIDE MENU BUTTONS --------------------
    
    // --- ON ACTION METHODS FOR BABY CALCULATIONS BUTTONS ---
	
	public void goToBabyCalcs() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Baby-calculations.fxml"));
    		loader.setController(new BabyCalculations());
    		Parent root = loader.load();
    		
    		Scene sc = new Scene(root);
    		Stage st = new Stage();
    		st.setScene(sc);
    		st.setMaximized(true);
    		
    		st.show();
    		
    		currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
    // --- ON ACTION METHODS FOR CHILD CALCULATIONS BUTTONS ---

    public void goToChildClacs() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Child-calculations.fxml"));
    		loader.setController(new ChildCalculations());
    		Parent root = loader.load();
    		
    		Scene sc = new Scene(root);
    		Stage st = new Stage();
    		st.setScene(sc);
    		st.setMaximized(true);
    		
    		st.show();
    		
    		currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    // --- ON ACTION METHODS FOR ADULT CALCULATIONS BUTTONS ---
    
    public void goToAdultBMICalc() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-BMI.fxml"));
    		loader.setController(new AdultBMI());
    		Parent root = loader.load();
    		
    		Scene sc = new Scene(root);
    		Stage st = new Stage();
    		st.setScene(sc);
    		st.setMaximized(true);
    		
    		st.show();
    		
    		currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void goToAdultBodyFatCalc() {

    }

    public void goToAdultCardiovascularRiskCalc() {

    }

    public void goToAdultIdealWeightCalc() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-Ideal-Weight.fxml"));
    		loader.setController(new AdultIdealWeight());
    		Parent root = loader.load();
    		
    		Scene sc = new Scene(root);
    		Stage st = new Stage();
    		st.setScene(sc);
    		st.setMaximized(true);
    		
    		st.show();
    		
    		currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void goToAdultMenu() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Adult-menu.fxml"));
    		loader.setController(new AdultMenu());
    		Parent root = loader.load();
    		
    		Scene sc = new Scene(root);
    		Stage st = new Stage();
    		st.setScene(sc);
    		st.setMaximized(true);
    		
    		st.show();
    		
    		currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    // --- ON ACTION METHODS FOR PREGNANT CALCULATIONS BUTTONS ---

    public void goToPregnantBMICalc() {

    }

    public void goToPregnantMenu() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Pregnant-menu.fxml"));
        	loader.setController(new PregnantMenu());
        	Parent root = loader.load();
        	
        	Scene sc = new Scene(root);
        	Stage st = new Stage();
        	st.setScene(sc);
        	st.setMaximized(true);
        	st.show();
        	
        	currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void goToPregnantWeightGainCalc() {

    }
    
    // --- ON ACTION METHODS FOR OLDIE CALCULATIONS BUTTONS ---

    public void goToOldieMenu() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Pregnant-menu.fxml"));
        	loader.setController(new PregnantMenu());
        	Parent root = loader.load();
        	
        	Scene sc = new Scene(root);
        	Stage st = new Stage();
        	st.setScene(sc);
        	st.setMaximized(true);
        	st.show();
        	
        	currentStage.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
