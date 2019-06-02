package com.example.dagger2chucknorris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dagger2chucknorris.dependencyinjection.CustomApp;
import com.example.dagger2chucknorris.presenter.PresenterContract;
import com.example.dagger2chucknorris.view.ViewContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ViewContract {

    //todo Dagger Step 1
    @Inject
    PresenterContract presenter;

    @BindView(R.id.tv_jokes) TextView tv_joke;
    @BindView(R.id.btn_new_joke) Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((CustomApp)getApplicationContext()).getComponent().inject(this);


        presenter.bind(this);
        presenter.getMeAJoke();
    }

    @Override
    public void populateJoke(String joke) {
        tv_joke.setText(joke);
    }

    @Override
    public void populateError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_new_joke)
    public void getMeAJoke(){
        presenter.getMeAJoke();
    }
}
