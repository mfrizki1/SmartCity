package id.co.iconpln.smartcity.data.model.local

data class DataPengaduanDto(
    val id_pengaduan: Int,
    val city_id: String,
    val jenis_pengaduan: String,
    val month_id: Int,
    val year: Int,
    val progress_type: String,
    val kode: String,
    val values: String,
    val name: String,
    val deleted: String,
    val created_date: Int,
    val modified_date: Int,
    val sum: Int
)