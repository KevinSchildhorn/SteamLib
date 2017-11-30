package com.kevinschildhorn.steamlib.HTTP;

import org.json.JSONObject;

/**
 * SCM Products Inc.
 * Created by Kevin Schildhorn on Nov 05, 2014.
 *
 * HTTPReplyHandlers functions are called from the HTTPRequestHandler,
 * after a message is received from the Platforms API
 */

public interface HTTPReplyHandler {

    //  Present incoming Steam ID
    void HTTPRequestSuccess(JSONObject resultJSON);
    void HTTPRequestFailure(String errorMessage);
}