package com.example.shubhraj.dynamicviews.activities;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.shubhraj.dynamicviews.R;
import com.example.shubhraj.dynamicviews.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Random;

public class PokemonHandlerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<String> pokemonList = new ArrayList<>();
    private Button loadButton;
    private ProgressBar progressBar;
    private HandlerThread handlerThread;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(pokemonList);
        recyclerView.setAdapter(adapter);

        handlerThread = new HandlerThread("PokemonHandler");
        handlerThread.start();

        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                String message = bundle.getString("message");
                pokemonList.add(message);
                adapter.notifyDataSetChanged();
                Log.d("message", "Pokemon added:" + message);
            }
        };

        loadButton = (Button) findViewById(R.id.load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNewMessage();
            }
        });
    }

    private void sendNewMessage() {
        Message message = handler.obtainMessage();
        ArrayList<String> pokemonListnew = new ArrayList<>();
        pokemonListnew.add("Pikachu");
        pokemonListnew.add("Bulbasaur");
        pokemonListnew.add("Charizard");
        pokemonListnew.add("Squirtle");
        pokemonListnew.add("Watertortle");
        pokemonListnew.add("Charmandar");
        pokemonListnew.add("Onyx");
        pokemonListnew.add("Magikarp");
        pokemonListnew.add("Meowth");

        int index = new Random().nextInt(pokemonListnew.size());
        String pokemon = pokemonListnew.get(index);
        Bundle bundle = new Bundle();
        bundle.putString("message",pokemon);

        message.setData(bundle);
        handler.sendMessage(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handlerThread.quit();
    }
}