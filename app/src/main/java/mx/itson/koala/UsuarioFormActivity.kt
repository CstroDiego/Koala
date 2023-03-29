package mx.itson.koala

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.itson.koala.entidades.Usuario

class UsuarioFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_form)
    }

    fun agregarUsuario(view: View) {
        try {
            val nombre = findViewById<EditText>(R.id.txtNombre)
            val telefono = findViewById<EditText>(R.id.txtTelefono)
            val email = findViewById<EditText>(R.id.txtEmail)
            Usuario().guardar(this, nombre.text.toString(), telefono.text.toString(), email.text.toString())
            Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show()
            finish()
        } catch (ex: Exception) {
            Toast.makeText(this, "Ocurrio un error al agregar usuario", Toast.LENGTH_SHORT).show()
        }
    }
}
