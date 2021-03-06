package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.CustomFieldForm;

import java.util.HashMap;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class UpdatePlayerCustomFieldForm extends CustomFieldForm {

  protected String playerId;

  public UpdatePlayerCustomFieldForm(Player player) {
    this.playerId = player.getPlayerId();
    this.customFieldMap = player.getCustomFields();
  }

  public UpdatePlayerCustomFieldForm(String playerId) {
    this.playerId = playerId;
  }

  public UpdatePlayerCustomFieldForm(String playerId, HashMap<String, String> customFields) {
    this.playerId = playerId;
    this.customFieldMap = customFields;
  }

  public String getPlayerId() {
    return playerId;
  }
}
