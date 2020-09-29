package com.example.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.myapplication.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    //Too check if casting is done


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
        //declaration of the button =
        val castButton: Button = root.findViewById(R.id.btnCasting)

        castButton.setOnClickListener(){
            //startActivityForResult( Intent(android.provider.Settings.ACTION_SETTINGS), 0)
            SweetAlertDialog(this.context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Casting ?")
                .setContentText("Casting is screen sharing.You can switch it on in settings ")
                .setConfirmText("cast!")
                .setConfirmClickListener {
                        sDialog -> sDialog.dismissWithAnimation()
                        startActivity(Intent(Settings.ACTION_CAST_SETTINGS))
                }
                .setCancelButton(
                    "Cancel"
                ) { sDialog -> sDialog.dismissWithAnimation() }
                .show()


           // startActivity(Intent(Settings.ACTION_CAST_SETTINGS))
            //startActivityForResult(Intent (getActivity(), android.provider.Settings.ACTION_SETTINGS))

        }

       /*homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.t= it
        })*/
        return root
    }
}