package com.playbasis.pbcore.domain.interactor;

import com.playbasis.pbcore.domain.model.Goods;
import com.playbasis.pbcore.rest.RestClient;
import com.playbasis.pbcore.rest.form.GetGoodsInfoForm;
import com.playbasis.pbcore.rest.result.GoodsInfoApiResult;
import com.playbasis.pbcore.rest.result.function.PBApiErrorCheckFunc;
import com.smartsoftasia.ssalibrary.domain.executor.PostExecutionThread;
import com.smartsoftasia.ssalibrary.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by androiddev01 on 4/28/2016 AD.
 */
public class GetGoodsInfoInteractor extends PlayBasisApiInteractor {

  public static final String TAG = "GetIdeasInteractor";

  private GetGoodsInfoForm getGoodsInfoForm;

  @Inject
  public GetGoodsInfoInteractor(ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread,
                                RestClient restClient,
                                RequestTokenInteractor requestTokenInteractor) {
    super(threadExecutor, postExecutionThread, restClient, requestTokenInteractor);

  }

  @Override
  public Observable buildApiUseCaseObservable() {
    return restClient.getGoodsService()
        .getGoodsDetail(
            getGoodsInfoForm.getGoodsId(),
            restClient.getApiKey(),
            getGoodsInfoForm.getPlayerId()
        )
        .map(new PBApiErrorCheckFunc<GoodsInfoApiResult>())
        .map(new Func1<GoodsInfoApiResult, Goods>() {
          @Override
          public Goods call(GoodsInfoApiResult goodsInfoApiResult) {
            Goods goods = new Goods();
            goods.update(goodsInfoApiResult.getGoodsResponse());
            return goods;
          }
        });
  }

  public void setGetGoodsInfoForm(GetGoodsInfoForm getGoodsInfoForm) {
    this.getGoodsInfoForm = getGoodsInfoForm;
  }
}