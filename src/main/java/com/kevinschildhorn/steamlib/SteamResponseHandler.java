package com.kevinschildhorn.steamlib;

import android.graphics.Bitmap;

/**
 * Created by kschildhorn on 11/28/17.
 */

public interface SteamResponseHandler {
    void NewSteamResponse(int responseType,SteamResponse response);
    void NewSteamError(String errorMessage);
    void NewSteamImage(Bitmap bmp);
}
