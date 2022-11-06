package ro.sapientia.android_8eloadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import ro.sapientia.android_8eloadas.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

//    val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d("XXX", "Activity - HashCode ${sharedViewModel.hashCode()}")

        Log.d("XXXX", "Activity's HashCode {$this.hashCode()}")

        // Bottom navigation
        val navController = findNavController(this, R.id.myNavHostFragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav?.setupWithNavController(navController)

    }
}