package com.example.dagger2chucknorris.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeApi {
    @GET("jokes/random")
    Call<JokePojo> getJoke();

}
