package learnprogramming.academy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var userInput: EditText? = null
    private var addButton: Button? = null
    private var removeButton: Button? = null
    private var clearButton: Button? = null
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<EditText>(R.id.userInput).also { userInput = it }
        findViewById<Button>(R.id.addButton).also { addButton = it }
        findViewById<Button>(R.id.removeButton).also { removeButton = it }
        findViewById<Button>(R.id.clearButton).also { clearButton = it }
        findViewById<TextView>(R.id.show).also { textView = it }
        textView?.movementMethod = ScrollingMovementMethod()


        addButton?.setOnClickListener {
            if (userInput?.text.toString().isNotEmpty()) {
                if (textView?.text.toString().isNotEmpty()) {
                    textView?.append("\n")
                }
                textView?.append(userInput?.text)
            }
            userInput?.setText("")
        }

        removeButton?.setOnClickListener {
            if (textView?.text.toString().isNotEmpty()){
                var items = textView?.text
                items = items?.substring(0, items.length - 1)
                textView?.text = items
            }
        }

        clearButton?.setOnClickListener { textView?.text = "" }
    }
}