package com.zhangyf.gapbottomnavigationview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import androidx.annotation.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class GapBottomNavigationView : BottomNavigationView {


    private var centerRadius: Float = 0.toFloat() //中间凹陷的半径
    private var cornerRadius = 12f //拐角处的圆滑大小（越大越平滑）
    private var shadowLength = 6f //阴影大小

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        background = GradientDrawable().apply { setColor(Color.TRANSPARENT) }
        val ta = context.obtainStyledAttributes(attrs, R.styleable.GapBottomNavigationView)
        centerRadius = ta.getDimension(R.styleable.GapBottomNavigationView_center_radius, 0.toFloat())
        shadowLength = ta.getDimension(R.styleable.GapBottomNavigationView_shadow_length, 6.toFloat())
        cornerRadius = ta.getDimension(R.styleable.GapBottomNavigationView_corner_radius, 12.toFloat())
        ta.recycle()
    }

    @SuppressLint("DrawAllocation")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas);
        val paint = Paint()
        val path = Path()

        path.moveTo(0.0f,height.toFloat())
        path.lineTo(0.0f,shadowLength)
        val rectFRadius = cornerRadius
        //绘制圆角
        path.arcTo(RectF(0.0f,shadowLength,2 * rectFRadius,2 * rectFRadius),180.toFloat(),90.toFloat(),false)
        //绘制直线
        path.lineTo(width / 2 - centerRadius - cornerRadius, shadowLength)
        //左边转角处
        path.quadTo(width / 2 - centerRadius, shadowLength, width / 2 - centerRadius, cornerRadius + shadowLength)

        //中间凹陷的半圆
        path.arcTo(RectF(width / 2 - centerRadius, cornerRadius + shadowLength - centerRadius, width / 2 + centerRadius, cornerRadius + centerRadius + shadowLength
        ), 180.toFloat(), (-180).toFloat(), false)

        //右边转角处
        path.quadTo(width / 2 + centerRadius, shadowLength, width / 2 + centerRadius + cornerRadius, shadowLength)
        path.lineTo(width.toFloat() - 2 * rectFRadius, shadowLength)
        //绘制圆角
        path.arcTo(RectF(width.toFloat() - 2 * rectFRadius , shadowLength ,width.toFloat(),2 * rectFRadius),270.toFloat(),90.toFloat(),false)
        //绘制直线
        path.lineTo(width.toFloat(), height.toFloat())
        //按背景色填充背景
        paint.apply {
            style = Paint.Style.FILL
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                color = backgroundTintList?.defaultColor ?: Color.WHITE
            }
            maskFilter = null
            isAntiAlias = true
            //添加阴影
            setShadowLayer(shadowLength, 0.toFloat(), 0.toFloat(), Color.LTGRAY)
        }

        canvas.drawPath(path, paint)
    }

}
