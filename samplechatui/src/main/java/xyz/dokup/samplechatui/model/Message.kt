package xyz.dokup.samplechatui.model

import xyz.dokup.samplechatui.constant.MediaType
import xyz.dokup.samplechatui.constant.MessageSender



/**
 * Created by a14775 on 2017/06/20.
 */
class Message(mediaType: MediaType, messageSender: MessageSender, body: String) {

    var mediaType: MediaType = mediaType
    var messageSender: MessageSender = messageSender
    var body: String = body
    
}