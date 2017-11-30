package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamGameStat {
    String gameName;
    int gameVersion;
    ArrayList achievements;
    ArrayList stats;

    public SteamGameStat(JSONObject obj) throws JSONException {
        if(obj.has("gameName"))
            this.gameName = obj.getString("gameName");
        if(obj.has("gameVersion"))
            this.gameVersion = obj.getInt("gameVersion");
        if(obj.has("availableGameStats")) {
            JSONObject obj2 = obj.getJSONObject("availableGameStats");
            if (obj2.has("achievements")) {
                ArrayList newsItems = new ArrayList();
                JSONArray newsItemsJSON = obj2.getJSONArray("achievements");
                for (int i = 0; i < newsItemsJSON.length(); i++) {
                    JSONObject temp = newsItemsJSON.getJSONObject(i);
                    SteamAchievement item = new SteamAchievement(temp);
                    newsItems.add(item);
                }
                this.achievements = newsItems;
            }
            if (obj2.has("stats")) {
                ArrayList newsItems = new ArrayList();
                JSONArray newsItemsJSON = obj2.getJSONArray("stats");
                for (int i = 0; i < newsItemsJSON.length(); i++) {
                    JSONObject temp = newsItemsJSON.getJSONObject(i);
                    SteamStat item = new SteamStat(temp);
                    newsItems.add(item);
                }
                this.stats = newsItems;
            }
        }
    }
}
