package land.sungbin.compose.playground

import androidx.compose.runtime.Applier

class DebugApplier : Applier<Ref<String>> {
  private val stacks = mutableListOf(Ref<String>().apply { value = "root" })
  override val current get() = stacks.last()

  private inline fun debug(message: () -> String) {
    println("[${current.value}] ${message()}")
  }

  override fun insertTopDown(index: Int, instance: Ref<String>) {
    debug { "insertTopDown: ${instance.value} at $index" }
  }

  override fun down(node: Ref<String>) {
    stacks += node
    debug { "down: ${node.value}" }
  }

  override fun insertBottomUp(index: Int, instance: Ref<String>) {
    debug { "insertBottomUp: ${instance.value} at $index" }
  }

  override fun up() {
    stacks.removeLast()
    debug { "up" }
  }

  override fun remove(index: Int, count: Int) {
    debug { "remove: $index (count $count)" }
  }

  override fun move(from: Int, to: Int, count: Int) {
    debug { "move: $from -> $to (count $count)" }
  }

  override fun clear() {
    debug { "clear" }
  }
}
