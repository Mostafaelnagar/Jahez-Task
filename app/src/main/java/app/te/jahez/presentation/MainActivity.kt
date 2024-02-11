package app.te.jahez.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import app.te.core.extension.navigateSafe
import app.te.core.theme.AppArchitectureTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.get
import app.te.core.BaseActivity
import app.te.jahez.presentation.nav_graph.SetupNavGraph
import app.te.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun setUpContent() {
        setContent {
            AppArchitectureTheme {
                navHostController = rememberNavController()
                HandleNavigation(navHostController)
                Scaffold() {
                    SetupNavGraph(navHostController = navHostController)
                }
            }

        }

    }

    @Composable
    private fun HandleNavigation(navHostController: NavHostController) {
        SideEffect {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.RESUMED) {
                    navigationManager.commands.collect { command ->
                        if (command.destination.isNotEmpty()) {
                            navHostController.navigateSafe(
                                command.destination,
                                popUpTo = command.popUpTo,
                                popUpToId = if (command.popUpToId != null) navHostController.graph[command.popUpToId!!].id else null
                            )
                        }
                    }
                }
            }
        }
    }

}


