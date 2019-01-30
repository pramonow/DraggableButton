# Draggable button component for Android [![](https://jitpack.io/v/pramonow/android-draggableButton.svg)](https://jitpack.io/#pramonow/android-draggableButton)

Providing android draggable button component the easy way.

<img src="https://github.com/pramonow/just_images/blob/master/DraggableButton.gif" width="180"> 

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Dependency

	dependencies {
	        implementation 'com.github.pramonow:android-draggableButton:1.0'
	}
  
Or you can use SNAPSHOT to keep your module up to date

	dependencies {
	        implementation 'com.github.pramonow:android-draggableButton:-SNAPSHOT'
	}
  
# How to use

For the Android xml file

    <com.pramonow.draggablebuttonmodule.DraggableButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/draggable_button"/>

For the Android Activity
	
	var draggableButton: DraggableButton
	draggableButton = findViewById(R.id.draggable_button)

	//Use setOnTapListener instead of onClickListener for it to work as intended
	//setOnTapListener is function provided from Draggable Button component
	//If passing function is not preferred then interface is also provided (OnButtonTapListener)
	draggableButton.setOnTapListener { Toast.makeText(this,"CLICK",Toast.LENGTH_SHORT).show() }

	//DraggableButton is extension from Button
	draggableButton.setText("Button")

	//sensitivity can be set here, by default it is 20
	draggableButton.sensitivity = 20
