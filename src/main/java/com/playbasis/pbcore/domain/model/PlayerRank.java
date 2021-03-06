package com.playbasis.pbcore.domain.model;

import android.os.Parcel;

import com.playbasis.pbcore.rest.response.PlayerRankResponse;
import com.playbasis.pbcore.rest.response.PlayerResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tar on 6/20/16 AD.
 */
public class PlayerRank extends PBModel {

  protected String sortBy;
  protected int value;
  private Player player;

  public PlayerRank() {

  }

  public PlayerRank(PlayerRankResponse response) {
    update(response);
  }

  public static ArrayList<PlayerRank> createPlayerRanks(List<PlayerRankResponse> responses) {
    ArrayList<PlayerRank> playerRanks = new ArrayList<>();

    if (responses == null || responses.size() == 0) {
      return playerRanks;
    }

    for (PlayerRankResponse playerRankResponse : responses) {
      playerRanks.add(new PlayerRank(playerRankResponse));
    }

    return playerRanks;
  }

  public void update(PlayerRankResponse response) {
    this.sortBy = response.sortBy;
    this.value = response.value;
    this.player = createPlayer(response.playerResponse);
  }

  public Player getPlayer() {
    return player;
  }

  public String getSortBy() {
    return sortBy;
  }

  public int getValue() {
    return value;
  }

  protected Player createPlayer(PlayerResponse playerResponse) {
    if (playerResponse != null && playerResponse.playerId != null) {
      return new Player(playerResponse);
    }

    return null;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.sortBy);
    dest.writeInt(this.value);
    dest.writeParcelable(this.player, flags);
  }

  protected PlayerRank(Parcel in) {
    this.sortBy = in.readString();
    this.value = in.readInt();
    this.player = in.readParcelable(Player.class.getClassLoader());
  }

  public static final Creator<PlayerRank> CREATOR = new Creator<PlayerRank>() {
    @Override
    public PlayerRank createFromParcel(Parcel source) {
      return new PlayerRank(source);
    }

    @Override
    public PlayerRank[] newArray(int size) {
      return new PlayerRank[size];
    }
  };
}
