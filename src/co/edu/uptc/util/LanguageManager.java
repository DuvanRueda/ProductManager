package co.edu.uptc.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private ResourceBundle bundle;
    private Locale currentLocale;

    private LanguageManager(){
        currentLocale = new Locale("");
        bundle = ResourceBundle.getBundle("co.edu.uptc.lang.message", currentLocale);
    }

    public LanguageManager(String languages) {
        setLanguage(languages);
    }

    public void setLanguage(String languageCode) {
        currentLocale = new Locale(languageCode);
        ResourceBundle.clearCache();
        bundle = ResourceBundle.getBundle("co.edu.uptc.lang.message", currentLocale);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
