package tads.eaj.ufrn.exemploarmazenamentointerno

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.FileInputStream
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException
import android.widget.Toast
import android.view.View
import java.io.FileOutputStream
import android.util.Log


class MainActivity : AppCompatActivity() {

    var FILENAME = "hello_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun readFile() {
        // Read File and Content
        val fin: FileInputStream
        try {
            //abre o arquivo chamado FILENAME para LEITURA
            fin = openFileInput(FILENAME)
            var letra: Int
            var newText = ""

            // read inside if it is not null (-1 means empty)
            letra = fin.read()
            while (letra != -1) {
                // add & append content
                newText += letra.toChar().toString()
                letra = fin.read()
            }
            editText.setText(newText)
            fin.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun salvarTextoClick(v: View) {
        //Write file and content
        val fos: FileOutputStream

        try {
            //abre o arquivo chamado FILENAME para ESCRITA
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE)
            fos.write(editText.text.toString().toByteArray())
            fos.close()
            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readFileClick(v: View) {
        // Read File and Content
        val fin: FileInputStream
        try {
            //abre o arquivo chamado FILENAME para LEITURA
            fin = openFileInput(FILENAME)
            var letra: Int
            var newText = ""

            // le enquanto é possível
            letra = fin.read()
            while (letra!= -1) {
                Log.i("Leu", "" + letra.toChar())
                // add & append content
                newText += Character.toString(letra.toChar())
                letra = fin.read()
            }

            Toast.makeText(this, newText, Toast.LENGTH_SHORT).show()
            fin.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
