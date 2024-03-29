package com.elmoselhy.elfiltardelivery.business.delivery.sheets

import android.content.Context
import android.view.LayoutInflater
import com.elmoselhy.elfiltardelivery.R
import com.elmoselhy.elfiltardelivery.base.BaseActivity
import com.elmoselhy.elfiltardelivery.base.BaseSheetDialog
import com.elmoselhy.elfiltardelivery.databinding.SheetLayoutAddFilterCandleBinding

class AddFilterCandleCount(
    private val mContext: Context,
    private val queryMap: HashMap<String, Any>,
    val onSubmit: () -> Unit,
) : BaseSheetDialog(mContext) {
    var binding: SheetLayoutAddFilterCandleBinding =
        SheetLayoutAddFilterCandleBinding.inflate(LayoutInflater.from(mContext))

    init {
        setContentView(binding.root)
        setUpSheetUi(binding.root.parent)
        setUpActions()
    }

    private fun setUpActions() {
        if ((mContext as BaseActivity).sessionHelper.getUserSession()!!.candles_count != null)
            binding.etCandleNumber.setText("" + (mContext as BaseActivity).sessionHelper.getUserSession()!!.candles_count!!)
        binding.btnSubmit.setOnClickListener {
            if (!binding.etCandleNumber.isValid) {
                binding.etCandleNumber.error = mContext.getString(R.string.error_message_required)
                return@setOnClickListener
            }
            queryMap["candles_count"] = binding.etCandleNumber.text.toString().toInt()
            onSubmit()
            dismiss()
        }
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }
}