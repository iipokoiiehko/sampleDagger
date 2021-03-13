package ru.iipokoiiehko.main_core_ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseDiActivity(
    @LayoutRes
    contentLayoutId: Int
): AppCompatActivity(contentLayoutId) {

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }
}