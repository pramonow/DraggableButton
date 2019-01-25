package pramonow.com.draggablebutton

import android.os.Bundle
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {

    lateinit var img:DraggableButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        img = findViewById(R.id.draggable_button)

        img.setOnClickListener { Toast.makeText(this,"CLICK",Toast.LENGTH_SHORT).show() }

        img.setText("Button")
    }
}
