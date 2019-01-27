package com.pramonow.draggablebuttonmodule

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button

class DraggableButton: Button{

    //Default sensitivity
    var sensitivity = 10;

    constructor(context: Context, attributeSet: AttributeSet) : super(context,attributeSet) {

        //gesture detector for tap action
        var gestureDetector = GestureDetector(context, SingleTapConfirm())

        var x = 0f
        var y = 0f

        //set listener when interactions happen with the button
        var listener = OnTouchListener(function = { view, motionEvent ->

            //if action is a tap then perform click action of the button
            if (gestureDetector.onTouchEvent(motionEvent)) {
                performClick()
                true
            }
            else if(motionEvent.action == MotionEvent.ACTION_DOWN) {

                //set the value for x and y
                x = motionEvent.getX()
                y = motionEvent.getY()
            }
            else if(motionEvent.action == MotionEvent.ACTION_MOVE){

                var x1 = motionEvent.getX()
                var y1 = motionEvent.getY()

                //check sensitivity
                if(Math.abs(x1+y1-x-y) > sensitivity) {
                    view.y = motionEvent.rawY - view.height * 2
                    view.x = motionEvent.rawX - view.width / 2
                }

                true
            }
            false
        })

        setOnTouchListener(listener)
    }

    //class for tap button
    private inner class SingleTapConfirm : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(event: MotionEvent): Boolean {
            return true
        }
    }

}