



sealed interface ResultData<T> {
    class Success<T>(val data: T) : ResultData<T>
    class Fail<T>(val throwable: Throwable) : ResultData<T>

    class Loading<T>() : ResultData<T>
    class Message<T>(val message: String? = null, val messageId: Int? = null) : ResultData<T>
}

fun <T> ResultData.Message<T>.toMessage() = Message(message, messageId)

