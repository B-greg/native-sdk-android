package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tar on 6/24/16 AD.
 */
public class OrganizeResponse {

  // TODO, make this class an inner class of StoreOrganizeApiResult
  @SerializedName("_id")
  public String id;
  @SerializedName("name")
  public String name;
  @SerializedName("description")
  public String description;

}
