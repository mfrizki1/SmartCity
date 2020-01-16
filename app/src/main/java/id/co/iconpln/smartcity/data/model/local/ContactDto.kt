package id.co.iconpln.smartcity.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * rizmaulana@live.com 2019-06-16.
 */
@Entity
data class ContactDto(@PrimaryKey val id: Long? = null, val token: String? = null)