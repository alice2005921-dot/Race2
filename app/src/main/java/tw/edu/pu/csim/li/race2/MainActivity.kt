package tw.edu.pu.csim.li.race2

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.window.layout.WindowMetricsCalculator
import tw.edu.pu.csim.li.race2.ui.theme.Race2Theme
import tw.edu.pu.csim.sj.myapplication.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //強迫橫式螢幕
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        // 隱藏狀態列：獲取 WindowInsetsController，再隱藏statusBars
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

        //隱藏下方巡覽列
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        // 確保內容延伸到至邊緣

        WindowCompat.setDecorFitsSystemWindows(
            window, false)
        // 步驟 1: 獲取 WindowMetricsCalculator 實例
        val windowMetricsCalculator =
            WindowMetricsCalculator.getOrCreate()

        // 步驟 2: 計算當前視窗的 WindowMetrics
        val currentWindowMetrics=
            windowMetricsCalculator.computeCurrentWindowMetrics(this)

        // 步驟 3: 從 bounds 獲取像素尺寸
        val bounds = currentWindowMetrics.bounds
        val screenWidthPx = bounds.width().toFloat()
        val screenHeightPx = bounds.height().toFloat()

        // 實例化 ViewModel
        val gameViewModel: GameViewModel by viewModels()
        gameViewModel.SetGameSize(screenWidthPx,screenHeightPx)

        setContent {
            Race2Theme {
                GameScreen(
                    message = "資管二B 李羿慧 411312414\n橫式螢幕，隱藏狀態列.",gameViewModel,
                )
            }
        }
    }
}
