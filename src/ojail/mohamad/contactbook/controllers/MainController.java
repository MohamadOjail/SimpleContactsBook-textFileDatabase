package ojail.mohamad.contactbook.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;

public class MainController {
	
	@FXML private HBox titlePane;
	
	Dialog<ButtonType> dialog = new Dialog<>();
	
    @FXML  void delete(ActionEvent event) {
    	Alert deleteAlert = new Alert(AlertType.CONFIRMATION);
    	deleteAlert.setHeaderText("Remove person from contacts book");
    	deleteAlert.setContentText("This will delete the person from the contact book list.\n you cannot undo this, are you sure you want to delete?");
    	Optional<ButtonType> clickedButton = deleteAlert.showAndWait();
		if(clickedButton.get() == ButtonType.OK) {
			System.out.println("Clicked OK");
		}
    }
	
    @FXML void showEdit(ActionEvent event) throws IOException {
    	DialogPane edittDialog = FXMLLoader.load(getClass().getResource("/Edit.fxml"));
		dialog.setDialogPane(edittDialog);
		Optional<ButtonType> clickedButton = dialog.showAndWait();
		if(clickedButton.get() == ButtonType.OK) {
			System.out.println("Clicked OK");
		}
    }
	
    @FXML  void showAddDialog(ActionEvent event) throws IOException {
    	DialogPane addtDialog = FXMLLoader.load(getClass().getResource("/Add.fxml"));
		dialog.setDialogPane(addtDialog);
		Optional<ButtonType> clickedButton = dialog.showAndWait();
		if(clickedButton.get() == ButtonType.OK) {
			System.out.println("Clicked OK");
		}
    }
	
	@FXML public void showAbout(ActionEvent event) throws IOException {
		DialogPane aboutDialog = FXMLLoader.load(getClass().getResource("/About.fxml"));
		dialog.setDialogPane(aboutDialog);
		dialog.showAndWait();
	}
}
