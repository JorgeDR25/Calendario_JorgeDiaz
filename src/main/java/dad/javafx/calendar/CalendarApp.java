package dad.javafx.calendar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		CalendarController controller = new CalendarController();

		Scene loadScene = new Scene(controller.getView(), 650, 400);

		primaryStage.setTitle("Calendar by Aitor del Castillo");
		primaryStage.getIcons().add(new Image(this.getClass().getResource("/img/icon.png").toString()));
		primaryStage.setScene(loadScene);
		primaryStage.show();
	}

}
