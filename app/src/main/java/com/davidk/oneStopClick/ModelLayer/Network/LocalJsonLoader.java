package com.davidk.oneStopClick.ModelLayer.Network;

import java.io.IOException;
import java.io.InputStream;

public class LocalJsonLoader {

    public static LocalJsonLoader shared = new LocalJsonLoader();

    public String loadSpies() {
        String file = "res/raw/items.json";

        String json = null;
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(file);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}