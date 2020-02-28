package dad.javafx.calendar.components;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MonthComponent extends BorderPane implements Initializable {

	// private declarations

	private Label hoy;
	private ListProperty<Label> days = new SimpleListProperty<Label>(FXCollections.observableArrayList());
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();

	// model

		@FXML
		private BorderPane root;

	    @FXML
	    private Label mesLabel;

	    @FXML
	    private Label L_cero;

	    @FXML
	    private Label M_cero;

	    @FXML
	    private Label X_cero;

	    @FXML
	    private Label J_cero;

	    @FXML
	    private Label V_cero;

	    @FXML
	    private Label S_cero;

	    @FXML
	    private Label D_cero;

	    @FXML
	    private Label L_uno;

	    @FXML
	    private Label M_uno;

	    @FXML
	    private Label X_uno;

	    @FXML
	    private Label J_uno;

	    @FXML
	    private Label V_uno;

	    @FXML
	    private Label S_uno;

	    @FXML
	    private Label D_uno;

	    @FXML
	    private Label L_dos;

	    @FXML
	    private Label M_dos;

	    @FXML
	    private Label X_dos;

	    @FXML
	    private Label J_dos;

	    @FXML
	    private Label V_dos;

	    @FXML
	    private Label S_dos;

	    @FXML
	    private Label D_dos;

	    @FXML
	    private Label L_tres;

	    @FXML
	    private Label M_tres;

	    @FXML
	    private Label X_tres;

	    @FXML
	    private Label J_tres;

	    @FXML
	    private Label V_tres;

	    @FXML
	    private Label S_tres;

	    @FXML
	    private Label D_tres;

	    @FXML
	    private Label L_cuatro;

	    @FXML
	    private Label M_cuatro;

	    @FXML
	    private Label X_cuatro;

	    @FXML
	    private Label J_cuatro;

	    @FXML
	    private Label V_cuatro;

	    @FXML
	    private Label S_cuatro;

	    @FXML
	    private Label D_cuatro;

	    @FXML
	    private Label L_cinco;

	    @FXML
	    private Label M_cinco;

	    @FXML
	    private Label X_cinco;

	    @FXML
	    private Label J_cinco;

	    @FXML
	    private Label V_cinco;

	    @FXML
	    private Label S_cinco;

	    @FXML
	    private Label D_cinco;


	public MonthComponent() {
		super();
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MonthComponent.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		days.addAll(L_cero, M_cero, X_cero, J_cero, V_cero, S_cero, D_cero, L_uno, M_uno, X_uno, J_uno, V_uno, S_uno, D_uno,
				L_dos, M_dos, X_dos, J_dos, V_dos, S_dos, D_dos, L_tres, M_tres, X_tres, J_tres, V_tres, S_tres, D_tres,
				L_cuatro, M_cuatro, X_cuatro, J_cuatro, V_cuatro, S_cuatro, D_cuatro, L_cinco, M_cinco, X_cinco, J_cinco,
				V_cinco, S_cinco, D_cinco);

		yearProperty.addListener((o, ov, nv) -> {
			configure();
		});

	}

	private void configure() {
		GregorianCalendar aux = new GregorianCalendar(yearProperty.getValue(), monthProperty.getValue() - 1, 1);
		YearMonth yearMonthObject = YearMonth.of(yearProperty.getValue(), monthProperty.getValue());
		int comienzo = aux.get(Calendar.DAY_OF_WEEK) - 2;
		if (comienzo == -1) {
			comienzo = 6;
		}
		

		for (int i = 0; i < days.getSize(); i++) {
			days.get().get(i).setText("");
			if (days.get().get(i).equals(hoy)) {
				days.get().get(i).getStyleClass().remove("today");
			}
		}
		for (int i = comienzo, j = 1; j < yearMonthObject.lengthOfMonth() + 1; i++, j++) {
			days.get().get(i).setText(j + "");
			if (LocalDate.now().getYear() == yearProperty.get()
					&& LocalDate.now().getMonthValue() == monthProperty.get() && j == LocalDate.now().getDayOfMonth()) {
				days.get().get(i).getStyleClass().add("today");
				hoy = days.get(i);
			}
		}

		
		switch (monthProperty.getValue()) {
		case 1:
			mesLabel.setText("Enero");
			break;
		case 2:
			mesLabel.setText("Febrero");
			break;
		case 3:
			mesLabel.setText("Marzo");
			break;
		case 4:
			mesLabel.setText("Abril");
			break;
		case 5:
			mesLabel.setText("Mayo");
			break;
		case 6:
			mesLabel.setText("Junio");
			break;
		case 7:
			mesLabel.setText("Julio");
			break;
		case 8:
			mesLabel.setText("Agosto");
			break;
		case 9:
			mesLabel.setText("Septiembre");
			break;
		case 10:
			mesLabel.setText("Octubre");
			break;
		case 11:
			mesLabel.setText("Noviembre");
			break;
		case 12:
			mesLabel.setText("Diciembre");
			break;
		default:
			break;
		}
	}

	public final IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}

	public final int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}

	public final void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
	}

	public final IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}

	public final int getYearProperty() {
		return this.yearPropertyProperty().get();
	}

	public final void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}

}
