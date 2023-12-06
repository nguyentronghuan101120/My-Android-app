import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myandroidapp.presentation.add_new_quote.AddNewQuoteScreen
import com.example.myandroidapp.presentation.quote_detail.QuoteDetailScreen

enum class Screen {
    HOME,
    LOGIN,
    DETAIL,
    ADD_NEW_QUOTE,
}

sealed class Route(val route: String) {
    object Home : Route(Screen.HOME.name)
    object Login : Route(Screen.LOGIN.name)
    object Detail : Route("${Screen.DETAIL.name}/{quoteId}") {
        fun createRoute(quoteId: Int) = "${Screen.DETAIL.name}/$quoteId"
    }
    object AddNewQuote : Route(Screen.ADD_NEW_QUOTE.name)

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

        composable(Route.Home.route) { entry->
            val text = entry.savedStateHandle.get<String>("quoteString")
            HomeScreen(navController = navController, text = text ?: "Empty")
        }

        composable(
            Route.Detail.route,
            arguments = listOf(navArgument("quoteId") { type = NavType.IntType }),
        ) { backStackEntry ->
            val argument = backStackEntry.arguments?.getInt("quoteId")
            requireNotNull(argument)
            QuoteDetailScreen(argument,navController = navController)
        }

        composable(
            Route.AddNewQuote.route,
//            arguments = listOf(navArgument("quoteId") { type = NavType.IntType }),
        ) { backStackEntry ->
//            val argument = backStackEntry.arguments?.getInt("quoteId")
//            requireNotNull(argument)
            AddNewQuoteScreen(navController = navController)
        }
    }
}

