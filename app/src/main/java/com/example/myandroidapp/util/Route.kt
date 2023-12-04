import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Screen {
    HOME,
    LOGIN,
}

sealed class Route(val route: String) {
    object Home : Route(Screen.HOME.name)
    object Login : Route(Screen.LOGIN.name)
}

@Composable
fun AppRoute() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Login.route) {

        composable(Route.Login.route) {
            LoginPage(
                navController = navController
            )
        }

        composable(Route.Home.route) {
            HomeScreen()
        }
    }
}

