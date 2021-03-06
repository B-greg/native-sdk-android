package com.playbasis.pbcore.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tar on 5/5/16 AD.
 */
public class BaseMissionResponse {

  // TODO, merge this class with MissionResposne
  @Expose
  @SerializedName("mission_id")
  public String missionId;
  @Expose
  @SerializedName("quest_id")
  public String questId;
  @Expose
  @SerializedName("mission_name")
  public String name;
  @Expose
  @SerializedName("mission_number")
  public String number;
  @Expose
  @SerializedName("description")
  public String description;
  @Expose
  @SerializedName("hint")
  public String hint;
  @Expose
  @SerializedName("image")
  public String imageUrl;
  @Expose
  @SerializedName("completion")
  public List<CompletionResponse> completionResponse;

  public class CompletionResponse {
    @Expose
    @SerializedName("completion_element_id")
    public String elementId;
    @Expose
    @SerializedName("completion_op")
    public String op;
    @Expose
    @SerializedName("completion_filter")
    public String filter;
    @Expose
    @SerializedName("completion_value")
    public String value;
    @Expose
    @SerializedName("completion_id")
    public String completionId;
    @Expose
    @SerializedName("completion_type")
    public String type;
    @Expose
    @SerializedName("completion_title")
    public String title;
    @Expose
    @SerializedName("filtered_param")
    public FilteredParamResponse filteredParamResponse;
    @Expose
    @SerializedName("completion_data")
    public CompletionDataResponse completionDataResponse;

    public class FilteredParamResponse {
      @Expose
      @SerializedName("quantity")
      public QuantityResponse quantityResponse;

      public class QuantityResponse {
        @Expose
        @SerializedName("operation")
        public String operation;
        @Expose
        @SerializedName("completion_string")
        public String completionString;
      }
    }

    public class CompletionDataResponse {
      @Expose
      @SerializedName("action_id")
      public String actionId;
      @Expose
      @SerializedName("name")
      public String name;
      @Expose
      @SerializedName("description")
      public String description;
      @Expose
      @SerializedName("icon")
      public String icon;
      @Expose
      @SerializedName("color")
      public String color;
    }
  }

}
