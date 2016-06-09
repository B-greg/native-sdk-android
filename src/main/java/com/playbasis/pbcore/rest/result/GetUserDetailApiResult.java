package com.playbasis.pbcore.rest.result;

import com.google.gson.annotations.SerializedName;
import com.playbasis.pbcore.rest.result.response.GetPlayerInfoResponse;

/**
 * Created by androiddev01 on 4/26/2016 AD.
 */
public class GetUserDetailApiResult extends PBApiResult<GetUserDetailApiResult.Response> {
  public static final String TAG = "GetUserDetailApiResult";

  public String getEmail() {
    if (response != null) {
      return response.getPlayerInfoResponse.email;
    }

    return null;
  }

  public class Response {

    @SerializedName("player")
    public GetPlayerInfoResponse getPlayerInfoResponse;

  }
}