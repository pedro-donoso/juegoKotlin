![juego](https://github.com/user-attachments/assets/188975b3-7d17-44d7-847d-6b9196c53cd8)

![ganador](https://github.com/user-attachments/assets/56faf810-9a4e-4320-aa05-c5e4775f2380)

#### CONFIGURACIONES PREVIAS

1. Configuro gradle app:

```
buildFeatures {
        compose = true
        viewBinding = true
    }
    dataBinding {
        enable = true
    }
  ```
2. Dependencies:

```
val nav_version = "2.7.7"
    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation ("com.airbnb.android:lottie:3.7.0")
```

3. Configuro main_activity:

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    >

    <FrameLayout
        android:id="@+id/fragmentContainer1"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/fragmentContainer2"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        />

    <FrameLayout
        android:id="@+id/fragmentContainer2"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@+id/fragmentContainer1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        />
    
    <FrameLayout
        android:id="@+id/animationContainer"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:visibility="gone">
        
        <com.airbnb.lottie.LottieAnimationView
            android:id="@+id/winnerAnimation"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:lottie_autoPlay="false"
            app:lottie_loop="true"
            android:layout_gravity="center"
            app:lottie_rawRes="@raw/a"
            />

        <Button
            android:id="@+id/restartButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Restart"
            android:layout_gravity="center_horizontal|bottom"
            android:layout_marginBottom="16dp"/>
    </FrameLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

4. Configuro themes.xml:

```
   <?xml version="1.0" encoding="utf-8"?>
<resources>

    <style name="Theme.JuegoKotlin" parent="Theme.AppCompat" />
</resources>
```

5. Configuro fragment_player1.xml:

```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Player1Fragment">
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:orientation="vertical">
        
        <TextView
            android:id="@+id/counterText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0"
            android:textSize="32sp" />
        
        <Button
            android:id="@+id/clickButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Click" />
        
    </LinearLayout>
</FrameLayout>
```

6. Configuro fragment_player2.xml:

```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Player2Fragment">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:orientation="vertical">

        <TextView
            android:id="@+id/counterText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0"
            android:textSize="32sp" />

        <Button
            android:id="@+id/clickButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Click" />

    </LinearLayout>

</FrameLayout>
```
