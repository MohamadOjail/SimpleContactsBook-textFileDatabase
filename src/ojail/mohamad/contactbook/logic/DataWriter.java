package ojail.mohamad.contactbook.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ojail.mohamad.contactbook.model.PersonModel;

public class DataWriter {
	private File path = new File("data.txt");

	@SuppressWarnings("unchecked")
	public void writeFile(Object data) {

		if(data instanceof String) {
			System.out.println("your string is: " + data.toString());
		}

		if( data instanceof ObservableList) {
			String dataString = "";
			for (PersonModel person : (ObservableList<PersonModel>)data) {
				dataString += person.getPersonData() + "\n";
			}
			create(dataString);
		}

	}

	public void updateData(String data) {
		create(data);
	}

	private void create(String data) {
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(path));
			br.write(data);
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(e.getClass().getSimpleName());
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}
		finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle(e.getClass().getSimpleName());
					alert.setHeaderText(e.getMessage());
					alert.showAndWait();
				}
		}
	}

	public void createDefault() {
		create("");
	}
}
