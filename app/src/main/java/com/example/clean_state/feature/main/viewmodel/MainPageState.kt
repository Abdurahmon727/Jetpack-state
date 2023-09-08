import androidx.compose.runtime.Immutable
import com.example.clean_state.core.FormzStatus
import com.example.clean_state.feature.main.data.models.UserModelItem

@Immutable
data class MainPageState(
    val status:FormzStatus=FormzStatus.Pure,
    val errorMessage:String="",
    val data: List<UserModelItem> = listOf()
):UiState