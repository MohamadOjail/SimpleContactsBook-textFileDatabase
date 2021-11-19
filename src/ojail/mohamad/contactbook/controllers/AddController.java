package ojail.mohamad.contactbook.controllers;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ojail.mohamad.contactbook.model.PersonModel;
import ojail.mohamad.contactbook.preferencesLogic.Preferences;
import ojail.mohamad.contactbook.preferencesLogic.SaveLoadPreferences;

public class AddController {

    @FXML private DialogPane addPane;

	public void setList(ObservableList<PersonModel> list) {
		this.list = list;
	}

	private ObservableList<PersonModel> list;

	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField telNumberField;
	@FXML private Label validateLabel;
	@FXML private DatePicker datePicker;

	public void addPerson() {
		int id = (!list.isEmpty()) ? list.get(list.size() - 1).getID() + 1 : 1;
		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();
		String phoneNumber = telNumberField.getText();
		LocalDate BirthDate = datePicker.getValue();

		PersonModel model = new PersonModel( id, firstName, lastName, phoneNumber, BirthDate);
		list.add(model);
	}

	@FXML private void initialize() throws InterruptedException {
		Thread.sleep(100);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	firstNameField.requestFocus();
	        }
	    });
	}
}
