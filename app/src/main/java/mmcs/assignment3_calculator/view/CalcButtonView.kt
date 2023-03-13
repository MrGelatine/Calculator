package mmcs.assignment3_calculator.view

import android.content.Context
import android.util.AttributeSet
import android.view.View

class CalcButtonView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = MeasureSpec.getSize(heightMeasureSpec)/5
        //MUST CALL THIS
        setMeasuredDimension(parentWidth, parentHeight)
    }
}