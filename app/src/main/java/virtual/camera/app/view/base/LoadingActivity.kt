package virtual.camera.app.view.base

import android.app.ProgressDialog

abstract class LoadingActivity : BaseActivity() {

    private var progressDialog: ProgressDialog? = null

    fun showLoading() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this).apply {
                setMessage("Cargando...")
                setCancelable(false)
            }
        }
        progressDialog?.show()
    }

    fun hideLoading() {
        progressDialog?.dismiss()
    }
}
