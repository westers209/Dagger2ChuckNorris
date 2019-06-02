package com.example.dagger2chucknorris.model;

import com.example.dagger2chucknorris.presenter.Presenter;
import com.example.dagger2chucknorris.presenter.PresenterContract;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnection {
    PresenterContract presenterContract;
    Retrofit retrofit;

    @Inject
    public NetworkConnection(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    private Callback<JokePojo> callEnqueue = new Callback<JokePojo>() {
        @Override
        public void onResponse(Call<JokePojo> call, Response<JokePojo> response) {
            presenterContract.sendJoke(response.body().value.joke);
        }

        @Override
        public void onFailure(Call<JokePojo> call, Throwable t) {
            presenterContract.onError(t.getMessage());
        }
    };

    public void initNetworkCall(){
        retrofit.create(JokeApi.class)
                .getJoke()
                .enqueue(callEnqueue);
    }

    public void initPresenterContract(PresenterContract presenterContract){
        this.presenterContract = presenterContract;
    }
}
