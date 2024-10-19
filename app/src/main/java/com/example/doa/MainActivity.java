package com.example.doa;

import android.annotation.SuppressLint;
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

    private final List<Scheme> schemeList = new ArrayList<>();
    private final List<Scheme> filteredList = new ArrayList<>();
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

    private void populateSchemeList() {
        schemeList.add(new Scheme(
                "Scheme 1",
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies." +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies." +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies. " +
                        "This scheme supports farmers by providing subsidies.",
                "Eligibility:\n1. Must be a farmer.\n2. Minimum age: 18 years.",
                "How to Apply:\n1. Visit the nearest office.\n2. Fill the application form."
        ));
        schemeList.add(new Scheme(
                "Scheme 2",
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies.",
                "Eligibility:\n1. Must be a farmer.\n2. Minimum age: 18 years.",
                "How to Apply:\n1. Visit the nearest office.\n2. Fill the application form."
        ));
        schemeList.add(new Scheme(
                "Scheme 3",
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies.",
                "Eligibility:\n1. Must be a farmer.\n2. Minimum age: 18 years.",
                "How to Apply:\n1. Visit the nearest office.\n2. Fill the application form."
        ));
        schemeList.add(new Scheme(
                "Scheme 4",
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies.",
                "Eligibility:\n1. Must be a farmer.\n2. Minimum age: 18 years.",
                "How to Apply:\n1. Visit the nearest office.\n2. Fill the application form."
        ));
        schemeList.add(new Scheme(
                "Scheme 5",
                R.drawable.logo,
                "https://www.youtube.com/embed/5D1bTu-eA90",
                "This scheme supports farmers by providing subsidies.",
                "Eligibility:\n1. Must be a farmer.\n2. Minimum age: 18 years.",
                "How to Apply:\n1. Visit the nearest office.\n2. Fill the application form."
        ));
        schemeList.add(new Scheme(
                "Scheme 6",
                R.drawable.logo,
                "https://www.youtube.com/embed/dQw4w9WgXcQ",
                "This scheme offers healthcare services to rural communities.",
                "Eligibility:\n1. Must reside in rural areas.\n2. Registered in healthcare program.",
                "How to Apply:\n1. Register online.\n2. Visit the community healthcare center."
        ));

        // Display all schemes initially
        filteredList.addAll(schemeList);
    }

    @SuppressLint("NotifyDataSetChanged")
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
        adapter.notifyDataSetChanged();
    }

    public void openSchemeDetail(Scheme scheme) {
        Intent intent = new Intent(MainActivity.this, SchemeDetailActivity.class);
        intent.putExtra("scheme_name", scheme.getName());
        intent.putExtra("scheme_video", scheme.getVideoUrl());
        intent.putExtra("scheme_content", scheme.getDescription());
        intent.putExtra("eligibility_content", scheme.getEligibilityContent());
        intent.putExtra("how_to_apply_content", scheme.getHowToApplyContent());
        startActivity(intent);
    }
}