package ojail.mohamad.contactbook.logic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ojail.mohamad.contactbook.model.PersonModel;

public class DataListLogic {
	
	DataReader reader = new DataReader();
	
	ObservableList<PersonModel> list = FXCollections.observableArrayList();
	public void populateList() {
		list = reader.getData();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getFirstName() + list.get(i).getLastName());
		}
	}
	public ObservableList<PersonModel> getList() {
		return list;
	}
}
