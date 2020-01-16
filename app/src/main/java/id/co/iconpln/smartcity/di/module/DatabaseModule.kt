package id.co.iconpln.smartcity.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import id.co.iconpln.smartcity.data.source.db.AppDatabaseSource
import javax.inject.Singleton

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabaseSource = Room.databaseBuilder(context,
        AppDatabaseSource::class.java, "air_crm_database").allowMainThreadQueries().build()
}