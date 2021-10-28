package com.example.menuApp

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.menuApp.R.id.*


class MainActivity : AppCompatActivity() {

    interface mutableMap<K,V> : Map<K,V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1 = findViewById<Button>(b1)
        val plato1 = findViewById<CheckBox>(cB1)
        val plato2 = findViewById<CheckBox>(cB2)
        val plato3 = findViewById<CheckBox>(cB3)
        val eT1 = findViewById<EditText>(eT1)
        val sw1 = findViewById<Switch>(sw1)
        val rG1 = findViewById<RadioGroup>(rG1)
        val rB1 = findViewById<RadioButton>(rB1)
        val rB2 = findViewById<RadioButton>(rB2)
        val eT2 = findViewById<EditText>(eT2)
        val masPlato1  = findViewById<ImageButton>(iB1)
        val menosPlato1 = findViewById<ImageButton>(iB2)
        val res: Resources = resources
        var literales = resources.getStringArray(R.array.literales)


        // Creamos un mapa en el que la clave será el nombre del plato y el valor, la cantidad, por ejemplo ["ensaladilla", 2]
        val platosMap = mutableMapOf(
            plato1.text.toString() to 0,
            plato2.text.toString() to 0,
            plato3.text.toString() to 0,
        )

        // Por defecto dejamos invisibles los componentes asociados a la intolerancia
        eT1.setVisibility(View.INVISIBLE)
        rG1.setVisibility(View.INVISIBLE)

        // El switch de intolerancia nos permite poner visibles o invisibles sus componentes
        sw1.setOnClickListener {
            if (sw1.isChecked) {
                eT1.setVisibility(View.VISIBLE)
                rG1.setVisibility(View.VISIBLE)
            } else {
                eT1.setText("")
                rB1.isChecked=false
                rB2.isChecked=false
                eT1.setVisibility(View.INVISIBLE)
                rG1.setVisibility(View.INVISIBLE)
            }
        }

        // Al marcar el check de plato1 la incluimos en el mapa con cantidad inicial 0, e invocamos al botón masPlato1 
        plato1.setOnClickListener {
            if (plato1.isChecked) {
                platosMap.put(plato1.text.toString(),0)
                masPlato1 .performClick()
            }
        }

        // Al pulsar este botón incrementamos en el mapa el número de platos de plato1 y lo mostramos al usuario
        masPlato1 .setOnClickListener{
            var cantidad: Int=0
            cantidad= platosMap.get(plato1.text.toString())!!.toInt()
            cantidad++
            platosMap.put(plato1.text.toString(),cantidad)
            eT2.setText(cantidad.toString())
            plato1.isChecked=true
        }

        // Al pulsar este botón decrementamos en el mapa el número de platos de plato1 y lo mostramos al usuari
        menosPlato1.setOnClickListener{
            var cantidad: Int=0
            cantidad= platosMap.get(plato1.text.toString())!!.toInt()
            cantidad--
            if (cantidad<=0){  // Controlamos que el mínimo de platos sea 0
                cantidad=0
                plato1.isChecked=false  //Si no hay plato1s, desactivamos el checkButton
            }
            platosMap.put(plato1.text.toString(),cantidad)
            eT2.setText(cantidad.toString())
        }

        plato3.setOnClickListener {
            platosMap.put(plato3.text.toString(),1)
            if (plato3.isChecked) {
                platosMap.put(plato3.text.toString(),1)
            } else {
                platosMap.put(plato3.text.toString(),0)
            }
        }

        plato2.setOnClickListener {
            platosMap.put(plato2.text.toString(),1)
            if (plato2.isChecked) {
                platosMap.put(plato2.text.toString(),1)
            } else {
                platosMap.put(plato2.text.toString(),0)
            }
        }

        // Botón que envía la comanda a una nueva actividad

        b1.setOnClickListener {
            //  mensaje a enviar a la segunda actividad a través de un intent
            var mensaje = ""

            // Si no hay checks marcados, muestra una alerta en un toast
            if (!plato1.isChecked && !plato2.isChecked && !plato3.isChecked ) {
                Toast.makeText(
                    applicationContext,
                    "Debe seleccionar al menos un plato",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                //Recorremos el mapa de platos y cantidades y lo añadimos al mensaje
                for ((plato, cantidad) in platosMap) {
                    if (cantidad > 0) {
                        mensaje += plato + ":" + cantidad + "\n"
                    }
                }
                //Añadimos al mensaje la información de intolerancia
                if (rB1.isChecked)
                    mensaje += literales[0] + rB1.text+ "\n"

                if (rB2.isChecked)
                    mensaje += literales[0] + rB2.text+ "\n"

                if (eT1.length()>0)
                    mensaje += literales[1] + eT1.text+ "\n"

                val intento1 = Intent(this, DisplayMessageActivity::class.java)

                intento1.putExtra("seleccionDeMenu", mensaje)
                startActivity(intento1)
            }
        }

    }
}