package com.gb.k_2135_2136_2.view.contentprovider

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.gb.k_2135_2136_2.databinding.FragmentContentProviderBinding
import com.gb.k_2135_2136_2.databinding.FragmentDetailsBinding
import com.gb.k_2135_2136_2.domain.Weather
import com.gb.k_2135_2136_2.viewmodel.details.DetailsFragmentAppState
import com.gb.k_2135_2136_2.viewmodel.details.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*


class ContentProviderFragment : Fragment() {


    private var _binding: FragmentContentProviderBinding? = null
    private val binding: FragmentContentProviderBinding
        get() {
            return _binding!!
        }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentProviderBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    private fun checkPermission(){
        val permResult = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS)
        PackageManager.PERMISSION_GRANTED
        if(permResult== PackageManager.PERMISSION_GRANTED){
            getContacts()
        }
        Log.d("@@@","${permResult}")
    }

    private fun getContacts(){
        val contentResolver: ContentResolver = requireContext().contentResolver
        // Отправляем запрос на получение контактов и получаем ответ в виде Cursor
        val cursorWithContacts: Cursor? = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
