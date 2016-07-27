package com.playbasis.pbcore.domain.interactor.quest;

import com.playbasis.pbcore.domain.interactor.PlayBasisApiInteractor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.quest.JoinQuestForm;
import com.playbasis.pbcore.rest.result.quest.JoinQuestApiResult;
import com.playbasis.pbcore.rest.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class JoinQuestInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "JoinQuestInteractor";

  protected JoinQuestForm joinQuestForm;

  @Inject
  public JoinQuestInteractor(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             RestClient restClient,
                             RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getQuestService()
        .joinQuest(
            joinQuestForm.getQuestId(),
            getApiToken(),
            joinQuestForm.getPlayerId()
        )
        .map(new PBApiErrorCheckFunc<JoinQuestApiResult>());
  }

  public void setJoinQuestForm(JoinQuestForm joinQuestForm) {
    this.joinQuestForm = joinQuestForm;
  }
}
