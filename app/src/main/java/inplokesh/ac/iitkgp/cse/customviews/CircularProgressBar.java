package inplokesh.ac.iitkgp.cse.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lokeshponnada on 6/9/16.
 */

public class CircularProgressBar extends View {

    private String TAG = "CircularProgressBar";

    int defaultColor, progressColor, remnantColor, outerStrokeColor, innerStrokeColor;
    float outerRadius;
    float innerRadius;
    float outerStrokeWidth;
    float innerStrokeWidth;

    public float getProgressColorWidth() {
        return progressColorWidth;
    }

    public void setProgressColorWidth(float progressColorWidth) {
        this.progressColorWidth = progressColorWidth;
    }

    float progressColorWidth;


    float x, y, r, w;

    Paint outerPaint, innerPaint, progressPaint, remanantPaint, defaultPaint;

    public float getInnerStrokeWidth() {
        return innerStrokeWidth;
    }

    public void setInnerStrokeWidth(float innerStrokeWidth) {
        this.innerStrokeWidth = innerStrokeWidth;
        invalidate();
        requestLayout();
    }

    public int getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(int defaultColor) {
        this.defaultColor = defaultColor;
        invalidate();
        requestLayout();
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
        invalidate();
        requestLayout();
    }

    public int getOuterStrokeColor() {
        return outerStrokeColor;
    }

    public void setOuterStrokeColor(int outerStrokeColor) {
        this.outerStrokeColor = outerStrokeColor;
        invalidate();
        requestLayout();
    }

    public int getRemnantColor() {
        return remnantColor;
    }

    public void setRemnantColor(int remnantColor) {
        this.remnantColor = remnantColor;
        invalidate();
        requestLayout();
    }

    public int getInnerStrokeColor() {
        return innerStrokeColor;
    }

    public void setInnerStrokeColor(int innerStrokeColor) {
        this.innerStrokeColor = innerStrokeColor;
        invalidate();
        requestLayout();
    }

    public float getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(float outerRadius) {
        this.outerRadius = outerRadius;
        invalidate();
        requestLayout();
    }

    public float getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(float innerRadius) {
        this.innerRadius = innerRadius;
        invalidate();
        requestLayout();
    }

    public float getOuterStrokeWidth() {
        return outerStrokeWidth;
    }

    public void setOuterStrokeWidth(float outerStrokeWidth) {
        this.outerStrokeWidth = outerStrokeWidth;
        invalidate();
        requestLayout();
    }


    public CircularProgressBar(Context context, AttributeSet attrs) {


        super(context, attrs);

        Log.d(TAG, "Constructor called for cpb");

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircularProgressBar, 0, 0);

        try {
            defaultColor = a.getColor(R.styleable.CircularProgressBar_defaultColor, Color.BLACK);
            progressColor = a.getColor(R.styleable.CircularProgressBar_progressColor, Color.BLACK);
            remnantColor = a.getColor(R.styleable.CircularProgressBar_remainingColor, Color.BLACK);
            outerStrokeColor = a.getColor(R.styleable.CircularProgressBar_outerStrokeColor, Color.BLACK);
            innerStrokeColor = a.getColor(R.styleable.CircularProgressBar_innerStrokeColor, Color.BLACK);
            outerRadius = a.getDimension(R.styleable.CircularProgressBar_outerRadius, 0f);
            innerRadius = a.getDimension(R.styleable.CircularProgressBar_innerRadius, 0f);
            outerStrokeWidth = a.getDimension(R.styleable.CircularProgressBar_outerStrokeWidth, 0f);
            innerStrokeWidth = a.getDimension(R.styleable.CircularProgressBar_innerStrokeWidth, 0f);
            progressColorWidth = a.getDimension(R.styleable.CircularProgressBar_progressColorWidth, 0f);

        } finally {
            a.recycle();
        }

        init();
    }


    public void init() {

        Log.d(TAG, "Init called for cpb");

        outerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        innerPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


//        defaultPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        defaultPaint.setColor(defaultColor);
//        defaultPaint.setStrokeWidth(outerRadius - innerRadius - innerStrokeWidth);
//
//        remanantPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        remanantPaint.setColor(remnantColor);
//        remanantPaint.setStrokeWidth(outerRadius - innerRadius - innerStrokeWidth);

    }


    public void setUpParams() {
        outerPaint.setColor(outerStrokeColor);
        outerPaint.setStyle(Paint.Style.STROKE);
        outerPaint.setStrokeWidth(outerStrokeWidth);

        progressPaint.setColor(progressColor);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(progressColorWidth);

        innerPaint.setColor(innerStrokeColor);
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setStrokeWidth(innerStrokeWidth);
    }

    @Override
    public void onDraw(Canvas canvas) {

        Log.d(TAG, "onDraw called for cpb");

        setUpParams();

        int xCenter = canvas.getWidth() / 2;
        int yCenter = canvas.getHeight() / 2;

        canvas.drawCircle(xCenter, yCenter, outerRadius, outerPaint);
        canvas.drawCircle(xCenter, yCenter, outerRadius + (outerStrokeWidth / 2) - (progressColorWidth / 2), progressPaint);
        canvas.drawCircle(xCenter, yCenter, innerRadius, innerPaint);

    }
}
