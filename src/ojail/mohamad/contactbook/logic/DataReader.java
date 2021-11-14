package ojail.mohamad.contactbook.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ojail.mohamad.contactbook.model.PersonModel;

public class DataReader {

	File path = new File("data.txt");
	DataWriter writer = new DataWriter();

	public ObservableList<PersonModel> getData() {
		ObservableList<PersonModel> output = FXCollections.observableArrayList();
		try {
			if(!path.exists()) writer.createDefault();
			if(path.exists()) output.clear();
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			while ((line = br.readLine()) != null) {
				int id = Integer.parseInt(line.substring(0, line.indexOf('|')));
				String firstName = line.substring( line.indexOf('|') + 1, line.indexOf(';') );
				String lastName = line.substring(line.indexOf(';') + 1, line.indexOf(':'));
				String dateString = line.substring(line.indexOf(':') + 1, line.indexOf('.'));
				LocalDate date = LocalDate.parse(dateString);
				String tel = line.substring(line.indexOf('.') + 1, line.length());
				output.add(new PersonModel(id, firstName, lastName, tel, date));
			}
			br.close();
			return output;
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(e.getClass().getSimpleName());
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(e.getClass().getSimpleName());
			alert.setHeaderText(e.getMessage());
			alert.setContentText("invalid data file");
			alert.showAndWait();
		}
		output.clear();
		return output;
	}

	//buffer.append(sc.nextLine()+System.lineSeparator());

}
