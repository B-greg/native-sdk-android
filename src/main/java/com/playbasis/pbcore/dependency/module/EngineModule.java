package com.playbasis.pbcore.dependency.module;

import com.playbasis.pbcore.dependency.component.PerActivity;
import com.playbasis.pbcore.domain.executor.PBPostExecutionThread;
import com.playbasis.pbcore.domain.executor.PBThreadExecutor;
import com.playbasis.pbcore.domain.interactor.RequestTokenInteractor;
import com.playbasis.pbcore.domain.interactor.engine.RuleInteractor;
import com.playbasis.pbcore.rest.RestClient;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tar on 4/21/16 AD.
 */
@Module
public class EngineModule {

  @Provides
  @PerActivity
  RuleInteractor provideRuleInteractor(PBThreadExecutor threadExecutor,
                                       PBPostExecutionThread postExecutionThread,
                                       RestClient restClient,
                                       RequestTokenInteractor requestTokenInteractor) {
    return new RuleInteractor(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);
  }

}
