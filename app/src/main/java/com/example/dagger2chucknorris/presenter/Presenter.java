package com.example.dagger2chucknorris.presenter;

import com.example.dagger2chucknorris.model.NetworkConnection;
import com.example.dagger2chucknorris.view.ViewContract;

import javax.inject.Inject;

public class Presenter implements PresenterContract {

    ViewContract view;
    NetworkConnection networkConnection;

    @Inject
    public Presenter(NetworkConnection networkConnection){
        this.networkConnection = networkConnection;
    }

    @Override
    public void bind(ViewContract viewContract) {
        this.view = viewContract;
        networkConnection.initPresenterContract(this);
    }

    @Override
    public void unbind() {
        view = null;
    }

    @Override
    public void sendJoke(String joke) {
        view.populateJoke(joke);
    }

    @Override
    public void onError(String message) {
        view.populateError(message);
    }

    @Override
    public void getMeAJoke() {
        networkConnection.initNetworkCall();
    }
}
