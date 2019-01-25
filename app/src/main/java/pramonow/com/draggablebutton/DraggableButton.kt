package pramonow.com.draggablebutton

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button

class DraggableButton: Button{

    public var sensitivity = 20;

    constructor(context: Context, attributeSet: AttributeSet) : super(context,attributeSet) {

        var gestureDetector = GestureDetector(context, SingleTapConfirm())

        var x = 0f
        var y = 0f

        var listener = OnTouchListener(function = { view, motionEvent ->

            if (gestureDetector!!.onTouchEvent(motionEvent)) {
                // single tap
                performClick()

                true
            }
            else if(motionEvent.action == MotionEvent.ACTION_DOWN) {
                x = motionEvent.getX()
                y = motionEvent.getY()
            }
            else if(motionEvent.action == MotionEvent.ACTION_MOVE){

                var x1 = motionEvent.getX()
                var y1 = motionEvent.getY()

                //sensitivity
                if(Math.abs(x1+y1-x-y) > sensitivity) {

                    view.y = motionEvent.rawY - view.height
                    view.x = motionEvent.rawX - view.width / 2
                }

                true
            }

            false
        })

        setOnTouchListener(listener)

    }

    private inner class SingleTapConfirm : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(event: MotionEvent): Boolean {
            return true
        }
    }

}