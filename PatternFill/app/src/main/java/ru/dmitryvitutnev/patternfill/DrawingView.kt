package ru.dmitryvitutnev.patternfill

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi


class DrawingView(context : Context, attrs: AttributeSet?) : View(context, attrs) {
    // путь для рисования
    private var drawPath: Path? = null

    // Paint для рисования и для холста
    private var drawPaint: Paint? = null  // Paint для рисования и для холста
    private var canvasPaint: Paint? = null

    // начальный цвет
    private val paintColor = -0x1000000

    // холст
    private var drawCanvas: Canvas? = null

    // битмап холста
    private var canvasBitmap: Bitmap? = null

    init {
        setupDrawing()
    }

    private fun setupDrawing() {
        drawPath = Path()
        drawPaint = Paint()
        drawPaint!!.setColor(paintColor)
        drawPaint!!.setAntiAlias(true)
        drawPaint!!.setStrokeWidth(50f)
        drawPaint!!.setStyle(Paint.Style.STROKE)
        drawPaint!!.setStrokeJoin(Paint.Join.ROUND)
        drawPaint!!.setStrokeCap(Paint.Cap.ROUND)
        canvasPaint = Paint(Paint.DITHER_FLAG)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap!!, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath!!, drawPaint!!)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawPath!!.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> drawPath!!.lineTo(touchX, touchY)
            MotionEvent.ACTION_UP -> {
                drawPath!!.lineTo(touchX, touchY)
                drawCanvas!!.drawPath(drawPath!!, drawPaint!!)
                drawPath!!.reset()
            }
            else -> return false
        }
        // перерисовать
        invalidate()
        return true
    }

    fun setPattern(newPattern: String?) {
        // устанавливаем узор
        invalidate()
        val patternID =
            resources.getIdentifier(newPattern, "drawable", context.packageName)
        val patternBMP = BitmapFactory.decodeResource(resources, patternID)
        val patternBMPshader =
            BitmapShader(patternBMP, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
        drawPaint!!.color = 0xFFFFFFFF.toInt();
        drawPaint!!.setShader(patternBMPshader);
    }

}