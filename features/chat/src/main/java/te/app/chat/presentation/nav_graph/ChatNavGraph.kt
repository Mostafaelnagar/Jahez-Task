package te.app.chat.presentation.nav_graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import app.te.chat.ChatNav
import app.te.core.utils.enterTransition
import app.te.core.utils.exitTransition
import app.te.core.utils.popEnterTransition
import app.te.core.utils.popExitTransition
import app.te.navigation.ChatGraph
import te.app.chat.presentation.chat.ChatRoomScreen
import te.app.chat.presentation.chat.view_model.ChatRoomViewModel

fun NavGraphBuilder.chatNavGraph() {
    navigation(
        route = ChatGraph().destination,
        startDestination = ChatNav().destination
    ) {
        composable(
            ChatNav().destination,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() },
            popEnterTransition = { popEnterTransition() },
            popExitTransition = { popExitTransition() },
        ) {
            val viewModel = hiltViewModel<ChatRoomViewModel>()
            ChatRoomScreen(viewModel)
        }

    }
}