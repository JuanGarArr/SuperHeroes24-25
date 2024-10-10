package com.example.app.extensions

import android.widget.ImageView
import coil.load

//clase de android que añade una funcion que no se ha creado
//Sin funcion de extension seria con una herencia.

fun ImageView.loadUrl(url: String){
    this.load(url)
}