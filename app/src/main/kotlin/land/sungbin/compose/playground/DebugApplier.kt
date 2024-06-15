package land.sungbin.compose.playground

import androidx.compose.runtime.Applier

class DebugApplier : Applier<String> {
  private val stacks = mutableListOf("root")
  override val current get() = stacks.last()

  private inline fun debug(message: () -> String) {
    println("[$current] ${message()}")
  }

  override fun clear() {
    debug { "clear" }
  }

  override fun move(from: Int, to: Int, count: Int) {
    debug { "move: $from -> $to (count $count)" }
  }

  override fun remove(index: Int, count: Int) {
    debug { "remove: $index (count $count)" }
  }

  override fun up() {
    stacks.removeLast()
    debug { "up" }
  }

  override fun insertTopDown(index: Int, instance: String) {
    debug { "insertTopDown: $instance at $index" }
  }

  override fun insertBottomUp(index: Int, instance: String) {
    debug { "insertBottomUp: $instance at $index" }
  }

  override fun down(node: String) {
    stacks += node
    debug { "down: $node" }
  }
}
