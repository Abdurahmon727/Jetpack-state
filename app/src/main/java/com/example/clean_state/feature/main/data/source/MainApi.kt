import com.example.clean_state.feature.main.data.models.UserModelItem
import retrofit2.Response
import retrofit2.http.GET


interface MainPageApi{
    @GET("/users")
    suspend fun getUsers():Response<List<UserModelItem>>
}