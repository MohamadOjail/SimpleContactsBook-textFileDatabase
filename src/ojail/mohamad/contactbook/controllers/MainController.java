package ojail.mohamad.contactbook.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import ojail.mohamad.contactbook.logic.DataListLogic;
import ojail.mohamad.contactbook.model.PersonModel;

public class MainController {

	private DataListLogic dataListLogic = new DataListLogic();
	private ObservableList<PersonModel> list;
	@FXML private HBox titlePane;
    @FXML private AnchorPane mainPane;
	@FXML private TableView<PersonModel> contactTable;
	@FXML private TableColumn<PersonModel, LocalDate> dateCol;
	@FXML private TableColumn<PersonModel, String> fNameCol;
	@FXML private TableColumn<PersonModel, Integer> idCol;
	@FXML private TableColumn<PersonModel, String> lNameCol;
	@FXML private TableColumn<PersonModel, String> telCol;

	// Add new Contact Dialog
    @FXML void add(ActionEvent event) {
    	try{
			Dialog<ButtonType> dialog = new Dialog<>();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/Add.fxml"));
			dialog.getDialogPane().setContent(fxmlLoader.load());
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
			AddController addPaneController = fxmlLoader.getController();
			Optional<ButtonType> result = dialog.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				addPaneController.setList(dataListLogic.getList());
				addPaneController.addPerson();
			}
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getLocalizedMessage());
			alert.showAndWait();
		}
    }

    // Edit Contact Dialog
    @FXML void edit(ActionEvent event) {
    	if (contactTable.getSelectionModel().getSelectedItem() != null) {
			try {
				Dialog<ButtonType> dialog = new Dialog<>();
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("/Edit.fxml"));
				dialog.getDialogPane().setContent(fxmlLoader.load());
				dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
				dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
				EditController editController = fxmlLoader.getController();
				editController.setModel(contactTable.getSelectionModel().getSelectedItem(), dataListLogic.getList());
				Optional<ButtonType> result = dialog.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					editController.editPerson();
				}
			} catch (Exception e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(e.getLocalizedMessage());
				alert.setContentText(e.getClass().getName());
				alert.showAndWait();
			}
		}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		DialogPane dialogPane = alert.getDialogPane();
    		dialogPane.setStyle("-fx-font-size: 18");
			alert.setTitle("Error");
			alert.setHeaderText("No item selected");
			alert.showAndWait();
		}
    }
    
    // Delete Contact Dialog
    @FXML void delete(ActionEvent event) {
    	if(contactTable.getSelectionModel().getSelectedItem() != null) {
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    		DialogPane dialogPane = alert.getDialogPane();
    		dialogPane.setStyle("-fx-font-size: 18");
			alert.setHeaderText("You cannot undo this, delete contact?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				list.remove(list.indexOf(contactTable.getSelectionModel().getSelectedItem()));
			}
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		DialogPane dialogPane = alert.getDialogPane();
    		dialogPane.setStyle("-fx-font-size: 18");
			alert.setTitle("Error");
			alert.setHeaderText("No item selected");
			alert.showAndWait();
		}
    }
    
    // About Dialog
    @FXML void about(ActionEvent event) {
    	try{
			Dialog<ButtonType> dialog = new Dialog<>();
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/About.fxml"));
			dialog.getDialogPane().setContent(fxmlLoader.load());
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.showAndWait();
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(e.getLocalizedMessage());
			alert.setContentText(e.getClass().getName());
			alert.showAndWait();
		}
    }

	@FXML private void initialize() throws IOException {
		dataListLogic.populateList();
		this.list = dataListLogic.getList();
		contactTable.setItems(this.list);
		idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
		fNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		telCol.setCellValueFactory(new PropertyValueFactory<>("TelNumber"));
	}
}