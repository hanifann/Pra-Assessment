package org.d3if2095.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_fragment_persegi_panjang.*
import org.d3if2095.myapplication.databinding.FragmentFragmentPersegiPanjangBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentPersegiPanjang : Fragment() {

    private lateinit var binding: FragmentFragmentPersegiPanjangBinding
    private val KEY_LUAS = "luas"
    private val KEY_KELILING = "keliling"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_fragment_persegi_panjang,container,false
        )
        if(savedInstanceState != null){
            binding.tvKelP.text = savedInstanceState.getString(KEY_KELILING)
            binding.tvLuasP.text = savedInstanceState.getString(KEY_LUAS)
        }

        binding.btHitung.setOnClickListener {
            if(binding.etLebarP.text.toString() == "" || binding.etPanjangP.text.toString() == ""){
                Toast.makeText(context,"Form Panjang dan lebar harus diisi",Toast.LENGTH_LONG).show()
            }else{
                val panjang:Double
                val lebar: Double
                val kel:Double
                val luas:Double
                panjang = binding.etPanjangP.text.toString().toDouble()
                lebar = binding.etLebarP.text.toString().toDouble()

                luas = (panjang * lebar)
                kel = 2 * (panjang + lebar)

                binding.tvKelP.text = getString(R.string.kelP,kel.toString())
                binding.tvLuasP.text = getString(R.string.luasP,luas.toString())
            }
        }

        binding.btShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,binding.tvLuasP.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,binding.tvKelP.text.toString())
            startActivity(intent)
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY_LUAS,binding.tvLuasP.text.toString())
        outState.putString(KEY_KELILING,binding.tvKelP.text.toString())
        super.onSaveInstanceState(outState)
    }

}
