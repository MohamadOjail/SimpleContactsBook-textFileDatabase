package ojail.mohamad.contactbook.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import ojail.mohamad.contactbook.logic.DataListLogic;
import ojail.mohamad.contactbook.logic.DataWriter;
import ojail.mohamad.contactbook.model.PersonModel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javafx.event.ActionEvent;

public class MainController {
	
	DataWriter dataWriter = new DataWriter();
	DataListLogic datList = new DataListLogic();
	
	@FXML private HBox titlePane;
	
    @FXML  void delete(ActionEvent event) {
    	ButtonType clickedButton = showDeleteDialog();
    	System.out.println(clickedButton.getButtonData());
    	if(clickedButton.equals(ButtonType.OK)) dataWriter.updateData("one record has been deleted");
    }
	
    @FXML void showEdit(ActionEvent event) throws IOException {
    	ButtonType clickedButton = ShowDialog("/Edit.fxml");
    	System.out.println(clickedButton.getButtonData());
    	if(clickedButton.equals(ButtonType.OK)) dataWriter.updateData("records has been modified");
    }
	
    @FXML  void showAddDialog(ActionEvent event) throws IOException {
    	ButtonType clickedButton = ShowDialog("/Add.fxml");
    	System.out.println(clickedButton.getButtonData());
    	if(clickedButton.equals(ButtonType.OK)) dataWriter.writeFile("New person added");
    }
	
	@FXML public void showAbout(ActionEvent event) throws IOException {
		ShowDialog("/About.fxml");
	}
	
	// show delete Alert and return button clicked
	protected ButtonType showDeleteDialog() {
		Alert deleteAlert = new Alert(AlertType.CONFIRMATION);
    	deleteAlert.setHeaderText("Remove person from contacts book");
    	deleteAlert.setContentText("This will delete the person from the contact book list.\n you cannot undo this, are you sure you want to delete?");
    	Optional<ButtonType> clickedButton = deleteAlert.showAndWait();
    	return clickedButton.get();
	}
	
	// Show DialogPane and return button clicked
	protected ButtonType ShowDialog(String path) {
		Dialog<ButtonType> dialog = new Dialog<>();
		DialogPane dialogPane;
		try {
			dialogPane = FXMLLoader.load(getClass().getResource(path));
			dialog.setDialogPane(dialogPane);
			Optional<ButtonType> clickedButton = dialog.showAndWait();
			return clickedButton.get();
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
	    	alert.setHeaderText(e.getLocalizedMessage());
	    	alert.showAndWait();
		}
		return null;
	}
	
	@FXML private TableView<PersonModel> contactTable;
	@FXML private TableColumn<PersonModel, LocalDate> dateCol;
	@FXML private TableColumn<PersonModel, String> fNameCol;
	@FXML private TableColumn<PersonModel, Integer> idCol;
	@FXML private TableColumn<PersonModel, String> lNameCol;
	@FXML private TableColumn<PersonModel, String> telCol;
    
	@FXML private void initialize() {
		datList.populateList();
		contactTable.setItems(datList.getList());
		idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
		fNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		telCol.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
	}
}
