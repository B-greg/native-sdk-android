package com.playbasis.pbcore.rest.form.player;

import com.playbasis.pbcore.rest.form.PBForm;
import com.playbasis.pbcore.rest.form.ParamsMap;

/**
 * Created by Tar on 6/9/16 AD.
 */
public class ReferralCodeForm extends PBForm {

  protected String playerId;

  public ReferralCodeForm(String playerId) {
    this.playerId = playerId;
  }

  @Override
  public ParamsMap getFields() {
    ParamsMap map = super.getFields();

    return map;
  }

  public String getPlayerId() {
    return playerId;
  }
}
