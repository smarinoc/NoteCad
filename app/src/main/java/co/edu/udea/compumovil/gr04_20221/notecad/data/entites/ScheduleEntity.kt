package co.edu.udea.compumovil.gr04_20221.notecad.data.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = CourseEntity::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id_course"),
    onDelete = ForeignKey.CASCADE)],
    tableName = "schedule_table"
)
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "day") val day: Int,
    @ColumnInfo(name = "start_hour") val startHour: String,
    @ColumnInfo(name = "end_hour") val endHour: String,
    @ColumnInfo(name = "id_course") val idCourse: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val color: String,
)
