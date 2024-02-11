package app.te.network.di

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import te.app.network.BuildConfig
import te.app.storage.Keys
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val REQUEST_TIME_OUT: Long = 60

    @Provides
    @Singleton
    fun provideHeadersInterceptor() = run {

        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer")
                    .addHeader("Accept", "application/json")
                    .addHeader("lang", Locale.getDefault().language)
                    .build()
            )
        }
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headersInterceptor: Interceptor,
        logging: HttpLoggingInterceptor,
        @ApplicationContext context: Context
    ): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(headersInterceptor)
                .addNetworkInterceptor(logging)
                .addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .collector(ChuckerCollector(context))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                ).build()
        } else {
            OkHttpClient.Builder()
                .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(headersInterceptor).build()
        }
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
//      .serializeNulls() // To allow sending null values
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Keys.baseUrl())
        .build()

}