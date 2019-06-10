package com.example.zkdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.logging.Logger;

public class NewsContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");

        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(title, content);
    }

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", title);
        intent.putExtra("news_content", content);
        Log.d("NewsContentActivity", "actionStart: "+content);
        context.startActivity(intent);
    }
}
