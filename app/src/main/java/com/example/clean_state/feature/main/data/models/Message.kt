import android.content.Context

data class Message(val message : String? = null,val messageResId : Int? = null)


fun Context.show(message : Message) : String{
    return message.message ?: getString(message.messageResId!!)
}