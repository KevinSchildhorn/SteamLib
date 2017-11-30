package com.kevinschildhorn.steamlib.DataClasses;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamNewsItem {
    long gID;
    String title;
    String url;
    boolean isExternalUrl;
    String author;
    String contents;
    String feedLabel;
    Date date;
    String feedName;
    long feedtype;
    long appID;

    public SteamNewsItem(JSONObject obj) throws JSONException {
        if(obj.has("gid"))
            this.gID = obj.getLong("gid");
        if(obj.has("title"))
            this.title = obj.getString("title");
        if(obj.has("url"))
            this.url = obj.getString("url");
        if(obj.has("is_external_url"))
            this.isExternalUrl = obj.getBoolean("is_external_url");
        if(obj.has("author"))
            this.author = obj.getString("author");
        if(obj.has("contents"))
            this.contents = obj.getString("contents");
        if(obj.has("feedlabel"))
            this.feedLabel = obj.getString("feedlabel");
        if(obj.has("date"))
            this.date = new Date(obj.getLong("date")*1000L);
        if(obj.has("feedname"))
            this.feedName = obj.getString("feedname");
        if(obj.has("feed_type"))
            this.feedtype = obj.getLong("feed_type");
        if(obj.has("appid"))
            this.appID = obj.getLong("appid");
    }
}
