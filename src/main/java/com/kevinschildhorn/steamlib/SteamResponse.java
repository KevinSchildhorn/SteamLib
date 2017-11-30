package com.kevinschildhorn.steamlib;

import com.kevinschildhorn.steamlib.DataClasses.SteamAchievement;
import com.kevinschildhorn.steamlib.DataClasses.SteamFriend;
import com.kevinschildhorn.steamlib.DataClasses.SteamGame;
import com.kevinschildhorn.steamlib.DataClasses.SteamGameStat;
import com.kevinschildhorn.steamlib.DataClasses.SteamNewsItem;
import com.kevinschildhorn.steamlib.DataClasses.SteamPlayer;
import com.kevinschildhorn.steamlib.DataClasses.SteamPlayerStat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kschildhorn on 11/28/17.
 */

public class SteamResponse {
    private String steamID;
    private ArrayList<SteamNewsItem> newsItems;
    private ArrayList<SteamAchievement> achievements;
    private ArrayList<SteamFriend> friends;
    private ArrayList<SteamGame> games;
    private ArrayList<SteamPlayer> players;
    private int lenderSteamID;
    private SteamGameStat gameStat;
    private SteamPlayerStat playerStat;
    private HashMap<Integer,ArrayList> gameCategories = new HashMap<>();

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public ArrayList<SteamNewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(ArrayList<SteamNewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public ArrayList<SteamAchievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<SteamAchievement> achievements){
        this.achievements = achievements;
    }

    public ArrayList<SteamFriend> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<SteamFriend> friends) {
        this.friends = friends;
    }

    public ArrayList<SteamGame> getGames() {
        return games;
    }

    public void setGames(ArrayList<SteamGame> games) {
        this.games = games;
    }

    public ArrayList<SteamPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<SteamPlayer> players) {
        this.players = players;
    }

    public int getLenderSteamID() {
        return lenderSteamID;
    }

    public void setLenderSteamID(int lenderSteamID) {
        this.lenderSteamID = lenderSteamID;
    }

    public SteamGameStat getGameStat() {
        return gameStat;
    }

    public void setGameStat(SteamGameStat gameStat) {
        this.gameStat = gameStat;
    }

    public SteamPlayerStat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(SteamPlayerStat playerStat) {
        this.playerStat = playerStat;
    }

    public HashMap<Integer, ArrayList> getGameCategories() {
        return gameCategories;
    }

    public void insertGameCategory(Integer key, ArrayList value) {
        this.gameCategories.put(key,value);
    }
}
