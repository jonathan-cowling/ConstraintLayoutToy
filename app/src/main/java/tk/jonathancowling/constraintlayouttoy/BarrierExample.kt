package tk.jonathancowling.constraintlayouttoy


import android.graphics.Point
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.barrier_fragment.view.*

class BarrierExample : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.barrier_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val outSize = Point()
                activity?.windowManager?.defaultDisplay?.getSize(outSize)
                view.imageView2.apply {
                    layoutParams = layoutParams.apply { width = lerp(progress.toDouble(), 0.0, 100.0, 0.0, outSize.x - 56.0).toInt() }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        view.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val outSize = Point()
                activity?.windowManager?.defaultDisplay?.getSize(outSize)
                view.imageView3.apply {
                    layoutParams = layoutParams.apply { width = lerp(progress.toDouble(), 0.0, 100.0, 0.0, outSize.x - 56.0).toInt() }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }

    private fun lerp(v: Double, a1: Double, b1: Double, a2: Double, b2: Double) = (((v - a1) * (b2 - a2)) / (b1 - a1)) + a2


}
