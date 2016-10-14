package com.baiye.DB;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Baiye on 2016/10/11.
 */
public class DBConf {

    public static String readValue(String key)
    {
        Properties props = new Properties();
        InputStream is = DBConf.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = (String) props.get(key);
        return value;
    }

    public static final String DATABASE_URL = "database.url";

    public static final String DATABASE_USERNAME = "database.username";

    public static final String DATABASE_PASSWORD = "database.password";

    public static final String DATABASE_DRIVERNAME = "database.driverName";

}
