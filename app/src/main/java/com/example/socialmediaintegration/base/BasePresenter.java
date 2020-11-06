package com.example.socialmediaintegration.base;

/**
 * Interface extended by all presenters, containing common functions to be inherited by presenters
 */
public interface BasePresenter<V extends BaseView> {

    /**
     * Function to attach interface extending BaseView to the presenter
     *
     * @param view interface extending BaseView
     */
    void onAttach(V view);

    /**
     * Function to ensure that the disposible and other resources are freed.
     */
    void destroy();
}
