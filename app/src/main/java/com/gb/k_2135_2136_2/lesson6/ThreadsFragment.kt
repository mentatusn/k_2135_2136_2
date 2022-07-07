package com.gb.k_2135_2136_2.lesson6

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.k_2135_2136_2.databinding.FragmentThreadsBinding

class ThreadsFragment : Fragment() {

    private var _binding: FragmentThreadsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThreadsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("@@@","${Thread.currentThread()}")
        binding.button.setOnClickListener {
            Thread{
                Log.d("@@@","${Thread.currentThread()}")
                Thread.sleep(200L)
                Handler(Looper.getMainLooper()).post(Runnable {
                    binding.textView.text= hardWork() // FIXME
                    binding.button.textSize =10f
                })

            }.start()
        }
    }


    private fun hardWork():String{
        Thread.sleep(200L)
        return hardWork2()
    }

    private fun hardWork2():String{
        Thread.sleep(200L)
        return "Получилось"
    }




    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}