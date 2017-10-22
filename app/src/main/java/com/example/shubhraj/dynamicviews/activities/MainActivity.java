package com.example.shubhraj.dynamicviews.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shubhraj.dynamicviews.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int addTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTextView=0;
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        final Button button = (Button) findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground(linearLayout);
                addNewTextView(linearLayout);
            }
        });
    }

    private void addNewTextView(LinearLayout linearLayout) {
        TextView textView = new TextView(this);
        textView.setText("Text View:" + addTextView++);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        linearLayout.addView(textView);
    }

    private void changeBackground(LinearLayout linearLayout) {
        Random random = new Random();
        int color = Color.argb(256,random.nextInt(),random.nextInt(),random.nextInt());
        linearLayout.setBackgroundColor(color);
    }
}
