package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    Paint paint;


    List<Model> models = new ArrayList<>();
    String string = "直方图";

    {
        models.add(new Model(1, "Froyo"));
        models.add(new Model(20, "GB"));
        models.add(new Model(34, "ICS"));
        models.add(new Model(19, "JB"));
        models.add(new Model(50, "KitKat"));
        models.add(new Model(100, "L"));
        models.add(new Model(80, "M"));
    }

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        if (paint == null) {
            paint = new Paint();
        }

        int x = getWidth();
        int y = getHeight();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        //绘制两条直线
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(100, y - 120);
        path.lineTo(x - 100, y - 120);
        canvas.drawPath(path, paint);

        //绘制“直方图”文字
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(28);
        canvas.drawText(string, x / 2, y - 30, paint);


        int columnWidth = (x - 100 - 100 - 5 - 5) / (models.size());//每个栏目的宽度，两头各留空5px

        //绘制直方图对应column名称
        paint.setTextSize(18);
        for (int i = 0; i < models.size(); i++) {
            canvas.drawText(models.get(i).getName(), 100 + (i + 1) * columnWidth - columnWidth / 2 + 5, y - 120 + 20,
                    paint);
        }

        //绘制直方图上数据方块
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        Path squarePath = new Path();

        for (int i = 0; i < models.size(); i++) {
            squarePath.addRect(100 + 5 + 5 + i * columnWidth, y - 120 - models.get(i).getData(), 100 + columnWidth *
                    (i + 1), y - 120, Path.Direction.CW);

        }

        canvas.drawPath(squarePath, paint);


    }


    class Model {
        int data;
        String name;

        public Model(int data, String name) {
            this.data = data;
            this.name = name;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
