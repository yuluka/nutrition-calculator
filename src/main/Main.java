package main;

import control.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MainWindow.fxml"));
		loader.setController(new MainWindow());
		Parent root = loader.load();
		
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setMaximized(true);
		
		st.show();
	}

}
