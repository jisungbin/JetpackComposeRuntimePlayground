package land.sungbin.compose.playground

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Composition
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.Dispatchers

private val DebugComposition =
  Composition(
    applier = DebugApplier(),
    parent = Recomposer(Dispatchers.Default),
  )

@Suppress("UnusedReceiverParameter")
fun Activity.setDebugContent(content: @Composable () -> Unit) {
  DebugComposition.setContent(content)
}

@Composable
fun DebugNode(label: String) {
  ComposeNode<String, DebugApplier>(
    factory = { label },
    update = {},
  )
}

@Composable
fun DebugNodeWithChildren(label: String, children: @Composable () -> Unit) {
  ComposeNode<String, DebugApplier>(
    factory = { label },
    update = {},
    content = children,
  )
}
