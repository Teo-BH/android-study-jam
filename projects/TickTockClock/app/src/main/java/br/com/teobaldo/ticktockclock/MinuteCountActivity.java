package br.com.teobaldo.ticktockclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MinuteCountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minute_count);
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
            R.drawable.clock_minute_00,
            R.drawable.clock_minute_05,
            R.drawable.clock_minute_10,
            R.drawable.clock_minute_15,
            R.drawable.clock_minute_20,
            R.drawable.clock_minute_25,
            R.drawable.clock_minute_30,
            R.drawable.clock_minute_35,
            R.drawable.clock_minute_40,
            R.drawable.clock_minute_45,
            R.drawable.clock_minute_50,
            R.drawable.clock_minute_55
    };

    int []textArray = {
            R.string.minute_zero,
            R.string.minute_five,
            R.string.minute_ten,
            R.string.minute_fifteen,
            R.string.minute_twenty,
            R.string.minute_twenty_five,
            R.string.minute_thirty,
            R.string.minute_thirty_five,
            R.string.minute_fourty,
            R.string.minute_fourty_five,
            R.string.minute_fifty,
            R.string.minute_fifty_five
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
