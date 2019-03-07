package tk.jonathancowling.constraintlayouttoy


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.home_fragment.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.button.setOnClickListener {  }
        view.button2.setOnClickListener { launch(ChainsExample()) }
        view.button3.setOnClickListener {  }
        view.button4.setOnClickListener { launch(SimpleExample()) }
        view.button5.setOnClickListener { launch(GuidelinesExample()) }
        view.button6.setOnClickListener { launch(BarrierExample()) }
        view.button7.setOnClickListener {  }
    }

    private fun launch(frag: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, frag)?.commit()
    }


}
