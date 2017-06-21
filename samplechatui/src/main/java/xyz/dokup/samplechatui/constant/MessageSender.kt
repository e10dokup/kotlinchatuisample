package xyz.dokup.samplechatui.constant

/**
 * Created by a14775 on 2017/06/20.
 */
enum class MessageSender private constructor(val viewType: Int) {

    CUSTOMER(0),
    BOT(1),
    OPERATOR(1)
}
