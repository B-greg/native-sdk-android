package com.playbasis.pbcore.domain.interactor.player;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.player.PlayerEmailVerificationForm;
import com.playbasis.pbcore.rest.result.player.VerifyPlayerEmailApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tar on 4/21/16 AD.
 */
public class VerifyPlayerEmailInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "VerifyPlayerEmailInteractor";

  public PlayerEmailVerificationForm playerEmailVerificationForm;

  @Inject
  public VerifyPlayerEmailInteractor(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread,
                                     RestClient restClient,
                                     RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getPlayerService()
        .sendPlayerVerifyEmail(playerEmailVerificationForm.getPlayerId(), getApiToken())
        .map(new PBApiErrorCheckFunc<VerifyPlayerEmailApiResult>());
  }

  public void setPlayerEmailVerificationForm(PlayerEmailVerificationForm playerEmailVerificationForm) {
    this.playerEmailVerificationForm = playerEmailVerificationForm;
  }
}