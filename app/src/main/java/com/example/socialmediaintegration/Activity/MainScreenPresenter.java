package com.example.socialmediaintegration.Activity;

import android.text.TextUtils;


import androidx.annotation.NonNull;

import com.example.socialmediaintegration.base.BaseView;
import com.example.socialmediaintegration.retrofit.ApiInterface;


import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;


public class MainScreenPresenter implements MainScreenContract.Presenter {

    private ApiInterface apiInterface;
    private MainScreenContract.View view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    MainScreenPresenter(@NonNull ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @Override
    public void getTabData() {
        //view.showProgress(true);
        apiInterface.getWeatherReport()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(ResponseBody tabDataResponses) {

                        view.setData(tabDataResponses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        final String errorMessage = e.getMessage();
                        if (!TextUtils.isEmpty(errorMessage)) {
                            view.showError(errorMessage);
                        } else {
                            view.showError("Error");
                        }
                        view.showProgress(false);
                    }
                });
    }


    @Override
    public void onAttach(BaseView view) {
        this.view = (MainScreenContract.View) view;
    }

    @Override
    public void destroy() {
        compositeDisposable.dispose();
        view = null;
    }
}
