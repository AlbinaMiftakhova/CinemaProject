package com.mythesisapp.cinemaproject.ui.user

import android.os.Bundle
import android.view.View
import com.mythesisapp.cinemaproject.R
import com.mythesisapp.cinemaproject.remote.service.ApiService
import com.mythesisapp.cinemaproject.ui.core.BaseFragment
import com.mythesisapp.cinemaproject.ui.core.GlideHelper
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_user

    override val titleToolbar = R.string.screen_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        base {
            val args = intent.getBundleExtra("args")
            if (args != null) {
                val image = args.getString(ApiService.PARAM_IMAGE)
                val name = args.getString(ApiService.PARAM_NAME)
                val email = args.getString(ApiService.PARAM_EMAIL)
                val surname = args.getString(ApiService.PARAM_SURNAME)
                val birthday = args.getString(ApiService.PARAM_BIRTHDAY)
                val city = args.getString(ApiService.PARAM_CITY)
                val id = args.getLong(ApiService.PARAM_CONTACT_ID)

                GlideHelper.loadImage(requireContext(), image, imgPhoto, R.drawable.ic_account_circle)

                tvName.text = name
                tvEmail.text = email
                tvSurname.text= surname
                tvBirthday.text= birthday
                tvCity.text= city

                imgPhoto.setOnClickListener {
                    navigator.showImageDialog(requireContext(), imgPhoto.drawable)
                }

                btnSendMessage.setOnClickListener {
                    navigator.showChatWithContact(id, name, requireContext())
                }
            }
        }
    }
}