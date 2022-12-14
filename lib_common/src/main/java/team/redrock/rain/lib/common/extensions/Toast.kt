package team.redrock.rain.lib.common.extensions

import android.widget.Toast
import team.redrock.rain.lib.common.BaseApp

/**
 * ...
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/3/7 17:58
 */

fun toast(s: CharSequence) {
  Toast.makeText(BaseApp.appContext, s, Toast.LENGTH_SHORT).show()
}

fun toastLong(s: CharSequence) {
  Toast.makeText(BaseApp.appContext, s, Toast.LENGTH_LONG).show()
}

fun String.toast() = toast(this)
fun String.toastLong() = toastLong(this)