package com.skbhati.materialbottombar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.materialbottombar.MaterialBottomNavigation
import com.skbhati.materialbottombar.R.*
import com.skbhati.materialbottombar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(
            LayoutInflater.from(
                this
            )
        )

        setContentView(binding.root)

        binding.materialbottombar.apply {

            add(
                MaterialBottomNavigation.Model(
                    ID_HOME,
                    drawable.ic_home
                )
            )
            add(
                MaterialBottomNavigation.Model(
                    ID_EXPLORE,
                    drawable.ic_explore
                )
            )
            add(
                MaterialBottomNavigation.Model(
                    ID_MESSAGE,
                    drawable.ic_message
                )
            )
            add(
                MaterialBottomNavigation.Model(
                    ID_NOTIFICATION,
                    drawable.ic_notification
                )
            )
            add(
                MaterialBottomNavigation.Model(
                    ID_ACCOUNT,
                    drawable.ic_account
                )
            )

            setCount(ID_NOTIFICATION, "115")

            setOnShowListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }

                binding.tvSelected.text = getString(string.main_page_selected, name)
            }

            setOnClickMenuListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }
            }

            setOnReselectListener {
                Toast.makeText(context, "item ${it.id} is reselected.", Toast.LENGTH_LONG).show()
            }

            show(ID_HOME)

        }

//        binding.btShow.setOnClickListener {
//            val id = try {
//                binding.etPageId.text.toString().toInt()
//            } catch (e: Exception) {
//                ID_HOME
//            }
//            if (id in ID_HOME..ID_ACCOUNT)
//                binding.materialbottombar.show(id)
//        }


    }
}