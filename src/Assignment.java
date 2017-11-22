/*
 * NOT TO BE CONFUSED WITH 'ASSIGNMENTS CLASS'
 */
public class Assignment {
	
	public String _description;
	public String _month;
	public String _day;
	public String _year;
	public Boolean _completion;
	
	public Assignment(String description, String month, String day, String year) {
		_description = description;
		_month = month;
		_day = day;
		_year = year;
		_completion = false;	
	}
	
}
