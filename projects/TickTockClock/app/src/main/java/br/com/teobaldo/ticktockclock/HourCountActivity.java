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
            R.drawable.clock_00,
            R.drawable.clock_01,
            R.drawable.clock_02,
            R.drawable.clock_03,
            R.drawable.clock_04,
            R.drawable.clock_05,
            R.drawable.clock_06,
            R.drawable.clock_07,
            R.drawable.clock_08,
            R.drawable.clock_09,
            R.drawable.clock_10,
            R.drawable.clock_11
    };

    int []textArray = {
            R.string.twelve,
            R.string.one,
            R.string.two,
            R.string.three,
            R.string.four,
            R.string.five,
            R.string.six,
            R.string.seven,
            R.string.eight,
            R.string.nine,
            R.string.ten,
            R.string.eleven
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
