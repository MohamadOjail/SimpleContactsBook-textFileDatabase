package ojail.mohamad.contactbook.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataWriter {
	File path = new File("data.txt");
	
	public void writeFile(String data) {
		
		if(path.exists()) add(data);
		else create(data);
	}
	
	public void updateData(String data) {
		create(data);
	}
	
	private void add(String data) {
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(path, true));
			br.flush();
			br.write("\n" + data);
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
}
