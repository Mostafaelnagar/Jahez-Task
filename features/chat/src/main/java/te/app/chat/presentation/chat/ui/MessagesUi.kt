package te.app.chat.presentation.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import app.te.core.theme.AppArchitectureTheme
import te.app.chat.domain.entity.MessageItem
import kotlinx.collections.immutable.*
import kotlinx.coroutines.launch
import te.app.chat.R
import te.app.chat.domain.utils.SenderType
import kotlin.random.Random

@Composable
fun MessagesUi(
    modifier: Modifier = Modifier,
    messages: ImmutableList<MessageItem>
) {
    val scope = rememberCoroutineScope()
    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = state,
    ) {
        scope.launch {
            state.scrollToItem(messages.lastIndex)
        }
        items(messages, key = { it.messageId ?: Random.nextInt() }) { item ->
            MessageItemUi(item)
        }
    }
}

@Composable
fun MessageItemUi(messageItem: MessageItem) {
    val direction =
        if (messageItem.senderType == SenderType.SENDER.type) LayoutDirection.Rtl else LayoutDirection.Ltr
    CompositionLocalProvider(LocalLayoutDirection provides direction) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val (userAvatar, messageTime, message) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.reciever_avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .constrainAs(userAvatar) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .clip(CircleShape)
                    .size(40.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(text = "12.30 PM",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                ),
                modifier = Modifier.constrainAs(messageTime) {
                    start.linkTo(userAvatar.start)
                    end.linkTo(userAvatar.end)
                    top.linkTo(userAvatar.bottom, 4.dp)
                })

            val messageModifier = Modifier.constrainAs(message) {
                start.linkTo(userAvatar.end, 13.dp)
                top.linkTo(userAvatar.top, 2.dp)
                end.linkTo(parent.end, 10.dp)
                width = Dimension.fillToConstraints
            }

            if (direction == LayoutDirection.Ltr)
                ReceiverMessageUi(message = messageItem.message, modifier = messageModifier)
            else
                SenderMessageUi(
                    message = messageItem.message,
                    modifier = messageModifier
                )

        }
    }

}

@Composable
fun SenderMessageUi(modifier: Modifier = Modifier, message: String) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 0f,
                        topEnd = 35f,
                        bottomStart = 35f,
                        bottomEnd = 35f
                    )
                )
                .background(MaterialTheme.colorScheme.secondary)
                .padding(10.dp)
        ) {
            Text(text = message, color = MaterialTheme.colorScheme.onBackground)
        }
    }

}

@Composable
fun ReceiverMessageUi(modifier: Modifier = Modifier, message: String) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 0f,
                        topEnd = 35f,
                        bottomStart = 35f,
                        bottomEnd = 35f
                    )
                )
                .background(MaterialTheme.colorScheme.primary)
                .padding(10.dp)
        ) {
            Text(text = message, color = MaterialTheme.colorScheme.background)
        }
    }
}


@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
fun MessagesPreview() {
    AppArchitectureTheme {
        MessagesUi(messages = mutableListOf<MessageItem>().apply {
            add(
                MessageItem(
                    messageId = 1,
                    message = "senectussenectussenectussenectussenectussenectussenectus",
                    senderType = SenderType.SENDER.type
                )
            )
            add(
                MessageItem(
                    messageId = 2,
                    message = "senectus",
                    senderType = SenderType.RECEIVER.type
                )
            )
            add(
                MessageItem(
                    messageId = 3,
                    message = "senectus",
                    senderType = SenderType.SENDER.type
                )
            )
            add(
                MessageItem(
                    messageId = 4,
                    message = "senectussenectussenectussenectussenectussenectussenectus",
                    senderType = SenderType.RECEIVER.type
                )
            )
        }.toImmutableList())
    }
}