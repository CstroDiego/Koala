package mx.itson.koala.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import mx.itson.koala.entidades.Usuario

class UsuarioAdapter(
    context: Context?,
    usuarios: List<Usuario>
) : BaseAdapter() {

    var context: Context? = context
    var usuarios: List<Usuario> = usuarios


    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}
