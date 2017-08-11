package com.example.sve.lessonfour;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.sve.myandroid.R;


/**
 * Created by Sve on 02.08.2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class ClockView extends View {

    int h, m, s;

    private Paint paint = new Paint();
    private Paint paint1 = new Paint();
    private Rect mTextBoundRect = new Rect();


    public ClockView(Context context, int h, int m, int s) {
        super(context);

        this.h = h;
        this.m = m;
        this.s = s;

        initialize();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {

        paint.setAntiAlias(true);
        paint1.setAntiAlias(true);
        int color = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        int color1 = ContextCompat.getColor(getContext(), R.color.colorAccent);
        paint.setColor(color);
        paint1.setColor(color1);
        paint.setStrokeWidth(2);

        //Конвертация в dp
        Resources r = getResources();

        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

                2, r.getDisplayMetrics());

        paint.setStrokeWidth(strokeWidthInPx);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int margin = 15;


        int radius = Math.min(width, height) / 4;
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;


        canvas.drawCircle(cx, cy, radius, paint);

        int radius1 = Math.min(getWidth(), getHeight()) / 40;
        canvas.drawCircle(cx, cy, radius1, paint1);

        paint1.setTextSize(60);
        String twelve = "12";
        Float widthTwelve = paint1.measureText(twelve);
        canvas.drawText(twelve,
                cx - (widthTwelve / 2),
                (cy - radius) - margin,
                paint1);

        String three = "3";
        paint1.getTextBounds(three, 0, three.length(), mTextBoundRect);
        float threeHeight = mTextBoundRect.height();
        canvas.drawText(three,
                (cx + radius) + margin,
                cy + threeHeight / 2,
                paint1);

        String six = "6";
        Float widthSix = paint1.measureText(six);
        canvas.drawText(six,
                cx - (widthSix / 2),
                ((cy + radius) + threeHeight / 2) + margin * 2,
                paint1);

        String nine = "9";
        Float widthNine = paint1.measureText(nine);
        canvas.drawText(nine,
                ((cx - radius) - widthNine) - margin,
                cy + threeHeight / 2,
                paint1);


        canvas.save();

        for (int i = 0; i < 12; i++) {
            paint1.setStrokeWidth(5);
            canvas.drawLine(cx, cy - radius, cx, (cy - radius) + 20, paint1);
            canvas.rotate(30, cx, cy);
        }




        canvas.save();
        paint1.setStrokeWidth(8);
        canvas.rotate(30 * h, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - 100, paint1);
        canvas.restore();

        canvas.save();
        paint1.setStrokeWidth(4);
        canvas.rotate(6 * m, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - 130, paint1);
        canvas.restore();

        canvas.save();
        paint1.setStrokeWidth(2);
        canvas.rotate(6 * s, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - 150, paint1);
        canvas.restore();
    }


}
