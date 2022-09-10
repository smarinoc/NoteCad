package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import android.app.TimePickerDialog
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun TimePicker(
    mTime: MutableState<String>,
    placeholder: String
) {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        { mCalendar, mHour: Int, mMinute: Int ->
            var hour: String = mHour.toString()
            var minute: String = mMinute.toString()
            if (mHour < 10){
                hour="0$mHour"
            }
            if (mMinute < 10){
                minute="0$minute"
            }
            mTime.value = "$hour:$minute"
        }, mHour, mMinute, false
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .border(
                1.dp,
                MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                RoundedCornerShape(10)
            )
            .clickable { mTimePickerDialog.show() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Rounded.DateRange, contentDescription = "DateRange")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.width(100.dp),
                text = placeholder,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = mTime.value,
            )
        }
    }

}