package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMenuSatuBinding
import kotlinx.android.synthetic.main.fragment_menu_satu.*

/**
 * A simple [Fragment] subclass.
 */
class MenuSatuFragment : Fragment() {

    private lateinit var binding: FragmentMenuSatuBinding
    private var jumlah = 0
    private var harga = 0
    private val KEY_HARGA = "jml"
    private val KEY_NAMA = "nama"
    private val KEY_RASA = "rasa"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_menu_satu,container,false
        )

        if(savedInstanceState != null){
            binding.tvNama.text = savedInstanceState.getString(KEY_NAMA)
            binding.tvNamaKue.text = savedInstanceState.getString(KEY_RASA)
            binding.tvHargaKue.text = savedInstanceState.getString(KEY_HARGA)
        }
        binding.btTambah.setOnClickListener {

            jumlah += 1
            binding.tvJumlah.text = jumlah.toString()
        }

        binding.btKurang.setOnClickListener {
            if(jumlah <= 0){
                Toast.makeText(context,"Jumlah tidak bisa kurang dari nol",Toast.LENGTH_SHORT).show()
            }else{
                jumlah += -1
                binding.tvJumlah.text = jumlah.toString()
            }
        }

        binding.btBeli.setOnClickListener {
            if(binding.etNama.text.toString() == ""){
                Toast.makeText(context,"Nama tidak boleh kosong",Toast.LENGTH_SHORT).show()
            }else{
                binding.tvNama.text = binding.etNama.text.toString()
            }


            if(rbCokelat.isChecked){
                binding.tvNamaKue.text = getString(R.string.namaKue,binding.rbCokelat.text.toString())

            }else if(rbStrawberry.isChecked){
                binding.tvNamaKue.text = getString(R.string.namaKue,binding.rbStrawberry.text.toString())
            }

            when {
                cbCeres.isChecked -> {
                    harga = binding.tvJumlah.text.toString().toInt() * 6000
                    binding.tvHargaKue.text = getString(R.string.pembeli,harga.toString())
                }
                cbIceCream.isChecked -> {
                    harga = binding.tvJumlah.text.toString().toInt() * 7000
                    binding.tvHargaKue.text = getString(R.string.pembeli,harga.toString())
                }
                cbIceCream.isChecked && cbCeres.isChecked ->{
                    harga = binding.tvJumlah.text.toString().toInt() * 8000
                    binding.tvHargaKue.text = getString(R.string.pembeli,harga.toString())
                }
                else -> {
                    harga = binding.tvJumlah.text.toString().toInt() * 5000
                    binding.tvHargaKue.text = getString(R.string.pembeli,harga.toString())
                }
            }
        }

        binding.btReset.setOnClickListener{
            binding.tvJumlah.text = "0"
            binding.radioGroup.clearCheck()
            binding.etNama.text = null
        }

        return binding.root
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY_NAMA,binding.tvNama.text.toString())
        outState.putString(KEY_HARGA,binding.tvHargaKue.text.toString())
        outState.putString(KEY_RASA,binding.tvNamaKue.text.toString())
        super.onSaveInstanceState(outState)
    }
}