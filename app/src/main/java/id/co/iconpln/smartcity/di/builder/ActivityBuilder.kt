package id.co.iconpln.smartcity.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.co.iconpln.smartcity.ui.kota.KotaActivity
import id.co.iconpln.smartcity.ui.kota.KotaActivityModule
import id.co.iconpln.smartcity.ui.login.LoginActivity
import id.co.iconpln.smartcity.ui.login.LoginActivityModule
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivity
import id.co.iconpln.smartcity.ui.provinsi.ProvinsiActivityModule
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

    @ContributesAndroidInjector(modules = [ProvinsiActivityModule::class])
    abstract fun bindProvinceActivty(): ProvinsiActivity

    @ContributesAndroidInjector(modules = [KotaActivityModule::class])
    abstract fun bindCityActivty(): KotaActivity

}