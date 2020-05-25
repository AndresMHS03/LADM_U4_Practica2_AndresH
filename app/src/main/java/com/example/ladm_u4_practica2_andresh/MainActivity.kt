package com.example.ladm_u4_practica2_andresh

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),SensorEventListener {

    lateinit var sensor:SensorManager
    var sProximidad :Sensor?=null
    var sAcelerometro :Sensor ?=null

    var lienzo:Lienzo?=null
    var tapad:Tapado?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensor = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sProximidad = sensor.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        sAcelerometro = sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensor.registerListener(this,sProximidad,SensorManager.SENSOR_DELAY_GAME)
        sensor.registerListener(this,sAcelerometro,SensorManager.SENSOR_DELAY_GAME)

        lienzo=Lienzo(this)
        tapad=Tapado(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var actiSensor = event!!.sensor

        if (actiSensor.type==Sensor.TYPE_ACCELEROMETER){

            if (event.values[0] > 4) {
                lienzo!!.icono.direccion = 1
                tapad!!.icono.direccion = 1
                lienzo!!.mover()
                tapad!!.mover()
            } else {
                if (event.values[0] < -4) {

                    lienzo!!.icono.direccion = 2
                    tapad!!.icono.direccion = 2
                    lienzo!!.mover()
                    tapad!!.mover()
                } else {
                    lienzo!!.icono.direccion = 0
                    tapad!!.icono.direccion = 0
                    lienzo!!.mover()
                    tapad!!.mover()
                }
            }
        }

        if(actiSensor.type == Sensor.TYPE_PROXIMITY){
            if(event.values[0]<sProximidad!!.maximumRange){
                setContentView(tapad)
            }else {
                setContentView(lienzo)
            }
        }
    }
}
