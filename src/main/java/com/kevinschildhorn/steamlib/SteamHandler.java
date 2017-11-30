package com.kevinschildhorn.steamlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.kevinschildhorn.steamlib.DataClasses.SteamAchievement;
import com.kevinschildhorn.steamlib.DataClasses.SteamCategory;
import com.kevinschildhorn.steamlib.DataClasses.SteamFriend;
import com.kevinschildhorn.steamlib.DataClasses.SteamGame;
import com.kevinschildhorn.steamlib.DataClasses.SteamGameStat;
import com.kevinschildhorn.steamlib.DataClasses.SteamNewsItem;
import com.kevinschildhorn.steamlib.DataClasses.SteamPlayer;
import com.kevinschildhorn.steamlib.DataClasses.SteamPlayerStat;
import com.kevinschildhorn.steamlib.HTTP.HTTPReplyHandler;
import com.kevinschildhorn.steamlib.HTTP.HTTPRequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamHandler implements HTTPReplyHandler {


    public final static int RESPONSE_ACHIEVEMENTS  =1;
    public final static int RESPONSE_APPNEWS       =2;
    public final static int RESPONSE_FRIENDS       =3;
    public final static int RESPONSE_GAME          =4;
    public final static int RESPONSE_GAMESTAT      =5;
    public final static int RESPONSE_GLOBALSTATS   =6;
    public final static int RESPONSE_LENDER        =7;
    public final static int RESPONSE_PLAYERS       =8;
    public final static int RESPONSE_PLAYERSTATS   =9;
    public final static int RESPONSE_STEAMID       =10;
    public final static int RESPONSE_GAMEDETAILS   =11;


    private String mSteamAPIKey;
    private SteamResponseHandler responseHandler;
    private int gameID;

    public SteamHandler(SteamResponseHandler handler,String apiKey){
        responseHandler = handler;
        mSteamAPIKey = apiKey;
    }


    public void RequestNewsForApp(int gameID,int count, int maxLength){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid=%d&count=%d&maxlength=%d&format=json",gameID,count,maxLength);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestGlobalAchievementPercentagesForApp(int gameID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?gameid=%d&format=json",gameID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestGlobalStatsForGame(int gameID, int count,String achievementName){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUserStats/GetGlobalStatsForGame/v0001/?format=json&appid=%d&count=%d&name[0]=%s",gameID, count,achievementName);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestPlayerSummaries(String steamID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=%s&steamids=%d",mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestFriendList(String steamID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=%s&steamid=%s&relationship=friend",mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestPlayerAchievements(String steamID, int gameID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=%s&key=%s&steamid=%s",gameID,mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestUserStatsForGame(String steamID, int gameID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?appid=%d&key=%s&steamid=%s",gameID, mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestOwnedGames(String steamID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=%s&steamid=%s&include_appinfo=1&include_played_free_games=1&format=json",mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestRecentlyPlayedGames(String steamID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v0001/?key=%s&steamid=%s&format=json",mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void IsPlayingSharedGame(String steamID, int gameID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/IPlayerService/IsPlayingSharedGame/v0001/?key=%s&steamid=%s&appid_playing=%d&format=json",mSteamAPIKey,steamID,gameID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestSchemaForGame(int gameID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUserStats/GetSchemaForGame/v2/?key=%s&appid=%d",mSteamAPIKey,gameID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestPlayerBan(String steamID){
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUser/GetPlayerBans/v1/?key=%s&steamids=%d",mSteamAPIKey,steamID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestSteamID(String userName) {
        String requestURI = String.format(Locale.ENGLISH,"http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=%s&vanityurl=%s",mSteamAPIKey,userName);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestAppDetailsForGame(int gameID){
        this.gameID = gameID;
        String requestURI = String.format(Locale.ENGLISH,"http://store.steampowered.com/api/appdetails/?appids=%d&filters=categories",gameID);
        HTTPRequestHandler requestHandler = new HTTPRequestHandler(this);
        requestHandler.sendRequest(requestURI);
    }

    public void RequestImageForGame(int appID, String url){
        if(url != null) {
            final String logoUrl = "http://media.steampowered.com/steamcommunity/public/images/apps/" + appID + "/" + url + ".jpg";
            new Thread(new Runnable() {
                public void run() {
                    Bitmap logoBitmap = null;
                    try {
                        InputStream in = new java.net.URL(logoUrl).openStream();
                        logoBitmap = BitmapFactory.decodeStream(in);
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseHandler.NewSteamError(e.getMessage());
                    }
                    responseHandler.NewSteamImage(logoBitmap);
                }
            }).start();
        }else {
            responseHandler.NewSteamError("URL is null");
        }
    }


    // HTTP Reply Handler

    @Override
    public void HTTPRequestSuccess(JSONObject resultJSON) {
        Log.i("TAG","Success!");
        try {
            HandleJSONResult(resultJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void HTTPRequestFailure(String errorMessage) {
        Log.e("SteamHandler",errorMessage);
        responseHandler.NewSteamError(errorMessage);
    }


    // Steam Response Handler

    public void HandleJSONResult(JSONObject resultJSON) throws JSONException {
        int responseType = 0;
        SteamResponse steamResponse = new SteamResponse();
        if(resultJSON.has("response")) {
            JSONObject result2JSON = resultJSON.getJSONObject("response");
            HandleJSONResult(result2JSON);
        }
        else if(resultJSON.has("achievementpercentages")){
            responseType = RESPONSE_ACHIEVEMENTS;
            JSONObject result2JSON = resultJSON.getJSONObject("achievementpercentages");
            if(result2JSON.has("achievements")){
                ArrayList newsItems = new ArrayList();
                JSONArray newsItemsJSON = result2JSON.getJSONArray("achievements");
                for(int i=0;i<newsItemsJSON.length();i++){
                    JSONObject temp = newsItemsJSON.getJSONObject(i);
                    SteamAchievement item = new SteamAchievement(temp);
                    newsItems.add(item);
                }
                steamResponse.setAchievements(newsItems);
            }
        }
        else if(resultJSON.has("appnews")){
            responseType = RESPONSE_APPNEWS;
            JSONObject result2JSON = resultJSON.getJSONObject("appnews");
            if(result2JSON.has("newsitems")){
                ArrayList newsItems = new ArrayList();
                JSONArray newsItemsJSON = result2JSON.getJSONArray("newsitems");
                for(int i=0;i<newsItemsJSON.length();i++){
                    JSONObject temp = newsItemsJSON.getJSONObject(i);
                    SteamNewsItem item = new SteamNewsItem(temp);
                    newsItems.add(item);
                }
                steamResponse.setNewsItems(newsItems);
            }
        }
        else if(resultJSON.has("friendslist")){
            responseType = RESPONSE_FRIENDS;
            JSONObject result2JSON = resultJSON.getJSONObject("friendslist");
            if(result2JSON.has("friends")){
                ArrayList newsItems = new ArrayList();
                JSONArray newsItemsJSON = result2JSON.getJSONArray("friends");
                for(int i=0;i<newsItemsJSON.length();i++){
                    JSONObject temp = newsItemsJSON.getJSONObject(i);
                    SteamFriend item = new SteamFriend(temp);
                    newsItems.add(item);
                }
                steamResponse.setFriends(newsItems);
            }
        }
        else if(resultJSON.has("game")){
            responseType = RESPONSE_GAMESTAT;
            JSONObject result2JSON = resultJSON.getJSONObject("game");
            SteamGameStat stat = new SteamGameStat(result2JSON);
            steamResponse.setGameStat(stat);
        }
        else if(resultJSON.has("games")){
            responseType = RESPONSE_GAME;
            ArrayList newsItems = new ArrayList();
            JSONArray newsItemsJSON = resultJSON.getJSONArray("games");
            for(int i=0;i<newsItemsJSON.length();i++){
                JSONObject temp = newsItemsJSON.getJSONObject(i);
                SteamGame item = new SteamGame(temp);
                newsItems.add(item);
            }
            steamResponse.setGames(newsItems);
        }
        else if(resultJSON.has("globalstats")){ // TODO
            responseType = RESPONSE_GLOBALSTATS;
            //steamResponse.setSteamID(response.getInt("steamid"));
        }

        else if(resultJSON.has("lender_steamid")){
            responseType = RESPONSE_LENDER;
            steamResponse.setLenderSteamID(resultJSON.getInt("lender_steamid"));
        }
        else if(resultJSON.has("players")){
            responseType = RESPONSE_PLAYERS;
            ArrayList newsItems = new ArrayList();
            JSONArray newsItemsJSON = resultJSON.getJSONArray("players");
            for(int i=0;i<newsItemsJSON.length();i++){
                JSONObject temp = newsItemsJSON.getJSONObject(i);
                SteamPlayer item = new SteamPlayer(temp);
                newsItems.add(item);
            }
            steamResponse.setPlayers(newsItems);
        }
        else if(resultJSON.has("playerstats")){
            responseType = RESPONSE_PLAYERSTATS;
            JSONObject result2JSON = resultJSON.getJSONObject("playerstats");
            SteamPlayerStat stat = new SteamPlayerStat(result2JSON);
            steamResponse.setPlayerStat(stat);
        }
        else if(resultJSON.has("steamid")){
            responseType = RESPONSE_STEAMID;
            steamResponse.setSteamID(resultJSON.getString("steamid"));
        }
        else if(resultJSON.has(gameID + "")){
            responseType = RESPONSE_GAMEDETAILS;
            JSONObject result2JSON = resultJSON.getJSONObject(gameID + "");
            if(result2JSON.has("data")){
                result2JSON = result2JSON.getJSONObject("data");
                if(result2JSON.has("categories")){
                    ArrayList newsItems = new ArrayList();
                    JSONArray itemsJSON = result2JSON.getJSONArray("categories");
                    for(int i=0;i<itemsJSON.length();i++){
                        JSONObject temp = itemsJSON.getJSONObject(i);
                        SteamCategory item = new SteamCategory(temp);
                        newsItems.add(item);
                    }
                    steamResponse.insertGameCategory(gameID,newsItems);
                }
            }

            gameID = -1;
        }

        responseHandler.NewSteamResponse(responseType,steamResponse);
    }
}
