package com.example.superheroes24.extensions

import android.widget.ImageView
import coil.load

fun ImageView.loadUrl(url: String){
    this.load(url)
}