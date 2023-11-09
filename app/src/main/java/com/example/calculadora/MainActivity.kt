package com.example.calculadora
/*Realizar una calculadora funcional tanto en horizontal como en vertical. La diferencia entre
ambas será que la horizontal mostrará las operaciones básicas mientras que la horizontal
mostrará operaciones científicas. Puedes meter tantas operaciones como quieras, cuanto más
completa sea la calculadora mejora estará realizado el ejercicio*/
import android.annotation.SuppressLint
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import com.example.calculadora.databinding.ActivityMainBinding

//preguntar como dejar la operacion cuando se gira
//como hacer decimales
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding //declaramos la variable
    private var escritura: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //para rellenar llamamos a la variable
        setContentView(binding.root) //para rellenar llegamos a la variable

        binding.division.setOnClickListener(this)
        binding.multiplicacion.setOnClickListener(this)
        binding.resta.setOnClickListener(this)
        binding.suma.setOnClickListener(this)
        binding.igual.setOnClickListener(this)
        binding.coma.setOnClickListener(this)
        binding.cero.setOnClickListener(this)
        binding.ac.setOnClickListener(this)
        binding.masmenos.setOnClickListener(this)
        binding.porcentaje.setOnClickListener(this)
        binding.uno.setOnClickListener(this)
        binding.dos.setOnClickListener(this)
        binding.tres.setOnClickListener(this)
        binding.cuatro.setOnClickListener(this)
        binding.cinco.setOnClickListener(this)
        binding.seis.setOnClickListener(this)
        binding.siete.setOnClickListener(this)
        binding.ocho.setOnClickListener(this)
        binding.nueve.setOnClickListener(this)
        binding.raiz?.setOnClickListener(this)
        binding.cubo?.setOnClickListener(this)
        binding.potencial?.setOnClickListener(this)
        binding.cuadrado?.setOnClickListener(this)
        binding.logaritmonatural?.setOnClickListener(this)
        binding.pi?.setOnClickListener(this)
        binding.tangente?.setOnClickListener(this)
        binding.raizcubo?.setOnClickListener(this)
        binding.seno?.setOnClickListener(this)
        binding.coseno?.setOnClickListener(this)



    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.cero -> {
                escritura += "0"

            }

            R.id.uno -> {
                escritura += "1"
            }

            R.id.dos -> {
                escritura += "2"
            }

            R.id.tres -> {
                escritura += "3"
            }

            R.id.cuatro -> {
                escritura += "4"
            }

            R.id.cinco -> {
                escritura += "5"
            }

            R.id.seis -> {
                escritura += "6"
            }

            R.id.siete -> {
                escritura += "7"
            }

            R.id.ocho -> {
                escritura += "8"

            }

            R.id.nueve -> {
                escritura += "9"
            }

            R.id.coma -> {
                escritura += ","
            }

            binding.raiz?.id -> {
                escritura = Math.sqrt(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            R.id.porcentaje -> {
                escritura += "%"
            }

            binding.coseno?.id -> {
                escritura = Math.cos(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())

            }

            binding.cubo?.id -> {
                escritura = Math.pow(escritura.toDouble(), 3.0).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            binding.cuadrado?.id -> {
                escritura = Math.pow(escritura.toDouble(), 2.0).toString()
                escritura = formatoResultado(escritura.toDouble())

            }

            binding.logaritmonatural?.id -> {
                escritura = Math.log10(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            binding.pi?.id -> {
                escritura = Math.PI.toString()

            }

            binding.seno?.id -> {
                escritura = Math.sin(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            binding.tangente?.id -> {
                escritura = Math.tan(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            R.id.division -> {
                escritura += "/"
            }

            R.id.multiplicacion -> {
                escritura += "x"
            }

            R.id.suma -> {
                escritura += "+"
            }

            R.id.resta -> {
                escritura += "-"
            }

            R.id.ac -> {
                escritura = ""
            }

            R.id.masmenos -> {
                escritura = (escritura.toDouble() * -1).toString()
                
            }

            binding.potencial?.id -> {
                escritura = Math.pow(escritura.toDouble(), 2.0).toString()
                escritura = formatoResultado(escritura.toDouble())
            }

            binding.raizcubo?.id -> {
                escritura = Math.cbrt(escritura.toDouble()).toString()
                escritura = formatoResultado(escritura.toDouble())
            }




            R.id.igual -> {
                val input = binding.texto1.text
                if (input.isNotEmpty()) {
                    if (input.contains("+")) {
                        val parts = input.split("+")
                        if (parts.size == 2) {
                            val operand1 = parts[0].toDouble()
                            val operand2 = parts[1].toDouble()
                            val result = operand1 + operand2
                            binding.texto2.text = escritura + ("=").toString()
                            escritura = formatoResultado(result)
                        }
                    } else if (input.contains("-")) {
                        val parts = input.split("-")
                        if (parts.size == 2) {
                            val operand1 = parts[0].toDouble()
                            val operand2 = parts[1].toDouble()
                            val result = operand1 - operand2
                            binding.texto2.text = escritura + ("=").toString()
                            escritura = formatoResultado(result)
                        }
                    } else if (input.contains("x")) {
                        val parts = input.split("x")
                        if (parts.size == 2) {
                            val operand1 = parts[0].toDouble()
                            val operand2 = parts[1].toDouble()
                            val result = operand1 * operand2
                            binding.texto2.text = escritura + ("=").toString()
                            escritura = formatoResultado(result)
                        }
                    } else if (input.contains("/")) {
                        val parts = input.split("/")
                        if (parts.size == 2) {
                            val operand1 = parts[0].toDouble()
                            val operand2 = parts[1].toDouble()
                            val result = operand1 / operand2
                            binding.texto2.text = escritura + ("=").toString()
                            escritura = formatoResultado(result)
                        }
                    } else if (input.contains("%")) {
                        val parts = input.split("%")
                        if (parts.size == 2) {
                            val operand1 = parts[0].toDouble()
                            val result = operand1 * 100
                            binding.texto2.text = escritura + ("=").toString()
                            escritura = formatoResultado(result)
                        }

                    }


                }
            }
        }
        binding.texto1.text = escritura


    }

    fun formatoResultado(valor: Double): String {
        if (valor % 1 == 0.0) {
            return valor.toInt().toString()
        } else {
            return valor.toString()
        }

    }
}





































