package pramonow.com.draggablebutton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.pramonow.draggablebuttonmodule.DraggableButton

class MainActivity : AppCompatActivity() {

    lateinit var draggableButton: DraggableButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        draggableButton = findViewById(R.id.draggable_button)
        draggableButton.setOnClickListener { Toast.makeText(this,"CLICK",Toast.LENGTH_SHORT).show() }
        draggableButton.setText("Button")

        //sensitivity can be set here, by default it is 10
        draggableButton.sensitivity = 20

    }
}
