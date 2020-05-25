package com.example.ladm_u4_practica2_andresh

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

class Figura () {

    var x = 0f
    var y = 0f
    var alto = 0f
    var ancho = 0f
    var rad = 0f
    var tipo = 0 //0=circulo 1=rectangulo 2=imagen

    var bitmap : Bitmap ?= null

    var direccion = 0

    constructor(x:Int,y:Int,rad:Int):this(){
        this.x=x.toFloat()
        this.y=y.toFloat()
        this.rad=rad.toFloat()
    }

    constructor(x:Int,y:Int,alto:Int,ancho:Int):this(){
        this.x=x.toFloat()
        this.y=y.toFloat()
        this.alto=alto.toFloat()
        this.ancho=ancho.toFloat()
        tipo=1
    }

    constructor(x:Int,y:Int,imagen:Bitmap):this(){
        bitmap=imagen
        this.x=x.toFloat()
        this.y=y.toFloat()
        ancho = bitmap!!.width.toFloat()
        alto = bitmap!!.height.toFloat()
        tipo=2
    }

    fun dibujar(c:Canvas,p: Paint){
        when(tipo){
            0->{
                c.drawCircle(x,y,rad,p)
            }
            1->{
                c.drawRect(x,y,x+ancho,y+alto,p)
            }
            2->{
                c.drawBitmap(bitmap!!,x,y,p)
            }
        }
    }

    fun mover(){
        if(direccion==1){
            if(x>0f){
                x-=50
            }
        }else{
            if(direccion==2){
                if(x<480f){
                    x += 50
                }
            }
        }
    }

    fun otroMover(){
        if(direccion==1){
            if(x>0f){
                x-=50
            }
        }else{
            if(direccion==2){
                if(x<780f){
                    x+=50
                }
            }
        }
    }
}