package ojail.mohamad.contactbook.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;

public class AboutController {

	@FXML private TextArea infoField;

	@FXML private Hyperlink link;

	String infoString = "Developed by:\nMohamad Ojail\nmohamad.ojail@gmail.com";

    @FXML  void goToGithub(ActionEvent event) {
    	if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/MohamadOjail"));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }

	@FXML private void initialize() {
		infoField.setText(infoString);
	}
}
