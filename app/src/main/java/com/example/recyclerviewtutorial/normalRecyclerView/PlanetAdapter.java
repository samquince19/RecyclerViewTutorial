package com.example.recyclerviewtutorial.normalRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtutorial.R;

import java.util.ArrayList;
import java.util.Locale;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    //This class has 2 classes
    //1. PlanetAdapter

    private Context context;
    private ArrayList<Planet> planets;

    public PlanetAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }


    @NonNull
    @Override
    public PlanetAdapter.PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.planet_layout_item,
                        parent, false);

        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetHolder holder, int position) {
        Planet planet = planets.get(position);
        holder.setDetails(planet);

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    //Planet Holder class

    class PlanetHolder extends RecyclerView.ViewHolder {

        private TextView textName, textDistance, textGravity, textDiameter;

        public PlanetHolder(@NonNull View parent) {
            super(parent);
            textName = parent.findViewById(R.id.nameTextView);
            textDistance = parent.findViewById(R.id.distanceTextView);
            textGravity = parent.findViewById(R.id.gravityTextView);
            textDiameter = parent.findViewById(R.id.diameterTextView);

        }

        void setDetails(Planet planet) {
            textName.setText(planet.getName());
            textDistance.setText(String.format(Locale.US, "Distance from sun: %d Million KM", planet.getDistanceFromSun()));
            textGravity.setText(String.format(Locale.US, "Surface gravity : %d N/Kg", planet.getGravity()));
            textDiameter.setText(String.format(Locale.US, "Diameter : %d KM", planet.getDiameter()));
        }
    }

}
