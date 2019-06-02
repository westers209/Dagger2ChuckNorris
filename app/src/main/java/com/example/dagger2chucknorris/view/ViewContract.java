package com.example.dagger2chucknorris.view;

public interface ViewContract {
    void populateJoke(String joke);
    void populateError(String message);
}
