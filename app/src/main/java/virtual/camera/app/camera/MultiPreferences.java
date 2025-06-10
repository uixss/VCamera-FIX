package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;

public class MultiPreferences {

    private static final String PREF_NAME = "app_prefs";
    private static MultiPreferences instance;
    private SharedPreferences preferences;

    private MultiPreferences(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new MultiPreferences(context);
        }
    }

    public static MultiPreferences getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MultiPreferences no inicializado. Llama a init(context) primero.");
        }
        return instance;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    public void setBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }

    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public void setInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public void setString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }
}
