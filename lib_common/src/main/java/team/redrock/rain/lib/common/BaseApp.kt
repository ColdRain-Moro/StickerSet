package team.redrock.rain.lib.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper
import com.alibaba.android.arouter.launcher.ARouter
import team.redrock.rain.lib.common.BuildConfig

/**
 * ...
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/5/26 14:01
 */
open class BaseApp : Application() {
  companion object {
    lateinit var app: BaseApp
      private set

    val appContext: Context
      get() = app
  }

  lateinit var version: String
    protected set
  
  @CallSuper
  override fun onCreate() {
    super.onCreate()
    app = this
    initARouter()
  }
  
  private fun initARouter() {
    if (BuildConfig.DEBUG) {
      ARouter.openLog()
      ARouter.openDebug()
    }
    ARouter.init(this)
  }
}