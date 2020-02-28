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

	private Label justtoday;
	private ListProperty<Label> days = new SimpleListProperty<Label>(FXCollections.observableArrayList());
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();

	// model

	@FXML
	private BorderPane root;

	@FXML
	private Label monthLabel;

	@FXML
	private Label acero;

	@FXML
	private Label auno;

	@FXML
	private Label ados;

	@FXML
	private Label atres;

	@FXML
	private Label acuatro;

	@FXML
	private Label acinco;

	@FXML
	private Label aseis;

	@FXML
	private Label bcero;

	@FXML
	private Label buno;

	@FXML
	private Label bdos;

	@FXML
	private Label btres;

	@FXML
	private Label bcuatro;

	@FXML
	private Label bcinco;

	@FXML
	private Label bseis;

	@FXML
	private Label ccero;

	@FXML
	private Label cuno;

	@FXML
	private Label cdos;

	@FXML
	private Label ctres;

	@FXML
	private Label ccuatro;

	@FXML
	private Label ccinco;

	@FXML
	private Label cseis;

	@FXML
	private Label dcero;

	@FXML
	private Label duno;

	@FXML
	private Label ddos;

	@FXML
	private Label dtres;

	@FXML
	private Label dcuatro;

	@FXML
	private Label dcinco;

	@FXML
	private Label dseis;

	@FXML
	private Label ecero;

	@FXML
	private Label euno;

	@FXML
	private Label edos;

	@FXML
	private Label etres;

	@FXML
	private Label ecuatro;

	@FXML
	private Label ecinco;

	@FXML
	private Label eseis;

	@FXML
	private Label fcero;

	@FXML
	private Label funo;

	@FXML
	private Label fdos;

	@FXML
	private Label ftres;

	@FXML
	private Label fcuatro;

	@FXML
	private Label fcinco;

	@FXML
	private Label fseis;

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

		days.addAll(acero, auno, ados, atres, acuatro, acinco, aseis, bcero, buno, bdos, btres, bcuatro, bcinco, bseis,
				ccero, cuno, cdos, ctres, ccuatro, ccinco, cseis, dcero, duno, ddos, dtres, dcuatro, dcinco, dseis,
				ecero, euno, edos, etres, ecuatro, ecinco, eseis, fcero, funo, fdos, ftres, fcuatro, fcinco, fseis);

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
			if (days.get().get(i).equals(justtoday)) {
				days.get().get(i).getStyleClass().remove("today");
			}
		}
		for (int i = comienzo, j = 1; j < yearMonthObject.lengthOfMonth() + 1; i++, j++) {
			days.get().get(i).setText(j + "");
			if (LocalDate.now().getYear() == yearProperty.get()
					&& LocalDate.now().getMonthValue() == monthProperty.get() && j == LocalDate.now().getDayOfMonth()) {
				days.get().get(i).getStyleClass().add("today");
				justtoday = days.get(i);
			}
		}

		switch (monthProperty.getValue()) {
		case 1:
			monthLabel.setText("Enero");
			break;
		case 2:
			monthLabel.setText("Febrero");
			break;
		case 3:
			monthLabel.setText("Marzo");
			break;
		case 4:
			monthLabel.setText("Abril");
			break;
		case 5:
			monthLabel.setText("Mayo");
			break;
		case 6:
			monthLabel.setText("Junio");
			break;
		case 7:
			monthLabel.setText("Julio");
			break;
		case 8:
			monthLabel.setText("Agosto");
			break;
		case 9:
			monthLabel.setText("Septiembre");
			break;
		case 10:
			monthLabel.setText("Octubre");
			break;
		case 11:
			monthLabel.setText("Noviembre");
			break;
		case 12:
			monthLabel.setText("Diciembre");
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
