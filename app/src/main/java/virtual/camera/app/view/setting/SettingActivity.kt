package virtual.camera.app.view.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import virtual.camera.app.R
import virtual.camera.app.databinding.ActivitySettingBinding
import virtual.camera.app.view.base.BaseActivity

class SettingActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Acceder al toolbar correctamente
        val toolbar = binding.root.findViewById<MaterialToolbar>(R.id.toolbar)
        initToolbar(toolbar, R.string.setting, true)

        // Cargar fragmento
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, SettingFragment())
            .commit()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SettingActivity::class.java)
            intent.action = Intent.ACTION_OPEN_DOCUMENT
            context.startActivity(intent)
        }
    }
}
