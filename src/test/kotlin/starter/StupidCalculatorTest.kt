package starter

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.throws
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StupidCalculatorTest {

  private val calculator = StupidCalculator()

  @Nested
  inner class `Adding` {

    @Test
    fun `positive numbers`() {
      assert.that(calculator.add(0, 0), equalTo(0))
      assert.that(calculator.add(123, 456), equalTo(579))
    }

    @Test
    fun `negative numbers`() {
      assert.that(calculator.add(-20, 20), equalTo(0))
      assert.that(calculator.add(123, -456), equalTo(-333))
    }
  }

  @Nested
  inner class `Dividing` {

    @Test
    fun `positive numbers`() {
      assert.that(calculator.div(10, 5), equalTo(2))
      assert.that(calculator.div(1, 3), equalTo(0))
    }

    @Test
    fun `through zero`() {
      assert.that({ calculator.div(1, 0) }, throws<ArithmeticException>())
    }
  }
}
