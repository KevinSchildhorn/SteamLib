package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamStat {
    String name;
    String defaultValue;
    String displayName;

    public SteamStat(JSONObject obj) throws JSONException {
        if(obj.has("name"))
            this.name = obj.getString("name");
        if(obj.has("defaultvalue"))
            this.defaultValue = obj.getString("defaultvalue");
        if(obj.has("displayName"))
            this.defaultValue = obj.getString("displayName");
    }
}
