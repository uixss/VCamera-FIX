package virtual.camera.app.view.apps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import virtual.camera.app.data.AppsRepository

/**
 *
 * @Description:
 * @Author: wukaicheng
 * @CreateDate: 2021/4/29 22:36
 */
@Suppress("UNCHECKED_CAST")
class AppsFactory(private val appsRepository: AppsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppsViewModel::class.java)) {
            return AppsViewModel(appsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
