package virtual.camera.app.widget

import android.content.Context
import android.view.View
import virtual.camera.app.R
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.interfaces.OnInvokeView

typealias LocationListener = (angle: Float, distance: Float) -> Unit

object EnFloatView {

    private const val FLOAT_TAG = "rocker_float"
    private var mListener: LocationListener? = null

    fun show(context: Context, listener: LocationListener?) {
        mListener = listener

        EasyFloat.with(context)
            .setLayout(R.layout.view_float_rocker, object : OnInvokeView {
                override fun invoke(view: View) {
                    val rockerView = view.findViewById<RockerView>(R.id.rocker)
                    rockerView?.setListener { type, angle, distance ->
                        if (type == RockerView.EVENT_CLOCK && angle != -1f) {
                            val realAngle = angle
                            val realDistance = distance * 0.001f
                            mListener?.invoke(realAngle, realDistance)
                        }
                    }
                }
            })
            .setDragEnable(true)
            .setShowPattern(ShowPattern.FOREGROUND)
            .setTag(FLOAT_TAG)
            .show()
    }

    fun dismiss() {
        EasyFloat.dismiss(FLOAT_TAG)
    }
}
