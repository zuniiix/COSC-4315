module MeetingDSL
  class MeetingDetails
    Time = Struct.new(:hours, :minutes) do
      def to_s
        "#{hours} hours #{minutes} minutes"
      end
    end

    attr_accessor :name, :start, :end, :date, :participants

    def initialize
      @name = ''
      @start = nil
      @end = nil
      @date = nil
      @participants = []
    end

    def name(value)
      @name = value
      self
    end

    def start(value)
      @start = value
      self
    end

    def end(value)
      @end = value
      self
    end

    def date(month, day, year)
      @date = "#{month}/#{day}/#{year}"
      self
    end

    def participants_list(value)
      @participants = value
      self
    end

    def duration
      return Time.new(0, 0) unless @start && @end

      total_minutes_start = @start.begin * 60 + @start.end
      total_minutes_end = @end.begin * 60 + @end.end
      diff_minutes = total_minutes_end - total_minutes_start
      Time.new(diff_minutes / 60, diff_minutes % 60)
    end

    def generate_meeting_string
      result = "Meeting: #{@name}"
      result += ", Start Time: #{@start.begin}:#{@start.end}" if @start
      result += ", End Time: #{@end.begin}:#{@end.end}" if @end
      result += ", Duration: #{duration}" if @start && @end
      result += ", Date: #{@date}" if @date
      result += ", Participants: #{participants.join(', ')} (#{participants.size} participants)" unless @participants.empty?
      result
    end
  end
end

module Schedule
  def self.meeting(&block)
    details = MeetingDSL::MeetingDetails.new
    details.instance_eval(&block)
    details.generate_meeting_string
  end
end

