package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
}
