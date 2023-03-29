package mx.itson.koala

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.itson.koala.entidades.Usuario

class UsuarioFormActivity : AppCompatActivity(), View.OnClickListener {

    private var usuario: Usuario? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_form)

        val btnGuardar = findViewById<View>(R.id.btnGuardar)
        btnGuardar.setOnClickListener(this)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            usuario = intent.getSerializableExtra("usuario", Usuario::class.java)
        } else {
            usuario = intent.getSerializableExtra("usuario") as Usuario?
        }

        if (usuario != null) {
            val txtNombre = findViewById<EditText>(R.id.txtNombre)
            val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
            val txtEmail = findViewById<EditText>(R.id.txtEmail)
            txtNombre.setText(usuario?.nombre)
            txtTelefono.setText(usuario?.telefono)
            txtEmail.setText(usuario?.email)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGuardar -> {
                if (usuario != null) {
                    Log.w("UsuarioFormActivity", "Se encontro usuario")
                    editarUsuario()
                } else {
                    Log.w("UsuarioFormActivity", "No se encontro usuario")
                    agregarUsuario(v)
                }
            }
        }
    }

    private fun agregarUsuario(view: View) {
        try {
            val nombre = findViewById<EditText>(R.id.txtNombre)
            val telefono = findViewById<EditText>(R.id.txtTelefono)
            val email = findViewById<EditText>(R.id.txtEmail)
            Usuario().guardar(
                this,
                nombre.text.toString(),
                telefono.text.toString(),
                email.text.toString()
            )
            Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show()
            finish()
        } catch (ex: Exception) {
            Toast.makeText(this, "Ocurrio un error al agregar usuario", Toast.LENGTH_SHORT).show()
        }
    }

    private fun editarUsuario() {
        try {
            val nombre = findViewById<EditText>(R.id.txtNombre)
            val telefono = findViewById<EditText>(R.id.txtTelefono)
            val email = findViewById<EditText>(R.id.txtEmail)
            usuario?.nombre = nombre.text.toString()
            usuario?.telefono = telefono.text.toString()
            usuario?.email = email.text.toString()
            Usuario().editar(
                this,
                usuario?.id,
                usuario?.nombre,
                usuario?.telefono.toString(),
                usuario?.email.toString()
            )
            Log.i("UsuarioFormActivity", "Usuario ${usuario?.nombre} editado")
            finish()
        } catch (ex: Exception) {
            ex.message?.let { Log.e("UsuarioFormActivity", it) }
        }
    }
}
