package id.co.iconpln.smartcity.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import id.co.iconpln.smartcity.AppController
import id.co.iconpln.smartcity.di.builder.ActivityBuilder
import id.co.iconpln.smartcity.di.module.*
import javax.inject.Singleton

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Singleton
@Component(modules = [NetworkModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    AppModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
    PrefModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AppController)
}