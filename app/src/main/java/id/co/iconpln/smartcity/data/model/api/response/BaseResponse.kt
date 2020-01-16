package id.co.iconpln.smartcity.data.model.api.response

/**
 * rizmaulana@live.com 2019-06-16.
 */
data class BaseResponse<T>(
    val message: String,
    val status: Int,
    val isSuccess: Boolean,
    val data: T
)