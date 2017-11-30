package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamPlayer {
    String steamID;
    int communityVisibilityState;
    int profileState;
    String personaName;
    long lastLogoff;
    String profileUrl;
    String avatar;
    String avatarMedium;
    String avatarFull;
    int personaState;
    String realName;
    long primaryClanID;
    Date timeCreated;
    int personaStateFlags;
    String locCountryCode;
    String locStateCode;
    int locCityID;

    boolean communityBanned;
    boolean VACBanned;
    int numberOfVACBans;
    int daysSinceLastBan;
    int numberOfGameBans;
    String economyBan;

    public SteamPlayer(JSONObject obj) throws JSONException {
        if(obj.has("steamid"))
            this.steamID = obj.getString("steamid");
        if(obj.has("communityvisibilitystate"))
            this.communityVisibilityState = obj.getInt("communityvisibilitystate");
        if(obj.has("profilestate"))
            this.profileState = obj.getInt("profilestate");
        if(obj.has("personaname"))
            this.personaName = obj.getString("personaname");
        if(obj.has("lastlogoff"))
            this.lastLogoff = obj.getLong("lastlogoff");
        if(obj.has("profileurl"))
            this.profileUrl = obj.getString("profileurl");
        if(obj.has("avatar"))
            this.avatar = obj.getString("avatar");
        if(obj.has("avatarmedium"))
            this.avatarMedium = obj.getString("avatarmedium");
        if(obj.has("avatarfull"))
            this.avatarFull = obj.getString("avatarfull");
        if(obj.has("personastate"))
            this.personaState = obj.getInt("personastate");
        if(obj.has("realname"))
            this.realName = obj.getString("realname");
        if(obj.has("primaryclanid"))
            this.primaryClanID = obj.getLong("primaryclanid");
        if(obj.has("timecreated"))
            this.timeCreated = new Date(obj.getLong("timecreated")*1000L);
        if(obj.has("personastateflags"))
            this.personaStateFlags = obj.getInt("personastateflags");
        if(obj.has("loccountrycode"))
            this.locCountryCode = obj.getString("loccountrycode");
        if(obj.has("locstatecode"))
            this.locStateCode = obj.getString("locstatecode");
        if(obj.has("loccityid"))
            this.locCityID = obj.getInt("loccityid");

        if(obj.has("SteamId"))
            this.steamID = obj.getString("SteamId");
        if(obj.has("CommunityBanned"))
            this.communityBanned = obj.getBoolean("CommunityBanned");
        if(obj.has("VACBanned"))
            this.VACBanned = obj.getBoolean("VACBanned");
        if(obj.has("NumberOfVACBans"))
            this.numberOfVACBans = obj.getInt("NumberOfVACBans");
        if(obj.has("DaysSinceLastBan"))
            this.daysSinceLastBan = obj.getInt("DaysSinceLastBan");
        if(obj.has("NumberOfGameBans"))
            this.numberOfGameBans = obj.getInt("NumberOfGameBans");
        if(obj.has("EconomyBan"))
            this.economyBan = obj.getString("EconomyBan");
    }
}
