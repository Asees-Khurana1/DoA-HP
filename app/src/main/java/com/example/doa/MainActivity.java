package com.example.doa;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Scheme> schemeList = new ArrayList<>();
    private List<Scheme> filteredList = new ArrayList<>();
    private SchemeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the app to follow the system's light/dark mode settings
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.schemes_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate scheme list with data
        populateSchemeList();

        // Initialize and set the adapter
        adapter = new SchemeAdapter(this, filteredList);
        recyclerView.setAdapter(adapter);

        // Set up search functionality
        EditText searchInput = findViewById(R.id.search_input);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterSchemes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    // Populate the scheme list with sample data
    private void populateSchemeList() {
        schemeList.add(new Scheme(
                "Scheme 1",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies."
        ));
        schemeList.add(new Scheme(
                "Scheme 2",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/dQw4w9WgXcQ",
                "This scheme offers healthcare services to rural communities."
        ));
        schemeList.add(new Scheme(
                "Scheme 3",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/3JZ_D3ELwOQ",
                "This scheme focuses on improving education quality."
        ));
        schemeList.add(new Scheme(
                "Scheme 4",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/tgbNymZ7vqY",
                "This scheme creates employment opportunities."
        ));
        schemeList.add(new Scheme(
                "Scheme 5",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/VYOjWnS4cMY",
                "This scheme promotes horticulture development."
        ));
        schemeList.add(new Scheme(
                "Scheme 6",
                R.drawable.logo,
                R.drawable.logo,
                "https://www.youtube.com/embed/e-ORhEE9VVg",
                "This scheme supports social welfare programs."
        ));

        // Initially display all schemes
        filteredList.addAll(schemeList);
    }

    // Filter schemes based on search query
    private void filterSchemes(String query) {
        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(schemeList);
        } else {
            for (Scheme scheme : schemeList) {
                if (scheme.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(scheme);
                }
            }
        }

        // Notify adapter of data changes
        adapter.notifyDataSetChanged();
    }
}
