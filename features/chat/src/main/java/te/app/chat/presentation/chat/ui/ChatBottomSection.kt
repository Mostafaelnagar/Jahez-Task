package te.app.chat.presentation.chat.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.te.core.theme.AppArchitectureTheme
import te.app.chat.R
import te.app.chat.presentation.chat.events.ChatRoomEvent

@Composable
fun ChatBottomSection(
    message: String = "",
    onEvent: (event: ChatRoomEvent) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.large
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = { onEvent(ChatRoomEvent.MessageBoxChanged(it)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default
            ),
            modifier = Modifier
                .weight(1f),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.type_message_hint),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.outline,
                    )
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = MaterialTheme.colorScheme.background,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.background
            ),
        )
        IconButton(
            onClick = { onEvent(ChatRoomEvent.SendMessage) },
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_send),
                contentDescription = "Back Arrow"
            )
        }

    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun ChatBottomSectionPreview() {
    AppArchitectureTheme {
        ChatBottomSection()
    }
}