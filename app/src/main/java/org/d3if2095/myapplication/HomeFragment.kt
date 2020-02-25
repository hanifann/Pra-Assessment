package org.d3if2095.myapplication


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if2095.myapplication.databinding.FragmentHomeBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,R.layout.fragment_home,container,false
        )

        binding.btPersegiPanjang.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_fragmentPersegiPanjang)
        )
        binding.btSegitiga.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_segitigaFragment)
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController()) ||
        super.onOptionsItemSelected(item)
    }
}
