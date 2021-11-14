# Simple Contact book application
> This is a tutorial example
This is my way of learning; I teach myself things by creating a scenario and start building a solution
the process of producing the solution will interduce many difficulties and finding solutions helps the memory muscles develop.

## the application utilizes a text file as a database
## Developed with JavaFx

### Javafx technique learned:
- Create Custom Dialog Panes.
- Load the panes from FXML files.
- Hook up the Controllers.
- Understand the delay to correctly call methods in the initialize method:
```java
@FXML private void initialize() throws InterruptedException {
		Thread.sleep(100);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	        	firstNameField.requestFocus();
	        }
	    });
	}
```
- Using ObservableList and it's Event listener.

### Other Techniques learned:
- Using special char to purposely use a string:
`1|First Name;Last Name:2021-11-01.123456`
- Calling a hyperlink in the user default web browser.

### Challenges:
- Avoiding getting null when referring to a controller.
- Hooking the TableView to the ObservableList.
- Simplify the code as possible.
- dealing with exceptions.

## Demo:
![](/resources/pix/demo.gif)