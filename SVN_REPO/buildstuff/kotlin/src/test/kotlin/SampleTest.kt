import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {
  @Test
  fun testShouldReturnSum() {
    assertEquals(3, Sample().add(1, 2))
  }
}


