package com.example.classwork4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.R;

/**
 * Created by Sve on 31.07.2017.
 */

public class MyView extends View {

    // объект для риосвания
    private Paint myPaint = new Paint();

    //Ограниченная область
    private RectF arcRectF = new RectF();

    public MyView(Context context) {
        super(context);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {

        // Задаем параметры рисования

        //Сглаживание
        myPaint.setAntiAlias(true);
       // arcRectF.setAntiAlias(true);

        //Установка цвета
       int color = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        myPaint.setColor(color);

        //Заливка
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeWidth(3);


            //Конвертация в dp
        Resources r = getResources();

        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

                2, r.getDisplayMetrics());

        myPaint.setStrokeWidth(strokeWidthInPx);





    }


    // Использовать то что подготовили
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int cx = getWidth()/2;
        int cy = getHeight()/2;
        int radius = Math.min(getWidth(), getHeight())/2;
        canvas.drawCircle(cx, cy, radius, myPaint);

        int startx = 0;
        int starty =0;
        int stopx = getWidth();
        int stopy = getHeight();
        canvas.drawLine(startx, starty, stopx, stopy, myPaint);

        arcRectF.left = 0;
        arcRectF.top = 0;
        arcRectF.right = getWidth();
        arcRectF.bottom = getHeight();

        myPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(arcRectF, 0,180, true, myPaint);


    }
}
