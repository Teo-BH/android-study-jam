package com.example.android.easteregg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText editText = (EditText)this.findViewById(R.id.textView);
        int value = Integer.parseInt(editText.getText().toString());
        int total = value * 2;

        ImageView easterImageView = (ImageView)this.findViewById(R.id.easter_egg_image_view);
        easterImageView.setVisibility(View.VISIBLE);


        TextView resultTextView = (TextView)this.findViewById(R.id.result_text_view);
        resultTextView.setText("Com " + value + " kilos de chocolate podemos fazer " + total + " ovos de chocolate");
        resultTextView.setVisibility(View.VISIBLE);
    }
}
