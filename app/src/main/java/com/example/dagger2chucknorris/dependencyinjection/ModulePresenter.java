package com.example.dagger2chucknorris.dependencyinjection;

import com.example.dagger2chucknorris.presenter.Presenter;
import com.example.dagger2chucknorris.presenter.PresenterContract;

import dagger.Module;
import dagger.Provides;

//todo Dagger Step 3
@Module
public class ModulePresenter {

    @Provides
    PresenterContract getPresenter(Presenter presenter){
        return presenter;
    }
}
