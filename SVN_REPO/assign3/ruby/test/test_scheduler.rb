require 'test/unit'
require_relative '../src/scheduler'

module MeetingDSL
  class SampleTest < Test::Unit::TestCase
    def test_should_schedule_meeting
      result = Schedule.meeting {}
      assert_equal "Meeting: ", result
    end

    def test_should_schedule_named_meeting
      result = Schedule.meeting { 
        name "Data Structures and Algorithms" 
      }
      assert_equal "Meeting: Data Structures and Algorithms", result
    end

    def test_should_schedule_named_meeting_with_start_time
      result = Schedule.meeting { 
        name "Data Structures and Algorithms"
        start 10..30 
      }
      assert_equal "Meeting: Data Structures and Algorithms, Start Time: 10:30", result
    end

    def test_should_schedule_named_meeting_with_start_time_and_end_time
      result = Schedule.meeting { 
        name "Data Structures and Algorithms" 
        start 10..30
        self.end = 12..45 
      }
      assert_equal "Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes", result
    end

    def test_should_schedule_named_meeting_with_start_time_and_end_time_and_date
      result = Schedule.meeting {
        name "Data Structures and Algorithms"
        start 10..30
        self.end = 12..45
        date 11, 7, 2023
      }
      assert_equal "Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes, Date: 11/7/2023", result
    end
    

    def test_should_schedule_named_meeting_with_start_time_and_end_time_and_date_and_participants
      result = Schedule.meeting {
        name "Data Structures and Algorithms"
        start 10..30
        self.end = 12..45
        date 11, 7, 2023
        participants_list ["Mike B.", "Paula P.", "Chin Z."]
      }
      assert_equal "Meeting: Data Structures and Algorithms, Start Time: 10:30, End Time: 12:45, Duration: 2 hours 15 minutes, Date: 11/7/2023, Participants: Mike B., Paula P., Chin Z. (3 participants)", result
    end
  end
end

