package xyz.dokup.samplechatui.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import xyz.dokup.samplechatui.R
import xyz.dokup.samplechatui.adapter.MessageAdapter
import xyz.dokup.samplechatui.constant.MediaType
import xyz.dokup.samplechatui.constant.MessageSender
import xyz.dokup.samplechatui.model.Message
import xyz.dokup.samplechatui.util.RecyclerListener

/**
 * Created by a14775 on 2017/06/20.
 */
class ChatActivity: AppCompatActivity(), View.OnClickListener, RecyclerListener {

    private var customerButton: Button? = null
    private var botButton: Button? = null
    private var messageEdit: EditText? = null
    private var messageRecycler: RecyclerView? = null

    private var messages = ArrayList<Message>()
    private var messageAdapter: MessageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat)

        customerButton = findViewById(R.id.self_btn) as Button
        botButton = findViewById(R.id.other_btn) as Button
        messageEdit = findViewById(R.id.message_edit) as EditText
        messageRecycler = findViewById(R.id.chat_recycler) as RecyclerView

        messageAdapter = MessageAdapter(this, messages, this)
        messageRecycler?.layoutManager = LinearLayoutManager(this)
        messageRecycler?.adapter = messageAdapter

        customerButton?.setOnClickListener(this)
        botButton?.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onClick(v: View?) {
        val body: String = messageEdit?.text.toString()
        when(v?.id) {
            R.id.self_btn -> {
                messages.add(Message(MediaType.PLAIN_TEXT, MessageSender.CUSTOMER, body))
                messageAdapter?.notifyItemInserted(messages.size)
            }
            R.id.other_btn -> {
                messages.add(Message(MediaType.PLAIN_TEXT, MessageSender.OPERATOR, body))
                messageAdapter?.notifyItemInserted(messages.size)
            }
        }
    }

    override fun onItemLongClick(view: View, i: Int, obj: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}