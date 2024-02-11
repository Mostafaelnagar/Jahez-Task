package app.te.core

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController
import app.te.core.extension.adjustFontScale
import app.te.core.extension.backToPreviousScreen
import com.zeugmasolutions.localehelper.LocaleHelper
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegate
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl

abstract class BaseActivity : ComponentActivity() {
    private val localeDelegate: LocaleHelperActivityDelegate = LocaleHelperActivityDelegateImpl()
    protected lateinit var navHostController: NavHostController

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(localeDelegate.attachBaseContext(newBase))
    }

    override
    fun createConfigurationContext(overrideConfiguration: Configuration): Context {
        val context = super.createConfigurationContext(overrideConfiguration)
        return LocaleHelper.onAttach(context)
    }

    override
    fun getApplicationContext(): Context =
        localeDelegate.getApplicationContext(super.getApplicationContext())

    override
    fun onResume() {
        super.onResume()
        localeDelegate.onResumed(this)
    }

    override
    fun onPause() {
        super.onPause()
        localeDelegate.onPaused()
    }

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localeDelegate.onCreate(this)
        adjustFontScale()
        setUpContent()
    }

    open fun setUpContent() {}

    open fun isBackPressed() {
        navHostController.backToPreviousScreen()
    }

}