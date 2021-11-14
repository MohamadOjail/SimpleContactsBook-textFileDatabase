package ojail.mohamad.contactbook.logic;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ojail.mohamad.contactbook.model.PersonModel;

public class DataListLogic {

	private DataReader reader = new DataReader();
	private DataWriter writer = new DataWriter();

	private ObservableList<PersonModel> list = FXCollections.observableArrayList();

	public void populateList() {
		list = reader.getData();
		if(list.isEmpty()) writer.createDefault();
		list.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				writer.writeFile(list);
			}
		});
	}
	public ObservableList<PersonModel> getList() {
		return list;
	}
}
