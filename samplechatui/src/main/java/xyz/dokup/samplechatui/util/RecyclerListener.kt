package xyz.dokup.samplechatui.util

import android.view.View

/**
 * Created by a14775 on 2017/06/20.
 */
interface RecyclerListener {
    
    fun onItemLongClick(view: View, i: Int, obj: Any)
}