import com.example.clean_state.feature.main.data.repository.MainPageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @[Provides Singleton]
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .build()


    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    }

    @[Provides Singleton]
    fun provideHomeApi(retrofit: Retrofit): MainPageApi {
        return retrofit.create(MainPageApi::class.java)
    }

    @[Provides Singleton]
    fun provideMainRepo(mainPageApi: MainPageApi ):MainPageRepository{
        return  MainPageRepositoryImpl(
            mainPageApi
        )
    }


}