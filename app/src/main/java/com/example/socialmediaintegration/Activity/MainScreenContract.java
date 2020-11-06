package com.example.socialmediaintegration.Activity;


import androidx.annotation.NonNull;

import com.example.socialmediaintegration.base.BasePresenter;
import com.example.socialmediaintegration.base.BaseView;

import okhttp3.ResponseBody;


public interface MainScreenContract {

    interface View extends BaseView {

        void setData(@NonNull final ResponseBody tabDataList);

        void noTabDataFound();
    }

    interface Presenter extends BasePresenter {
        /**
         * Function to get list of latest tabs.
         */
        void getTabData();
    }
}
