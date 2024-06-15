package land.sungbin.compose.playground

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class PlaygroundActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(
      TextView(this).apply {
        @Suppress("SetTextI18n")
        text = "Welcome to ${PlaygroundActivity::class.simpleName}!"
      },
    )

    setDebugContent {
      DebugNodeWithChildren("parent") {
        DebugNode("child-1")
        DebugNode("child-2")
        DebugNode("child-3")
      }

      DebugNodeWithChildren("parent-2") {
        DebugNode("child-2-1")
        DebugNode("child-2-2")
        DebugNode("child-2-3")

        DebugNodeWithChildren("parent-3 (nested)") {
          DebugNode("child-3-1 (nested)")
          DebugNode("child-3-2 (nested)")
          DebugNode("child-3-3 (nested)")
        }
      }
    }
  }
}
