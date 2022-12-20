package com.rocky.uniconvertor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView4;
    private EditText editText;
    private  Button button;
    private  Button button2;


    @Override
    public void onBackPressed () {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setMessage ("Are You Sure?").setCancelable (false).setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
            @Override
            public void onClick (DialogInterface dialog, int i) {
                MainActivity.super.onBackPressed ();
                MainActivity.this.finish ();
                System.exit (0);
            }
        })
                .setNegativeButton ("No", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick (DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create ();
        alertDialog.show ();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        Button button = findViewById (R.id.button);
        textView = findViewById (R.id.textView3);
        editText = findViewById (R.id.editText2);
        @SuppressLint ({"MissingInflatedId", "LocalSuppress"}) Button button2 = findViewById (R.id.button2);
        button.setOnClickListener (new View.OnClickListener () {
            @SuppressLint ("SetTextI18n")
            @Override
            public void onClick (View view) {
                try {
                    String s = editText.getText ().toString ();
                    int kg = Integer.parseInt (s);
                    double pound = 2.205 * kg;
                    double result = Math.round (pound*100)/100.0;
                    textView.setText ("The Value In Pound Is : " + result);
                } catch (Exception e) {
                    Toast.makeText (MainActivity.this, "Please Enter A Value", Toast.LENGTH_SHORT).show ();
                }
                button2.setOnClickListener (v -> {
                    editText.setText ("");
                    textView.setText ("");
                });
            }
        });

    }
}