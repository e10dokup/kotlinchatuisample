package xyz.dokup.samplechatui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import xyz.dokup.samplechatui.R
import xyz.dokup.samplechatui.model.Message
import xyz.dokup.samplechatui.util.RecyclerListener




/**
 * Created by a14775 on 2017/06/20.
 */
class MessageAdapter(context: Context, messages: List<Message>, listener: RecyclerListener): RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var messages: List<Message> = messages
    private val context: Context = context
    private val listener: RecyclerListener = listener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MessageAdapter.ViewHolder {
        // 表示するレイアウトを設定
        if (i == 0) {
            return ViewHolder(inflater.inflate(R.layout.item_customer, viewGroup, false))
        } else {
            return ViewHolder(inflater.inflate(R.layout.item_bot_operator, viewGroup, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder ?: return
        holder.bodyTextView.text = messages[position].body
        holder.bodyTextView.setOnLongClickListener({ 
            listener.onItemLongClick(holder.itemView, position, messages[position]); true 
        })
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        return messages[position].messageSender.viewType
    }

    // ViewHolder(固有ならインナークラスでOK)
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var bodyTextView: TextView = itemView.findViewById(R.id.body_text) as TextView

    }
}