package mx.itson.koala.entidades

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.koala.persistencia.KoalaDB

@SuppressLint("StaticFieldLeak")
class Usuario {

    var id: Int = 0
    var nombre: String? = null
    var telefono: String? = null
    var email: String? = null

    constructor()

    constructor(id: Int, nombre: String?, telefono: String?, email: String?) {
        this.id = id
        this.nombre = nombre
        this.telefono = telefono
        this.email = email
    }

    private lateinit var contexto: Context
    private lateinit var baseDatos: SQLiteDatabase

    fun inicializar(context: Context) {
        contexto = context.applicationContext
        val koalaDB = KoalaDB(contexto, "KoalaDB", null, 1)
        baseDatos = koalaDB.writableDatabase
    }

    fun guardar(context: Context, nombre: String?, telefono: String, email: String) {
        inicializar(context)
        try {
            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("telefono", telefono)
            valores.put("email", email)
            baseDatos.insert("Usuario", null, valores)
        } catch (ex: Exception) {
            Log.e("ocurrio un error al guardar usuario", ex.toString())
        }
    }

    fun obtenerTodos(context: Context): List<Usuario> {
        inicializar(context)
        val usuarios: MutableList<Usuario> = ArrayList()
        try {
            val cursor = baseDatos.rawQuery("SELECT id, nombre, telefono, email FROM usuario", null)
            while (cursor.moveToNext()) {
                val usuario = Usuario()
                usuario.id = cursor.getInt(0)
                usuario.nombre = cursor.getString(1)
                usuario.telefono = cursor.getString(2)
                usuario.email = cursor.getString(3)
                usuarios.add(usuario)
            }
        } catch (ex: Exception) {
            Log.e("ocurrio un error al obtener usuario", ex.toString())
        }
        return usuarios
    }
}
