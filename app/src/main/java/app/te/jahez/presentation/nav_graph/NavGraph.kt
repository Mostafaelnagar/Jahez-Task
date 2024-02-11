package app.te.jahez.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import app.te.navigation.ChatGraph
import app.te.navigation.RootGraph
import te.app.chat.presentation.nav_graph.chatNavGraph

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        route = RootGraph().destination,
        startDestination = ChatGraph().destination,
    ) {
        chatNavGraph()
    }
}