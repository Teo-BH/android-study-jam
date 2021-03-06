package br.com.teobaldo.ticktockclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HourCountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_count);

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
            R.drawable.clock_hour_00,
            R.drawable.clock_hour_01,
            R.drawable.clock_hour_02,
            R.drawable.clock_hour_03,
            R.drawable.clock_hour_04,
            R.drawable.clock_hour_05,
            R.drawable.clock_hour_06,
            R.drawable.clock_hour_07,
            R.drawable.clock_hour_08,
            R.drawable.clock_hour_09,
            R.drawable.clock_hour_10,
            R.drawable.clock_hour_11
    };

    int []textArray = {
            R.string.hour_twelve,
            R.string.hour_one,
            R.string.hour_two,
            R.string.hour_three,
            R.string.hour_four,
            R.string.hour_five,
            R.string.hour_six,
            R.string.hour_seven,
            R.string.hour_eight,
            R.string.hour_nine,
            R.string.hour_ten,
            R.string.hour_eleven
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
