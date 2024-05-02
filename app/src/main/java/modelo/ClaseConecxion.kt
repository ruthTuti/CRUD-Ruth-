package modelo

import java.sql.Connection
import java.sql.DriverManager

class ClaseConecxion {

    fun cadenaConexion(): Connection?{
        try{
            val ip = "jdbc:oracle:thin:@10.10.0.129:1521:xe"
            val usuario = "system"
            val contrasena = "desarrollo"

            val conecxion = DriverManager.getConnection(ip,usuario,contrasena)
            return conecxion
        }catch (e: Exception){
            println(" el error es este: $e")
            return null
        }
    }

}