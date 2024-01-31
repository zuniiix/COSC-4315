package meetingdsl

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {
  @Test
  fun testShouldScheduleMeeting() {
    val result = schedule meeting {}

    assertEquals("Meeting: ", result)
  }

  @Test
  fun testShouldScheduleNamedMeeting() {
    val result = schedule meeting {
        name = "Data Structures and Algorithms"
    }

    assertEquals("Meeting: Data Structures and Algorithms", result)
  }

  @Test
  fun testShouldScheduleNamedMeetingWithStartTime() {
    val result = schedule meeting {
        name = "Data Structures and Algorithms"
        start = 10..30
    }

    assertEquals("Meeting: Data Structures and Algorithms, Start Time: 10:30", result)
  }

  @Test
  fun testShouldScheduleNamedMeetingWithStartTimeAndEndTime() {
    val result = schedule meeting {
        name = "Data Structures and Algorithms"
        start = 10..30
        end = 12..45
    }

    assertEquals("Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes",result)
  }

  @Test
  fun testShouldScheduleNamedMeetingWithStartTimeAndEndTimeAndDate() {
    val result = schedule meeting {
        name = "Data Structures and Algorithms"
        start = 10..30
        end = 12..45
        date = LocalDate.of(2023, 11, 7)
    }
    
    assertEquals("Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes, Date: 11/7/2023",result)
  }
    
  @Test
  fun testShouldScheduleNamedMeetingWithStartTimeAndEndTimeAndDateAndParticipants() {
      val result = schedule meeting {
          name = "Data Structures and Algorithms"
          start = 10..30
          end = 12..45
          date = LocalDate.of(2023, 11, 7)
          participants = listOf("Mike B.", "Paula P.", "Chin Z.")
      }
  
      assertEquals("Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes, Date: 11/7/2023, Participants: Mike B., Paula P., Chin Z. (3 participants)", result)
  }
}