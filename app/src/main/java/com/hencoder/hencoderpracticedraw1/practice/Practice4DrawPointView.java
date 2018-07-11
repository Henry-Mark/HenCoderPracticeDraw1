package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawPoint() 方法画点
        //        一个圆点，一个方点
        //        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        Paint roundPaint = new Paint();
        roundPaint.setAntiAlias(true);
        roundPaint.setStrokeCap(Paint.Cap.ROUND);
        roundPaint.setStrokeWidth(20);
        canvas.drawPoint(200, 100, roundPaint);

        Paint squarePaint = new Paint();
        squarePaint.setAntiAlias(true);
        squarePaint.setStrokeWidth(20);
        squarePaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(400, 100, squarePaint);
    }
}
