package br.com.teobaldo.ticktockclock;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void HourCountShow(View view) {
        Intent intent = new Intent(MainActivity.this, HourCountActivity.class);
        MainActivity.this.startActivity(intent);
    }

    /*
    public void ButtonClick(View view) {
        ImageView img = (ImageView)findViewById(R.id.road_background);
        Log.v("MainActivity", "Height " + img.getHeight() + " Width " + img.getWidth());

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.v("MainActivity", "Height " + metrics.heightPixels + " Width " + metrics.widthPixels);
    }
    */
}
