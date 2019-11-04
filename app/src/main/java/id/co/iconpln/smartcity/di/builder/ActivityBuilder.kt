package id.co.iconpln.smartcity.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.co.iconpln.smartcity.ui.login.LoginActivity
import id.co.iconpln.smartcity.ui.login.LoginActivityModule
import id.co.iconpln.smartcity.ui.splash.SplashActivity
import id.co.iconpln.smartcity.ui.splash.SplashActivityModule

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

}