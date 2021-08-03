package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.data.Bio2;
import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Bio2 bio = new Bio2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName2("Mary Jones");

        binding.setBio(bio);
        binding.button.setOnClickListener(this::showhobbies);
    }

    public void showhobbies(View view) {

        bio.setHobbies2(String.format("Hobbies : %s", binding.EtHobby
                .getText().toString().trim()));
        //drop all binding
        binding.invalidateAll();
        binding.showText.setVisibility(View.VISIBLE);

        //hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}