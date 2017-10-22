package com.example.shubhraj.dynamicviews.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shubhraj.dynamicviews.R;

import java.util.List;

/**
 * Created by Shubhraj on 22-10-2017.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private List<String> pokemons;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pokemonText;
        public ViewHolder(View itemView) {
            super(itemView);
            pokemonText = (TextView) itemView.findViewById(R.id.pokemon_text);
        }
    }

    public RecyclerViewAdapter(List<String> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pokemonText.setText(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
}
