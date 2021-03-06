package com.personal.frbk1992.spamsmsdetector.appInfo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.personal.frbk1992.spamsmsdetector.APACHE_LICENSE

import com.personal.frbk1992.spamsmsdetector.R
import kotlinx.android.synthetic.main.fragment_app_info.*
import java.io.IOException


/**
 * A fragment with the information of the app, the licence and giving credits to other people.
 */
class AppInfoFragment : Fragment() {

    //TAG for the logs
    private val TAG = this.javaClass.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //set the information from the TXT
        fragment_app_info_text_view_apache_license.text = getLicenseAsset()
    }

    /**
     * Get the Apache license in a String value
     */
    private fun getLicenseAsset() : String{

        return try {
            val stream = context!!.assets.open(APACHE_LICENSE)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            //return the license
            String(buffer)
        } catch (e : IOException) {
            // Handle exceptions here
            Log.e(TAG, "error reading the apache license")
            throw RuntimeException("Error while reading the license file.")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance ofthe fragment
         *
         * @return A new instance of fragment AppInfoFragment.
         */
        fun newInstance(): AppInfoFragment {
            return AppInfoFragment()
        }
    }


}
