package control;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SideMenu {

	private Stage currentStage;
	
	public SideMenu(Stage currentStage, Pane SIDE_MENU_PANE, Button BTTN_SIDE_MENU) {
		this.currentStage = currentStage;
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
			// TODO: handle exception
		}
    }
    
    // --- ON ACTION METHODS FOR ADULT CALCULATIONS BUTTONS ---
    
    public void goToAdultBMICalc() {

    }

    public void goToAdultBodyFatCalc() {

    }

    public void goToAdultCardiovascularRiskCalc() {

    }

    public void goToAdultIdealWeightCalc() {

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
