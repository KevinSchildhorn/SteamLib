package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamFriend {
    String steamID;
    String relationship;
    Date friendsSince;

    public SteamFriend(JSONObject obj) throws JSONException {
        if(obj.has("steamid"))
            this.steamID = obj.getString("steamid");
        if(obj.has("relationship"))
            this.relationship = obj.getString("relationship");
        if(obj.has("friend_since"))
            this.friendsSince = new Date(obj.getLong("friend_since")*1000L);
    }
}
