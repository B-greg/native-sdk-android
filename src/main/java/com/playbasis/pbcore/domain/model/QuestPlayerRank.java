package com.playbasis.pbcore.domain.model;

import com.playbasis.pbcore.rest.response.QuestPlayerRankResponse;

import java.util.Date;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class QuestPlayerRank extends PBModel {

  public String status;
  public Date completedDate;
  public int goal;
  public int current;
  public Player player;

  public QuestPlayerRank() {

  }

  public QuestPlayerRank(QuestPlayerRankResponse response) {
    update(response);
  }

  public void update(QuestPlayerRankResponse response) {
    if (response == null) {
      return;
    }

    this.status = response.status;
    this.completedDate = response.completedDate;
    this.goal = response.goal;
    this.current = response.current;

    if (response.playerResponse != null) {
      if (this.player == null) {
        this.player = new Player(response.playerResponse.playerId);
      }

      player.update(response.playerResponse);
    }
  }

  public String getStatus() {
    return status;
  }

  public Date getCompletedDate() {
    return completedDate;
  }

  public int getGoal() {
    return goal;
  }

  public int getCurrent() {
    return current;
  }

  public Player getPlayer() {
    return player;
  }
}
