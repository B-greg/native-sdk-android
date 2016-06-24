package com.playbasis.pbcore.rest.form.content;

import com.playbasis.pbcore.domain.model.Content;
import com.playbasis.pbcore.domain.model.Player;
import com.playbasis.pbcore.rest.form.CustomFieldForm;

/**
 * Created by Tar on 4/21/16 AD.
 */
public abstract class ContentOpinionForm extends CustomFieldForm {

  protected Content content;
  protected Player player;

  public ContentOpinionForm(Content content, Player player) {
    this.content = content;
    this.player = player;
  }

  public String getNodeId() {
    return content.getId();
  }

  public String getPlayerId() {
    return player.getPlayerId();
  }
}