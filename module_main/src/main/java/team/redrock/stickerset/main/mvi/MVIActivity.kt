package team.redrock.stickerset.main.mvi

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.launch
import team.redrock.rain.lib.common.config.ui.mvvm.BaseVmBindActivity

abstract class MVIActivity<VM, VB, VE, VS> : BaseVmBindActivity<VM, VB>(), MVIPage<VE, VS>
        where VM : MVIViewModel<*, VE, VS>,
              VB : ViewBinding,
              VE : ViewEvent,
              VS : ViewState {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        lifecycleScope.launch {
            viewModel.viewState.launchEffects()
        }
        viewModel.viewEvents.collectLaunch { renderViewEvent(it) }
    }
}