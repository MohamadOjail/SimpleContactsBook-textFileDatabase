package ojail.mohamad.contactbook.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ojail.mohamad.contactbook.preferencesLogic.Preferences;
import ojail.mohamad.contactbook.preferencesLogic.SaveLoadPreferences;

public class Launcher extends Application {
	
	private SaveLoadPreferences saveLoadPreferences;
	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
		Parent root = loader.load();
		
		saveLoadPreferences = new SaveLoadPreferences();
		Preferences preferences = saveLoadPreferences.loadPreferences();
		root.getStylesheets().add(preferences.getCssFilePath());
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
