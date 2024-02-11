package app.te.core.utils

import android.app.Activity
import androidx.compose.runtime.Composable
import app.te.core.R
import app.te.core.custom_views.alert.AlerterError
import app.te.network.utils.FailureStatus
import app.te.network.utils.Resource

@Composable
fun HandleApiError(
    activity: Activity,
    failure: Resource.Failure,
) {
    when (failure.failureStatus) {
        FailureStatus.EMPTY -> {
            failure.message?.let {
                    AlerterError(message = it)
            }
        }

        FailureStatus.NO_INTERNET -> {
            AlerterError(message = activity.getString(R.string.no_internet), icon = R.raw.wifi)
        }

        FailureStatus.TOKEN_EXPIRED -> {

        }

        else -> {
            AlerterError(message = activity.getString(R.string.some_error))
        }
    }
}
