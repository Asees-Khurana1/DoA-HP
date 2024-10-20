package com.example.doa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
    private String selectedCategory = "Financial"; // Default category
    private String searchQuery = ""; // Store the search input

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the app theme to follow the system settings
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.schemes_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate scheme list with sample data
        populateSchemeList();

        // Set up the adapter for RecyclerView
        adapter = new SchemeAdapter(this, filteredList);
        recyclerView.setAdapter(adapter);

        // Initialize Spinner for category selection
        Spinner categorySpinner = findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.scheme_categories, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(spinnerAdapter);


        // Set default category to "Financial"
        categorySpinner.setSelection(0);

        // Handle category selection events
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = parent.getItemAtPosition(position).toString();
                filterSchemes(); // Filter schemes based on category and search query
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Default to Financial if nothing is selected
                selectedCategory = "Financial";
                filterSchemes();
            }
        });

        // Set up search input listener
        EditText searchInput = findViewById(R.id.search_input);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchQuery = s.toString();
                filterSchemes(); // Filter schemes based on search query and category
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Filter schemes initially for the default category
        filterSchemes();
    }

    private void populateSchemeList() {
        schemeList.add(new Scheme("Scheme 1", R.drawable.logo,
                "https://youtu.be/5D1bTu-eA90",
                "This scheme supports farmers.",
                "Eligibility: Must be a farmer.",
                "How to Apply: Visit the nearest office.",
                "Financial"));

        schemeList.add(new Scheme("Scheme 2", R.drawable.logo,
                "https://youtu.be/5D1bTu-eA90",
                "This scheme supports farmers.",
                "Eligibility: Must be a farmer.",
                "How to Apply: Visit the nearest office.",
                "Financial"));

        schemeList.add(new Scheme("Scheme 3", R.drawable.logo,
                "https://youtu.be/5D1bTu-eA90",
                "This scheme supports farmers.",
                "Eligibility: Must be a farmer.",
                "How to Apply: Visit the nearest office.",
                "Educational"));

        schemeList.add(new Scheme("Scheme 4", R.drawable.logo,
                "https://youtu.be/5D1bTu-eA90",
                "This scheme supports farmers.",
                "Eligibility: Must be a farmer.",
                "How to Apply: Visit the nearest office.",
                "Educational"));

        schemeList.add(new Scheme("Scheme 5", R.drawable.logo,
                "https://youtu.be/5D1bTu-eA90",
                "This scheme supports farmers.",
                "Eligibility: Must be a farmer.",
                "How to Apply: Visit the nearest office.",
                "Financial"));

        schemeList.add(new Scheme("Scheme 6", R.drawable.logo,
                "https://youtu.be/dQw4w9WgXcQ",
                "Healthcare services for rural areas.",
                "Eligibility: Must reside in rural areas.",
                "How to Apply: Register online.",
                "Educational"));

        // Add more schemes here if needed
    }

    @SuppressLint("NotifyDataSetChanged")
    private void filterSchemes() {
        // Clear the filtered list before adding new items
        filteredList.clear();

        // Filter schemes based on the selected category and search query
        for (Scheme scheme : schemeList) {
            boolean matchesCategory = scheme.getCategory().equalsIgnoreCase(selectedCategory);
            boolean matchesQuery = scheme.getName().toLowerCase().contains(searchQuery.toLowerCase());

            if (matchesCategory && matchesQuery) {
                filteredList.add(scheme);
            }
        }

        // Notify the adapter of the changes
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
