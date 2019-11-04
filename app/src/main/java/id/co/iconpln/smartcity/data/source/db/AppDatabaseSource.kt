package id.co.iconpln.smartcity.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.co.iconpln.smartcity.data.model.local.ContactDto
import id.co.iconpln.smartcity.data.source.db.dao.ContactDao
import id.co.iconpln.smartcity.util.Constant

/**
 * rizmaulana@live.com 2019-06-14.
 */
@Database(entities = [ContactDto::class], version = Constant.DB_VERSION)
abstract class AppDatabaseSource : RoomDatabase(){

    abstract fun contactDao() : ContactDao

}