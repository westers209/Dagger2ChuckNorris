package com.example.dagger2chucknorris.presenter;

import com.example.dagger2chucknorris.view.ViewContract;

public interface PresenterContract {
    void bind(ViewContract viewContract);
    void unbind();
    void sendJoke(String joke);
    void onError(String message);
    void getMeAJoke();
}
