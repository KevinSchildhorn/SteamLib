package com.kevinschildhorn.steamlib.DataClasses;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamAchievement {
    String name;
    String apiName;
    String description;
    double percent;
    int achieved;
    Date unlockTime;
    String icon;
    String iconGray;
    int hidden;
    int defaultValue;

    public SteamAchievement(JSONObject obj) throws JSONException {
        if(obj.has("name"))
            this.apiName = obj.getString("name");
        if(obj.has("apiname"))
            this.apiName = obj.getString("apiname");
        if(obj.has("displayName"))
            this.name = obj.getString("displayName");
        if(obj.has("description"))
            this.description = obj.getString("description");
        if(obj.has("percent"))
            this.percent = obj.getDouble("percent");
        if(obj.has("achieved"))
            this.achieved = obj.getInt("achieved");
        if(obj.has("unlocktime"))
            this.unlockTime = new Date(obj.getLong("unlocktime")*1000L);
        if(obj.has("icon"))
            this.icon = obj.getString("icon");
        if(obj.has("icongray"))
            this.iconGray = obj.getString("icongray");
        if(obj.has("hidden"))
            this.hidden = obj.getInt("hidden");
        if(obj.has("defaultvalue"))
            this.defaultValue = obj.getInt("defaultvalue");
    }
}
