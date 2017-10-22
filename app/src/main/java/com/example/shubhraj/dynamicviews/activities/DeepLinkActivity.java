package com.example.shubhraj.dynamicviews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shubhraj.dynamicviews.R;
import com.example.shubhraj.dynamicviews.views.NewButton;

public class DeepLinkActivity extends AppCompatActivity
{
    private NewButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        mButton = (NewButton) findViewById(R.id.sp_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DeepLinkActivity.this,"Button pressed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
