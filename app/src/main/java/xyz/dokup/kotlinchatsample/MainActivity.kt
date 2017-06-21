package xyz.dokup.kotlinchatsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import xyz.dokup.samplechatui.ui.ChatActivity
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        findViewById(R.id.jump_btn)?.setOnClickListener({v -> startActivity(ChatActivity::class)})
    }

    fun <T: Activity> Activity.startActivity(classRef: KClass<T>, bundle: Bundle? = null) {
        val intent = Intent(this, classRef.java).setAction(Intent.ACTION_VIEW)
        bundle?.let {
            intent.putExtra("args", bundle)
        }
        startActivity(intent)
    }
}
