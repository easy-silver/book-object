package chap11.properties;

import java.util.Hashtable;

/**
 * Hashtable을 합성 관계로 보유한 Properties
 */
public class Properties {

    private Hashtable<String, String> properties = new Hashtable<>();

    public String setProperty(String key, String value) {
        return properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
