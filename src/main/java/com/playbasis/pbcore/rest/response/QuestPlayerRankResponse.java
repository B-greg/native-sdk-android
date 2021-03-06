package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Tar on 6/21/16 AD.
 */
public class QuestPlayerRankResponse {

  @Expose
  @SerializedName("current")
  public int current;
  @Expose
  @SerializedName("date_completed")
  public Date completedDate;
  @Expose
  @SerializedName("date_join")
  public Date joinedDate;
  @Expose
  @SerializedName("status")
  public String status;
  @Expose
  @SerializedName("goal")
  public int goal;
  @Expose
  @SerializedName("rank")
  public int rank;
  @Expose
  @SerializedName("player")
  public PlayerResponse playerResponse;

}
