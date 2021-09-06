package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Context;
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
//    private EditText enterHobbies;
//    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        enterHobbies = findViewById(R.id.hobby_et);
//        hobbies = findViewById(R.id.show_hobbies);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setBio(bio);

        bio.setName2("Mary Jones");

        binding.button.setOnClickListener(this::showHobbies);
    }

//    public void addHobbies{
//        hobbies.setText(String.format("Hobbies : %s" +
//                enterHobbies.getText()
//                        .toString()
//                        .trim()));
//        hobbies.setVisibility(View.VISIBLE);
//
//      hide keyboard
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        assert inputMethodManager != null;
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
//    }


    public void showHobbies(View view) {

//        binding.showHobbies.setText(String.format("Hobbies : %s",
//                binding.hobbyEt.getText()
//                        .toString()
//                        .trim()));

        bio.setHobbies2(String.format("Hobbies : %s",
                binding.hobbyEt.getText()
                        .toString()
                        .trim()));

        //drop all binding
        //bỏ tất cả binding
        binding.invalidateAll();
        binding.showHobbies.setVisibility(View.VISIBLE);

        //hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}