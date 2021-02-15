package ru.iipokoiiehko.dagger2sample.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseDiActivity(
    @LayoutRes
    contentLayoutId: Int
): AppCompatActivity(contentLayoutId)