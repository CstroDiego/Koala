package mx.itson.koala.entidades

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.koala.persistencia.KoalaDB

object Usuario {

    var id: Int = 0
    var nombre: String? = null
    var telefono: String? = null
    var email: String? = null

    @SuppressLint("LongLogTag")
    fun guardar(context: Context, nombre: String?, telefono: String, email: String) {
        try {
            val KoalaDB = KoalaDB(context, "KoalaDB", null, 1)
            val baseDatos: SQLiteDatabase = KoalaDB.writableDatabase
            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("telefono", telefono)
            valores.put("email", email)
            baseDatos.insert("Usuario", null, valores)
        } catch (ex: Exception) {

            Log.e("ocurrio un error al guardar usuario", ex.toString())
        }
    }

    fun obtener(context: Context): List<Usuario> {
        val usuarios: MutableList<Usuario> = ArrayList()
        try {
            val KoalaDB = KoalaDB(context, "KoalaDB", null, 1)
            val baseDatos: SQLiteDatabase = KoalaDB.readableDatabase
            val cursor = baseDatos.rawQuery("SELECT id, nombre, telefono, email FROM usuario", null)
            while (cursor.moveToNext()) {
                val usuario = Usuario.apply {
                    nombre = cursor.getString(1)
                    telefono = cursor.getString(2)
                    email = cursor.getString(3)
                }
                usuarios.add(usuario)
            }
        } catch (ex: Exception) {
            Log.e("ocurrio un error al obtener usuario", ex.toString())
        }
        return usuarios
    }
}
