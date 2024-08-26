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
</androidx.constraintlayout.widget.ConstraintLayout>
```

4. Configuro themes.xml:

```
   <?xml version="1.0" encoding="utf-8"?>
<resources>

    <style name="Theme.JuegoKotlin" parent="Theme.AppCompat" />
</resources>
```

