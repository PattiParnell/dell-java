import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Timesheet {

	private List<TimesheetEntry> database;

	public Timesheet() {

		database = new ArrayList<TimesheetEntry>();

	}

	public List<TimesheetEntry> list(String myProject, Boolean active) {
		List<TimesheetEntry> listTSE = new ArrayList<TimesheetEntry>();
		
		if (active) {

			for (int i = 0; i < database.size(); i++) {

				if (database.get(i).getEndTime() == null) {
					listTSE.add(database.get(i));
				}
			}
		} else

		{

			listTSE = database;
		}

		if (myProject != null) {
			for (int i = 0; i < listTSE.size(); i++) {

				if (listTSE.get(i).getProjectName() != myProject) {
					System.out.println("not project: " + myProject);
					//listTSE.remove(i);
				}
				else {
					System.out.println("my project: " + myProject);
				}

			}
		}

		return listTSE;
	}

	public void add(String project, String task) {
		TimesheetEntry tse = new TimesheetEntry(project, task);

		database.add(tse);

	}

	public TimesheetEntry getTimesheetEntry(int ID) {
		TimesheetEntry tse = null;

		for (int i = 0; i < database.size(); i++) {
			if (ID == database.get(i).getId()) {
				tse = database.get(i);

			}
		}
		return tse;

	}

	public void deleteTSE(int ID) {

		database.remove(getTimesheetEntry(ID));

	}

	public void stop(int ID) {

		TimesheetEntry tse = getTimesheetEntry(ID);
		tse.updateEndTime();

	}

}
