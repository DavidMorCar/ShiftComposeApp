package com.shiftkey.codingchallenge.injection

import com.shiftkey.codingchallenge.domain.repository.BaseShiftRepository
import com.shiftkey.codingchallenge.domain.repository.ShiftRepository
import com.shiftkey.codingchallenge.domain.usecase.GetShiftListCase
import com.shiftkey.codingchallenge.domain.usecase.ShiftUseCase
import com.shiftkey.codingchallenge.domain.util.BASE_URL
import com.shiftkey.codingchallenge.service.ShiftAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** Application dependency injection */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Provide the Retrofit builder instance injection */
    @Provides
    @Singleton
    fun provideRetrofitService(): ShiftAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShiftAPI::class.java)
    }

    /** Provide the ShiftRepository instance injection */
    @Provides
    @Singleton
    fun provideShiftRepository(shiftAPI: ShiftAPI): BaseShiftRepository {
        return ShiftRepository(shiftAPI = shiftAPI)
    }

    /** Provide the ShiftUseCase instance injection */
    @Provides
    @Singleton
    fun provideAlbumListUseCase(repository: BaseShiftRepository): ShiftUseCase {
        return ShiftUseCase(
            getShiftList = GetShiftListCase(repository = repository)
        )
    }
}