package com.example.dagger2chucknorris.dependencyinjection;

import android.app.Application;

import dagger.internal.DaggerCollections;

//todo Dagger Step 2: making this class
public class CustomApp extends Application {

    //todo Dagger Step 5: implementing this class
    public JokeComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerJokeComponent.builder()
                .build();
    }

    public JokeComponent getComponent() {
        return component;
    }
}
