package com.example.doa;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner categorySpinner = findViewById(R.id.category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.agriculture_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        EditText searchInput = findViewById(R.id.search_input);
        ImageView searchIcon = findViewById(R.id.search_icon);

        searchIcon.setOnClickListener(v -> {
            String searchText = searchInput.getText().toString();
            if (!searchText.isEmpty()) {
                Toast.makeText(MainActivity.this, "Searching for: " + searchText, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Please enter a search term", Toast.LENGTH_SHORT).show();
            }
        });


        ImageView gifArea = findViewById(R.id.gif_area);
        gifArea.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "GIF clicked!", Toast.LENGTH_SHORT).show()
        );
    }
}
