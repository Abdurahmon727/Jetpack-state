import com.example.clean_state.feature.main.data.models.UserModelItem
import com.example.clean_state.feature.main.data.repository.MainPageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainPageRepositoryImpl @Inject constructor(private val mainPageApi: MainPageApi): MainPageRepository {

    override fun getUsers(): Flow<ResultData<List<UserModelItem>>> {
        return flow {
            val response = mainPageApi.getUsers()
            if (response.isSuccessful) {
                emit(ResultData.Success(response.body()!! as List<UserModelItem>))
            } else {
                emit(ResultData.Message(message = "connection error"))
            }
        }.catch {
            emit(ResultData.Fail(it))
        }.flowOn(Dispatchers.IO)
    }
}