package com.example.dagger2chucknorris.dependencyinjection;

import com.example.dagger2chucknorris.model.NetworkConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ModuleNetworkConnection {

    //todo Dagger Step 4
    @Singleton
    @Provides
    NetworkConnection getNetworkConnection(Retrofit retrofit){
        return new NetworkConnection(retrofit);
    }

    @Singleton
    @Provides
    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://api.icndb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
