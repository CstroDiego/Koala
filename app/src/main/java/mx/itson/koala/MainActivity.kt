package mx.itson.koala

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //agregar a pedro hernandez



    fun agregar(view: View) {
        val intent = Intent(this, UsuarioFormActivity::class.java)
        startActivity(intent)
    }


}
