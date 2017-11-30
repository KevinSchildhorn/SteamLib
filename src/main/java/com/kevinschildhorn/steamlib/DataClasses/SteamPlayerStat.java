package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kschildhorn on 11/29/17.
 */

public class SteamPlayerStat {
    String steamID;
    String gameName;
    ArrayList<SteamAchievement> achievements;

    public SteamPlayerStat(JSONObject obj) throws JSONException {
        if(obj.has("steamID"))
            this.steamID = obj.getString("steamID");
        if(obj.has("gameName"))
            this.gameName = obj.getString("gameName");
        if(obj.has("achievements")){
            ArrayList newItems = new ArrayList();
            JSONArray newItemsJSON = obj.getJSONArray("achievements");
            for(int i=0;i<newItemsJSON.length();i++){
                JSONObject temp = newItemsJSON.getJSONObject(i);
                SteamAchievement item = new SteamAchievement(temp);
                newItems.add(item);
            }
            this.achievements = newItems;
        }
    }

}
