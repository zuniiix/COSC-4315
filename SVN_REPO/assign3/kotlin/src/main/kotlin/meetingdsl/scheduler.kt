package meetingdsl

import java.time.LocalDate

data class Time(val hours: Int, val minutes: Int) {
    override fun toString(): String {
        return "$hours hours $minutes minutes"
    }
}

data class MeetingDetails(
  var name: String = "",
  var start: IntRange = 0..0,
  var end: IntRange = 0..0,
  var date: LocalDate? = null, 
  var participants: List<String> = emptyList()) 
{
  fun duration(): Time {
    val totalMinutesStart = start.start * 60 + start.endInclusive
    val totalMinutesEnd = end.start * 60 + end.endInclusive
    val diffMinutes = totalMinutesEnd - totalMinutesStart

    return Time(diffMinutes / 60, diffMinutes % 60)
  }

  fun generateMeetingString(): String {
    val numberOfParticipants = participants.size
    return buildString {
        append("Meeting: $name")
        if (start != 0..0) {
            append(", Start Time: ${start.start}:${start.endInclusive}")
        }
        if (end != 0..0) {
            append(", End Time: ${end.start}:${end.endInclusive}")
        }
        if (start != 0..0 && end != 0..0) {
            append(", Duration: ${duration()}")
        }
        if (date != null) {
            append(", Date: ${dateAsString()}")
        }
        if (numberOfParticipants > 0) {
            append(", Participants: ${participants.joinToString(", ")} ($numberOfParticipants participants)")
        }
    }
  }

  fun dateAsString(): String {
    return "${date?.monthValue}/${date?.dayOfMonth}/${date?.year}"
  }
}

object schedule {
  infix fun meeting(closure: MeetingDetails.() -> Unit): String {
    val details = MeetingDetails().apply(closure)
    return details.generateMeetingString()
    }
}