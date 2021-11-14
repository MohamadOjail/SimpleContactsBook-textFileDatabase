package ojail.mohamad.contactbook.controllers;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ojail.mohamad.contactbook.model.PersonModel;

public class EditController {
	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField telNumberField;
	@FXML private Label validateLabel;
	@FXML private DatePicker datePicker;

	int index;
	private ObservableList<PersonModel> list;
	public void setModel(PersonModel model, ObservableList<PersonModel> list) {
		this.list = list;
		index = list.indexOf(model);
		firstNameField.setText(list.get(index).getFirstName());
		lastNameField.setText(list.get(index).getLastName());
		telNumberField.setText(list.get(index).getTelNumber());
		datePicker.setValue(list.get(index).getBirthDate());
	}

	public void editPerson() {
		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();
		String phoneNumber = telNumberField.getText();
		LocalDate BirthDate = datePicker.getValue();

		list.set(index, new PersonModel(list.get(index).getID(), firstName, lastName, phoneNumber, BirthDate));
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
