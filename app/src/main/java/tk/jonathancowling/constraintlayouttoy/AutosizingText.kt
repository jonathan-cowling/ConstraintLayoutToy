package tk.jonathancowling.constraintlayouttoy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.autosizing_text.*

class AutosizingText : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.autosizing_text, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val f = try { s.toString().toFloat() } catch(e: Throwable) { 0.5F }

                autosizeTop.setGuidelinePercent(f/2)
                autosizeBottom.setGuidelinePercent(1-f/2)
                autosizeStart.setGuidelinePercent(f/2)
                autosizeEnd.setGuidelinePercent(1-f/2)
            }

        })
    }
}