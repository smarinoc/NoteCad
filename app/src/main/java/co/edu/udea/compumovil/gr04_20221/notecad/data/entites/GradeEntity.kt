package co.edu.udea.compumovil.gr04_20221.notecad.data.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = CourseEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id_course"),
    onDelete = ForeignKey.CASCADE)],
    tableName = "grade_table"
)
data class GradeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "grade") val grade: Double,
    @ColumnInfo(name = "percentage") val percentage: Double,
    @ColumnInfo(name = "id_course") val id_course: Int,
)
