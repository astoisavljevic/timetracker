package rs.in.staleksit.timetracker.core.util;

import java.util.ArrayList;
import java.util.List;

import rs.in.staleksit.timetracker.core.dto.TimeSheetDTO;
import rs.in.staleksit.timetracker.core.project.TimeSheet;

public class TimeSheetMapper {
	
	public static TimeSheetDTO map(TimeSheet timeSheet) {
		TimeSheetDTO result = new TimeSheetDTO(timeSheet.getId(), timeSheet.getProjectTask().getName(), timeSheet.getActivityType().getName(), timeSheet.getHours(), timeSheet.getDescription(), timeSheet.getStatus());
		return result;
	}
	
	public static List<TimeSheetDTO> map(List<TimeSheet> timeSheets) {
		List<TimeSheetDTO> result = new ArrayList<TimeSheetDTO>();
		for (TimeSheet timeSheet: timeSheets) {
			result.add(map(timeSheet));
		}
		return result;
	}



}
