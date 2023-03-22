package mx.itson.koala

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAgregar = findViewById<View>(R.id.btnAgregar)
        btnAgregar.setOnClickListener(this)

        val btnListar = findViewById<View>(R.id.btnListar)
        btnListar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAgregar -> {
                val intent = Intent(this, UsuarioFormActivity::class.java)
                startActivity(intent)
            }

            R.id.btnListar -> {
                val intent = Intent(this, UsuarioListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
