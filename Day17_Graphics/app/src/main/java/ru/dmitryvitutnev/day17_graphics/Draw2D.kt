package ru.dmitryvitutnev.day17_graphics

import android.content.Context
import android.graphics.*
import android.view.View

class Draw2D(context : Context) : View(context) {

    private val mPaint = Paint()
    private val mRect = Rect()
    private val mBitmap = BitmapFactory.decodeResource(this.resources, R.drawable.cat)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.WHITE
        canvas?.drawPaint(mPaint)

        mPaint.isAntiAlias = true
        mPaint.color = Color.YELLOW
        canvas?.drawCircle(width - 30f, 30f, 25f, mPaint)

        mPaint.color = Color.GREEN
        canvas?.drawRect(0f, height - 30f, width.toFloat(),
            height.toFloat(), mPaint)

        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mPaint.textSize = 32f
        canvas?.drawText("Лужайка только для котов", 30f, height - 32f, mPaint)

        val x = width - 170f
        val y = 190f
        mPaint.color = Color.GRAY
        mPaint.textSize = 27f
        canvas?.save();
        canvas?.rotate(-45f, x + mRect.exactCenterX(), y + mRect.exactCenterY())
        mPaint.style = Paint.Style.FILL
        canvas?.drawText("Лучик солнца!", x, y, mPaint)
        canvas?.restore()

        canvas?.drawBitmap(mBitmap, width.toFloat() - mBitmap.getWidth(), height.toFloat() - mBitmap.getHeight() - 10, mPaint);

    }


}