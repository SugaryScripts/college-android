package fryctze.college.learn_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import fryctze.college.learn_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String[] WORDS = {
            "contract", "a binding enforced by law",
            "assurance", "agreement to do or give ..",
            "engage", "consume on one's attention or time"
    };
    private HashMap<String, String> dictionary;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        letsPlay();
    }

    private void letsPlay() {
        ArrayList<String> word = new ArrayList<>();
        dictionary = new HashMap<>();
        for (int i = 0; i < WORDS.length; i+=2) {
            word.add(WORDS[i]);
            dictionary.put(WORDS[i], WORDS[i+1]);
        }

        Collections.shuffle(word);
        String quiz = word.get(0);
        binding.tvQuiz.setText(quiz);

        ArrayList<String> Options = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Options.add(dictionary.get(word.get(i)));
        }

        Collections.shuffle(Options);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Options
        );

        binding.lvOpSys.setAdapter(arrayAdapter);

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