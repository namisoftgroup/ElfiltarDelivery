package com.elmoselhy.elfiltardelivery.business.general.activities

import android.view.View
import androidx.activity.viewModels
import com.elmoselhy.elfiltardelivery.R
import com.elmoselhy.elfiltardelivery.base.BaseActivity
import com.elmoselhy.elfiltardelivery.business.viewmodels.AppViewModel
import com.elmoselhy.elfiltardelivery.commons.customcomponent.editText.normal.BaseInput
import com.elmoselhy.elfiltardelivery.commons.customcomponent.editText.normal.helper.ElmoselhyInputHelper
import com.elmoselhy.elfiltardelivery.commons.helpers.MyUtils
import com.elmoselhy.elfiltardelivery.databinding.ActivityContactUsBinding
import www.sanju.motiontoast.MotionToast

class ContactUsActivity : BaseActivity() {

    //declare properties
    lateinit var binding: ActivityContactUsBinding
    private val appViewModel: AppViewModel by viewModels()
    val map = HashMap<String, Any>()
    override fun setUpLayoutView(): View {
        binding = ActivityContactUsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        setUpPageActions()
    }

    private fun setUpPageActions() {
        binding.appBar.tvPageTitle.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.btnSend.setOnClickListener {
            if (ElmoselhyInputHelper.checkIfInputsIsValid(this, getInputsUiList())) {
                contactUs()
            }
        }
    }

    private fun contactUs() {
        map["message"] = binding.etMessage.text.toString()
        map["address"] = binding.etAddress.text.toString()
        map["phone"] = binding.etPhone.text.toString()
        map["name"] = binding.etName.text.toString()
        appViewModel.contactUs(map, onResult = {
            MyUtils.shoMsg(this,getString(R.string.success),MotionToast.TOAST_SUCCESS)
            finish()
        })
    }

    private fun getInputsUiList(): ArrayList<BaseInput> {
        var inputsList = ArrayList<BaseInput>()
        inputsList.add(binding.etName)
        inputsList.add(binding.etPhone)
        inputsList.add(binding.etAddress)
        inputsList.add(binding.etMessage)
        return inputsList
    }
}