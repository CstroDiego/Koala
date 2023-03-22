package mx.itson.koala.persistencia

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class KoalaDB(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    @SuppressLint("LongLogTag")
    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {
            Log.e("creando base de datos", "creando base de datos")
            sqliteDatabase.execSQL(
                "CREATE TABLE Usuario" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, telefono TEXT, email TEXT)"
            )
        } catch (ex: Exception) {
            Log.e("ocurrio un error al crear la base de datos", ex.toString())
        }

    }

    override fun onUpgrade(sqliteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //sqliteDatabase.execSQL("DROP TABLE IF EXISTS Usuario")
        // onCreate(sqliteDatabase)
    }
}
