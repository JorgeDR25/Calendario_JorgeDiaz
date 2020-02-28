package dad.javafx.calendar.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import dad.javafx.calendar.components.MonthComponent;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

public class CalendarioController implements Initializable {

	@FXML
	private BorderPane root;

	@FXML
	private Button anteriorButton;

	@FXML
	private Button siguienteButton;

	@FXML
	private Label yearLabel;

	@FXML
	private MonthComponent septiembre;

	@FXML
	private MonthComponent mayo;

	@FXML
	private MonthComponent enero;

	@FXML
	private MonthComponent febrero;

	@FXML
	private MonthComponent marzo;

	@FXML
	private MonthComponent abril;

	@FXML
	private MonthComponent junio;

	@FXML
	private MonthComponent julio;

	@FXML
	private MonthComponent agosto;

	@FXML
	private MonthComponent octubre;

	@FXML
	private MonthComponent noviembre;

	@FXML
	private MonthComponent diciembre;

	// model

	IntegerProperty year = new SimpleIntegerProperty();

	public CalendarioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Calendar.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		root.getStylesheets().add(getClass().getResource("/css/calendar.css").toExternalForm());
		year.set(Calendar.getInstance().get(Calendar.YEAR));
		
		//Bindings

		enero.yearPropertyProperty().bind(year);
		febrero.yearPropertyProperty().bind(year);
		marzo.yearPropertyProperty().bind(year);
		abril.yearPropertyProperty().bind(year);
		mayo.yearPropertyProperty().bind(year);
		junio.yearPropertyProperty().bind(year);
		julio.yearPropertyProperty().bind(year);
		agosto.yearPropertyProperty().bind(year);
		septiembre.yearPropertyProperty().bind(year);
		octubre.yearPropertyProperty().bind(year);
		noviembre.yearPropertyProperty().bind(year);
		diciembre.yearPropertyProperty().bind(year);

		Bindings.bindBidirectional(yearLabel.textProperty(), year, new NumberStringConverter("####"));

	}

	@FXML
	void onAnteriorAction(ActionEvent event) {
		year.set(year.get() - 1);
	}

	@FXML
	void onSiguienteAction(ActionEvent event) {
		year.set(year.get() + 1);
	}
	
	public BorderPane getView() {
		return root;
	}

}
