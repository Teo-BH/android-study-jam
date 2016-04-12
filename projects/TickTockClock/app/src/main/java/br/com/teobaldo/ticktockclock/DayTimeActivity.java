package br.com.teobaldo.ticktockclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DayTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_time);
        this.linkViews();
        this.changeClockImage();
    }

    private void linkViews() {
        this.imageView = (ImageView)findViewById(R.id.clock_image_view);
        this.textView = (TextView)findViewById(R.id.description_text_view);
    }

    private ImageView imageView;
    private TextView textView;

    int []imageArray = {
            R.drawable.clock_day_08_00,
            R.drawable.clock_day_09_30,
            R.drawable.clock_day_12_15,
            R.drawable.clock_day_03_45,
            R.drawable.clock_day_06_00
    };

    int []textArray = {
            R.string.day_time_08_00,
            R.string.day_time_09_30,
            R.string.day_time_12_15,
            R.string.day_time_03_45,
            R.string.day_time_06_00
    };


    private void changeClockImage() {
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i=0;
            public void run() {
                imageView.setImageResource(imageArray[i]);
                textView.setText(textArray[i]);
                i++;
                if(i>imageArray.length-1)
                {
                    i=0;
                }
                handler.postDelayed(this, 3000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 5000); //for initial delay..
    }
}