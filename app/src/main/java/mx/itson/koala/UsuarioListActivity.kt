package mx.itson.koala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import mx.itson.koala.adapters.UsuarioAdapter
import mx.itson.koala.entidades.Usuario

class UsuarioListActivity : AppCompatActivity() {

    private var listaUsuarios: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_list)

        listaUsuarios = findViewById(R.id.listUsuario)
        cargarLista()
    }

    private fun cargarLista() {
        val usuarios: List<Usuario> = Usuario().obtenerTodos(this)
        val adapter = UsuarioAdapter(this, usuarios)
        listaUsuarios?.adapter = adapter
        registerForContextMenu(listaUsuarios)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.usuario_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val usuarioInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val usuario = listaUsuarios?.getItemAtPosition(usuarioInfo.position) as Usuario
        when (item.itemId) {
            R.id.mnEditar -> {
                val intent = Intent(this, UsuarioFormActivity::class.java)
                intent.putExtra("usuario", usuario)
                startActivity(intent)

                Toast.makeText(this, "Editar el usuario ${usuario.nombre}", Toast.LENGTH_SHORT)
                    .show()
                return true
            }
            R.id.mnEliminar -> {
                Toast.makeText(this, "Eliminar el usuario ${usuario.nombre}", Toast.LENGTH_SHORT)
                    .show()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarLista()
    }
}
