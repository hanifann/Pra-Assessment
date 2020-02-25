package org.d3if2095.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if2095.myapplication.databinding.FragmentSegitigaBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class segitigaFragment : Fragment() {
    private lateinit var binding: FragmentSegitigaBinding
    private val KEY_LUAS = "luas"
    private val KEY_KEL = "keliling"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_segitiga,container,false
        )

        if(savedInstanceState != null){
            binding.tvKelS.text = savedInstanceState.getString(KEY_KEL)
            binding.tvLuass.text = savedInstanceState.getString(KEY_LUAS)
        }

        binding.btHitungS.setOnClickListener {
            if(binding.etAlas.text.toString() == "" || binding.etTinggi.text.toString() == ""){
                Toast.makeText(context,"Form alas dan tinggi harus diisi",Toast.LENGTH_LONG).show()
            }else{
                val alas: Double
                val tinggi: Double
                alas = binding.etAlas.text.toString().toDouble()
                tinggi = binding.etTinggi.text.toString().toDouble()
                val luas = (alas * tinggi)/2
                val kel = Math.sqrt(Math.pow(alas,2.0) + Math.pow(tinggi,2.0))

                binding.tvKelS.text = getString(R.string.kelP,kel.toString())
                binding.tvLuass.text = getString(R.string.luasP,luas.toString())
            }
        }

        binding.btShare2.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,binding.tvKelS.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,binding.tvLuass.text.toString())
            startActivity(intent)
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_KEL,binding.tvKelS.text.toString())
        outState.putString(KEY_LUAS,binding.tvLuass.text.toString())
    }

}
