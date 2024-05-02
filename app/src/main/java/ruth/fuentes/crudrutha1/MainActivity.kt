package ruth.fuentes.crudrutha1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import modelo.ClaseConecxion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // 1- mandar a llamr todos los elemntos de la vista

        val txtNombre=findViewById<EditText>(R.id.txtNombre)
        val txtPrecio=findViewById<EditText>(R.id.txtPrecio)
        val txtCantidad=findViewById<EditText>(R.id.txtCantidad)
        val  btnAgregar=findViewById<Button>(R.id.btnAgregar)


        //2- Programar el boton

        btnAgregar.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO){
                //Guardar datos
                //1- Crear un objeto de la clase de conecxion
                val objConecxion=ClaseConecxion().cadenaConexion()


                //2- crear una variable que sea igual a un PrepareStatement
                val addProduto= objConecxion?.prepareStatement("insert into tbProductos1 values (?,?,?)")!!
                addProduto.setString(1, txtNombre.text.toString())
                addProduto.setInt(2, txtPrecio.text.toString().toInt())
                addProduto.setInt(3, txtCantidad.text.toString().toInt())
                addProduto.executeUpdate()

            }
        }



    }
}