package mx.itson.koala.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.koala.R
import mx.itson.koala.entidades.Usuario

class UsuarioAdapter(
    context: Context?,
    usuarios: List<Usuario>
) : BaseAdapter() {

    var context: Context? = context
    var usuarios: List<Usuario> = usuarios


    override fun getCount(): Int {
        return usuarios.size
    }

    override fun getItem(position: Int): Any {
        return usuarios[position]
    }

    override fun getItemId(position: Int): Long {
        return usuarios[position].id.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val renglon = LayoutInflater.from(context).inflate(R.layout.item_usuario, null)
        try {
            val usuario = getItem(position) as Usuario
            val txtNombre: TextView = renglon.findViewById(R.id.txtNombre)
            val txtTelefono: TextView = renglon.findViewById(R.id.txtTelefono)
            val txtEmail: TextView = renglon.findViewById(R.id.txtEmail)
            txtNombre.text = usuario.nombre
            txtTelefono.text = usuario.telefono
            txtEmail.text = usuario.email

        } catch (ex: Exception) {
            Log.e("ocurrio un error al obtener usuario", ex.toString())
        }
        return renglon
    }
}
