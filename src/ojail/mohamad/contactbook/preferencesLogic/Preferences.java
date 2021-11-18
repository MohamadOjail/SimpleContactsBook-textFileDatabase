package ojail.mohamad.contactbook.preferencesLogic;

import java.io.Serializable;

public class Preferences implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 770177274204905712L;
	
	private String cssFilePath;
	private int theme;
	
	public Preferences(int theme) {
		super();
		this.theme = theme;
		this.cssFilePath = cssPath(theme);
	}

	public int getTheme() {
		return theme;
	}

	public void setTheme(int theme) {
		this.theme = theme;
		this.cssFilePath = cssPath(theme);
	}

	public String getCssFilePath() {
		return cssFilePath;
	}
	
	private String cssPath(int theme) {
		return theme == 0 ? "/resources/application.css" : "/resources/applicationDark.css";
	}
}
