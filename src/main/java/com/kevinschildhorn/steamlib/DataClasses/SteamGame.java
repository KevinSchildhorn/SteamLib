package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamGame {
    private int appID;
    private String name;
    private int playtimeTwoWeeks;
    private int playtimeForever;
    private String imgIconUrl;
    private String imgLogoUrl;
    private boolean hasCommunityVisibleStats;

    public SteamGame(JSONObject obj) throws JSONException {
        if(obj.has("appid"))
            this.appID = obj.getInt("appid");
        if(obj.has("name"))
            this.name = obj.getString("name");
        if(obj.has("playtime_2weeks"))
            this.playtimeTwoWeeks = obj.getInt("playtime_2weeks");
        if(obj.has("playtime_forever"))
            this.playtimeForever = obj.getInt("playtime_forever");
        if(obj.has("img_icon_url"))
            this.imgIconUrl = obj.getString("img_icon_url");
        if(obj.has("img_logo_url"))
            this.imgLogoUrl = obj.getString("img_logo_url");
        if(obj.has("has_community_visible_stats"))
            this.hasCommunityVisibleStats = obj.getBoolean("has_community_visible_stats");
    }

    public int getAppID() {
        return appID;
    }

    public String getName() {
        return name;
    }

    public int getPlaytimeTwoWeeks() {
        return playtimeTwoWeeks;
    }

    public int getPlaytimeForever() {
        return playtimeForever;
    }

    public String getImgIconUrl() {
        return imgIconUrl;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }
    public boolean getHasCommunityVisibleStats(){
        return hasCommunityVisibleStats;
    }

}

