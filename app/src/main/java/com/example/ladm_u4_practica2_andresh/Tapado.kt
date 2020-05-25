package com.example.ladm_u4_practica2_andresh

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Tapado (p:MainActivity): View(p){

    var puntero = p
    var altura = 0
    var anchura = 0

    var icono= Figura(400,1150, BitmapFactory.decodeResource(resources,R.drawable.link))
    var icono2 = Figura(100,1150,BitmapFactory.decodeResource(resources,R.drawable.enemy))
    var icono3 = Figura(350,900,BitmapFactory.decodeResource(resources,R.drawable.enemy))
    var icono4 = Figura(610,1005,BitmapFactory.decodeResource(resources,R.drawable.enemy))
    var icono5 = Figura(200,1210,BitmapFactory.decodeResource(resources,R.drawable.enemy))
    var icono6=Figura(150,20,BitmapFactory.decodeResource(resources,R.drawable.pedestal))

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var p= Paint()

        altura = canvas!!.height
        anchura = canvas!!.width

        var fondo = Figura(0,0,altura,anchura)
        p.color = Color.rgb(21,11,37)
        fondo.dibujar(canvas,p)


        var suelo = Figura(0, 1600, altura, anchura)
        p.color = Color.rgb(60, 44, 35)
        suelo.dibujar(canvas, p)


        icono.dibujar(canvas,p)
        icono2.dibujar(canvas,p)
        icono3.dibujar(canvas,p)
        icono4.dibujar(canvas,p)
        icono5.dibujar(canvas,p)
        icono6.dibujar(canvas,p)
    }

    fun mover(){
        icono.mover()
        invalidate()
    }
}