package com.aminography.primedatepicker.picker.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.aminography.primedatepicker.R
import com.aminography.primedatepicker.common.OnDayPickedListener
import com.aminography.primedatepicker.common.PickType
import com.aminography.primedatepicker.picker.PrimeDatePicker
import com.aminography.primedatepicker.picker.PrimeDatePickerImpl
import com.aminography.primedatepicker.picker.base.BaseDialogFragment
import com.aminography.primedatepicker.picker.callback.BaseDayPickCallback

/**
 * `PrimeDatePickerBottomSheet` contains the logic of picking days in a dialog view.
 *
 * @author aminography
 */
internal class PrimeDatePickerDialog : BaseDialogFragment(
    R.layout.fragment_date_picker_dialog
), PrimeDatePicker {

    private val primeDatePicker: PrimeDatePickerImpl = PrimeDatePickerImpl { dismiss() }

    override val pickType: PickType
        get() = primeDatePicker.pickType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        primeDatePicker.onCreate(requireContext(), lifecycleScope)
    }

    override fun onInitViews(rootView: View) {
        primeDatePicker.onInitViews(rootView, arguments)
    }

    override fun onResume() {
        super.onResume()
        primeDatePicker.onResume()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        primeDatePicker.onCancel(dialog)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        primeDatePicker.onDismiss(dialog)
    }

    override fun setOnCancelListener(listener: DialogInterface.OnCancelListener?) {
        primeDatePicker.setOnCancelListener(listener)
    }

    override fun setOnDismissListener(listener: DialogInterface.OnDismissListener?) {
        primeDatePicker.setOnDismissListener(listener)
    }

    override fun setDayPickCallback(callback: BaseDayPickCallback?) {
        primeDatePicker.setDayPickCallback(callback)
    }

    override fun setOnEachDayPickedListener(listener: OnDayPickedListener?) {
        primeDatePicker.setOnEachDayPickedListener(listener)
    }

}
