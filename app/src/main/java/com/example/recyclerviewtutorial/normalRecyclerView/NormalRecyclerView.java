package com.example.recyclerviewtutorial.normalRecyclerView;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtutorial.R;

import java.util.ArrayList;

public class NormalRecyclerView extends AppCompatActivity {

    RecyclerView normalRecyclerView;

    private PlanetAdapter adapter;
    private ArrayList<Planet> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_normal_recycler_view);


        normalRecyclerView = findViewById(R.id.normal_recyclerview);
        normalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        planets = new ArrayList<>();

        createListData();

        adapter = new PlanetAdapter(this, planets);

        normalRecyclerView.setAdapter(adapter);
        normalRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void createListData() {

        Planet planet = new Planet("Earth", 150, 10, 12750);
        planets.add(planet);
    }
}