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
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gb.k_2135_2136_2.databinding.FragmentContentProviderBinding


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

    private fun checkPermission() {
        val permResult =
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS)
        PackageManager.PERMISSION_GRANTED
        if (permResult == PackageManager.PERMISSION_GRANTED) {
            getContacts()
        } else if(shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)){
            AlertDialog.Builder(requireContext())
                .setTitle("Доступ к контактам")
                .setMessage("Объяснение Объяснение Объяснение Объяснение")
                .setPositiveButton("Предоставить доступ") { _, _ ->
                    permissionRequest(Manifest.permission.READ_CONTACTS)
                }
                .setNegativeButton("Не надо") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        } else {
            permissionRequest(Manifest.permission.READ_CONTACTS)
        }

    }

    private fun permissionRequest(permission: String) {
        requestPermissions(arrayOf(permission), REQUEST_CODE_READ_CONTACTS)
    }

    private val REQUEST_CODE_READ_CONTACTS = 999

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_READ_CONTACTS) {
            for (pIndex in permissions.indices) {
                if (permissions[pIndex] == Manifest.permission.READ_CONTACTS
                    && grantResults[pIndex] == PackageManager.PERMISSION_GRANTED
                ) {
                    getContacts()
                    Log.d("@@@", "Ура")
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun getContacts() {
        val contentResolver: ContentResolver = requireContext().contentResolver
        // Отправляем запрос на получение контактов и получаем ответ в виде Cursor
        val cursorWithContacts: Cursor? = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        )
        cursorWithContacts?.let { cursor->
            for(i in 0 until cursor.count){ // аналог 0..cursorWithContacts.count-1
                cursor.moveToPosition(i)
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                binding.containerForContacts.addView(TextView(requireContext()).apply {
                    text = name
                    textSize = 25f
                })
            }
        }
        cursorWithContacts?.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
