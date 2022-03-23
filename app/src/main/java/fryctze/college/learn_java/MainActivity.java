package fryctze.college.learn_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import fryctze.college.learn_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadList();
    }

    /**
     * attribute entries in main activity layout, got replaced in here
     * and update automatically when list on change
     */
    private void loadList() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Kubuntu");
        items.add("Ubuntu"); // removed
        items.add("Kali");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        binding.lvOpSys.setAdapter(adapter);

        // updated/added new item automatically without re-definition adapter
        items.add("Tiny core");
        items.remove("Ubuntu");
    }
}