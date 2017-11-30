package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kschildhorn on 11/29/17.
 */

public class SteamCategory {
    int id;
    String description;

    public SteamCategory(JSONObject obj) throws JSONException {
        if(obj.has("id"))
            this.id = obj.getInt("id");
        if(obj.has("description"))
            this.description = obj.getString("description");
    }
}
