package com.rocky.uniconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private TextView textView4;
    private EditText editText;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        button = findViewById (R.id.button);
        textView = findViewById (R.id.textView3);
        editText = findViewById (R.id.editText2);
        button.setOnClickListener (new View.OnClickListener () {
            @SuppressLint ("SetTextI18n")
            @Override
            public void onClick (View view) {
                try {
                    String s = editText.getText ().toString ();
                    int kg = Integer.parseInt (s);
                    double pound = 2.205 * kg;
                    textView.setText ("The Value In Pound Is : "+ pound);
                } catch (Exception e) {
                    Toast.makeText (MainActivity.this, "Please Enter A Value", Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }
}