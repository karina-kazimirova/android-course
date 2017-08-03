package com.example.lessonthree;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.BuildConfig;
import com.example.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by Sve on 30.07.2017.
 */

public class DZ3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz3);

        final ImageView imageView = (ImageView) findViewById(R.id.img);
        final EditText editText = (EditText) findViewById(R.id.link);
        final String LINK_IMG = editText.getText().toString();

        TextView build_config_string = (TextView) findViewById(R.id.build_config_string);
        build_config_string.setText(BuildConfig.API_ENDPOINT);


        Button button_img = (Button) findViewById(R.id.button_img);
        button_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Picasso.with(DZ3Activity.this)
                        .load(LINK_IMG)
                        .error(R.string.img_err)
                        .placeholder(R.drawable.load)
                        .transform(new CircularTransformation(550))
                        .into(imageView);
            }

        });
    }

    public class CircularTransformation implements Transformation {

        private int mRadius = 10;

        public CircularTransformation(final int radius) {
            this.mRadius = radius;
        }

        @Override
        public Bitmap transform(Bitmap source) {
            Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, source.getWidth(), source.getHeight());

            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);

            canvas.drawARGB(0, 0, 0, 0);

            paint.setColor(Color.parseColor("#BAB399"));

            if (mRadius == 0) {
                canvas.drawCircle(source.getWidth() / 2 + 0.7f, source.getHeight() / 2 + 0.7f,
                        source.getWidth() / 2 - 1.1f, paint);
            } else {
                canvas.drawCircle(source.getWidth() / 2 + 0.7f, source.getHeight() / 2 + 0.7f,
                        mRadius, paint);
            }

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(source, rect, rect, paint);

            if (source != output) {
                source.recycle();
            }
            return output;
        }

        @Override
        public String key() {
            return "circular" + String.valueOf(mRadius);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
    }
}
