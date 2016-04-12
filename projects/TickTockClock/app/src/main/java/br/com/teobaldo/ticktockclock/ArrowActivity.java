package br.com.teobaldo.ticktockclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow);
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
            R.drawable.clock_arrow_hour,
            R.drawable.clock_arrow_minute,
            R.drawable.clock_arrow_full
    };

    int []textArray = {
            R.string.arrow_hour,
            R.string.arrow_minute,
            R.string.arrow_full
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
