[![](https://jitpack.io/v/KangTaeJong98/Library.svg)](https://jitpack.io/#KangTaeJong98/Library)

### Reduce boiler plate code for databinding and navigation components
***
### 🐘Dependency
#### Latest Version : 7.0.5
[more(Maven, sbt, leiningen)](https://jitpack.io/#KangTaeJong98/Library)
```kotlin
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```kotlin
dependencies {
    implementation 'com.github.KangTaeJong98:Library:$version'
}
```
***
### 😊 Example
### Before Code
NoLibActivity.kt
```kotlin
class NoLibActivity : AppCompatActivity() {
    private val binding: ActivityNoLibBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_no_lib) }
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment).navController
    }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(navController.graph)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }
}
```

### After Code
MainActivity.kt
```kotlin
class MainActivity : NavigationActivity<ActivityMainBinding>(R.layout.activity_main)
```

### PermissionManager
MainActivity.kt
```kotlin
class MainActivity : NavigationActivity<ActivityMainBinding>(R.layout.activity_main, R.id.nav_host) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PermissionManager.Builder(this)
            .setOnGranted {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            .setOnDenied {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
            .execute(arrayOf(Manifest.permission.CAMERA))
    }
}
```

### Too Simple!!
***
### Now Support
#### Base
* BaseActivity
* BaseFragment
* BaseDialogFragment
* BaseBottomSheetDialogFragment
* BaseRecyclerViewAdapter
* BaseRecyclerViewPagingAdapter
* BaseViewHolder
* BaseDao

#### Binding
* BindingActivity
* BindingFragment
* BindingDialogFragment
* BindingBottomSheetDialogFragment

#### Navigation
* NavigationActivity
* NavigationFragment
* NavigationDialogFragment
* NavigationBottomSheetDialogFragment

#### Util
* PermissionManager
* SimpleSelectionTracker
* SpaceItemDecoration

#### Extend Function
* Int.toDP(): Int
* Float.toDP(): Float
* Bitmap.toByteArray(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100): ByteArray
* Bitmap.toByteArrayOutputStream(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100): ByteArrayOutputStream