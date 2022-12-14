package team.redrock.stickerset.main.mvi

import kotlinx.coroutines.flow.StateFlow

interface MVIPage<VE: ViewEvent, VS: ViewState> {
    /**
     * 初始化View
     */
    fun initView()

    /**
     * 注册Effect
     * 在里面使用useEffect
     */
    fun StateFlow<VS>.launchEffects()

    /**.
     * 渲染ViewEvent
     *
     * @param viewEvent 事件
     */
    fun renderViewEvent(viewEvent: VE)
}