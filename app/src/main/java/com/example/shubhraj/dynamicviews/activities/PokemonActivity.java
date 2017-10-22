package com.example.shubhraj.dynamicviews.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.shubhraj.dynamicviews.R;
import com.example.shubhraj.dynamicviews.adapters.RecyclerViewAdapter;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<String> pokemonList = new ArrayList<>();
    private Button loadButton;
    private ProgressBar progressBar;

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
        loadButton = (Button) findViewById(R.id.load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePokemonList();
                new PokemonAsyncTask().execute();
            }
        });
    }

    private void generatePokemonList() {
        pokemonList.add("Pikachu");
        pokemonList.add("Bulbasaur");
        pokemonList.add("Charizard");
        pokemonList.add("Squirtle");
        pokemonList.add("Watertortle");
        pokemonList.add("Charmandar");
        pokemonList.add("Onyx");
        pokemonList.add("Magikarp");
        pokemonList.add("Meowth");
    }

    private class PokemonAsyncTask extends AsyncTask<Void, Integer, ArrayList<String>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            ArrayList<String> newPokemonList = new ArrayList<>();
            for(String str:pokemonList)
            {
                try {
                    Thread.sleep(1000);
                    newPokemonList.add(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return newPokemonList;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            pokemonList.clear();
            pokemonList.addAll(strings);
            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
        }
    }

}
