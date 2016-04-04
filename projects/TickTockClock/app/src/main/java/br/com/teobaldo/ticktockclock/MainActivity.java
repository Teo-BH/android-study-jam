package br.com.teobaldo.ticktockclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonClick(View view) {
        ImageView img = (ImageView)findViewById(R.id.road_background);
        Log.v("MainActivity", "Height " + img.getHeight());
        Log.v("MainActivity", "Width " + img.getWidth());
    }
}
