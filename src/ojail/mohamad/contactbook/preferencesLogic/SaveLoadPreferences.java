package ojail.mohamad.contactbook.preferencesLogic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoadPreferences {
	
private File settingsFile = new File("preferences.dat");
	
	public Preferences loadPreferences() {
		if(load() != null) return load();
		else {
			savePreferences(new Preferences(0));
			return loadPreferences();
		}
	}
	
	public void savePreferences(Preferences preferences) {
		save(preferences);
	}
	
	private void save(Preferences preferences) {
		try {
			FileOutputStream fos = new FileOutputStream(settingsFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(preferences);
			oos.close();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	private Preferences load() {
		try {
			FileInputStream fis = new FileInputStream(settingsFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Preferences preferences = (Preferences)ois.readObject();
			ois.close();
			return preferences;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return null;
	}
}
