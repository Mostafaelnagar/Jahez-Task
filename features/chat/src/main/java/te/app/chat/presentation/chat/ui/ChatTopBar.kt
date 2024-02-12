package te.app.chat.presentation.chat.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.te.core.theme.AppArchitectureTheme
import te.app.chat.R

@Composable
fun ChatTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier.border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.large
            )
        ) {
            Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Back Arrow")
        }
        Text(text = "Mohamed", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        IconButton(
            onClick = { },
            modifier = Modifier.border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.large
            )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_phone),
                contentDescription = "Back Arrow"
            )
        }

    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun ChatTopBarPreview() {
    AppArchitectureTheme {
        ChatTopBar()
    }
}
