package land.sungbin.compose.playground

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Composition
import androidx.compose.runtime.Recomposer
import kotlinx.coroutines.Dispatchers

private val DebugComposition = Composition(DebugApplier(), parent = Recomposer(Dispatchers.Default))

@Suppress("UnusedReceiverParameter")
fun Activity.setDebugContent(content: @Composable () -> Unit) {
  DebugComposition.setContent(content)
}

@Composable
fun DebugNode(label: String) {
  ComposeNode<Ref<String>, DebugApplier>(
    factory = { Ref() },
    update = {
      init {
        println("[$label] init")
        value = label
      }
      reconcile {
        println("[$label] reconcile")
      }
    },
  )
}

@Composable
fun DebugNodeWithChildren(label: String, children: @Composable () -> Unit) {
  ComposeNode<Ref<String>, DebugApplier>(
    factory = { Ref() },
    update = {
      init {
        println("[$label] init")
        value = label
      }
      reconcile {
        println("[$label] reconcile")
      }
    },
    content = children,
  )
}
