package com.example.dagger2chucknorris.dependencyinjection;


import com.example.dagger2chucknorris.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

//todo Dagger Step 4
@Singleton
@Component(
        modules = {
                ModuleNetworkConnection.class,
                ModulePresenter.class
        }
)
public interface JokeComponent {
    void inject(MainActivity activity);
}
