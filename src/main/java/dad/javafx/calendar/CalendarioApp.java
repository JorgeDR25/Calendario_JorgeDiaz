package dad.javafx.calendar;

import dad.javafx.calendar.controller.CalendarioController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarioApp extends Application {

	CalendarioController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		controller = new CalendarioController();
		
		Scene loadScene = new Scene(controller.getView(), 800, 500);
		

		primaryStage.setTitle("Calendario");
		primaryStage.getIcons().add(new Image(this.getClass().getResource("/img/icon.png").toString()));
		primaryStage.setScene(loadScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
