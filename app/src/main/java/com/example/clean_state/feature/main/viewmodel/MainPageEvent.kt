import androidx.compose.runtime.Immutable

@Immutable
sealed class MainPageEvent: UiEvent{
    object LoadData : MainPageEvent()
}