package com.example.thesm.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class Twitter2 extends AppCompatActivity {

    private TextView welcomeText,Tusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter2);

        String username = getIntent().getStringExtra("username");

        welcomeText =(TextView)findViewById(R.id.welcome);
        Tusername = (TextView)findViewById(R.id.username);

        Tusername.setText(username);

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("going to class");

        builder.show();
    }
}
