import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * courseload class for planner Software. Keeps a list of all the courses currently registered in the planner using a HashMap
 * @author Vishal
 *
 */
public class Courseload {
	public Map<String, Course> _courses;
	public int _count;
	
	public Courseload() { _courses = new HashMap<>(); }
	
	/**
	 * Returns an Iterable list of Course entries
	 * @return iterator
	 */
	public Iterator<Entry<String, Course>> getClasses() {
		return _courses.entrySet().iterator();
	}
	
	/**
	 * Adds new course to HashMap with three string parameters, and increases count of courses by 1
	 * @param name
	 * @param teacher
	 * @param email
	 */
	public void newCourse(String name, String teacher, String email) {
		Course courseToAdd = new Course(name, teacher, email);
		_courses.put(name, courseToAdd);
		_count++;
	}
	
	/**
	 * returns a course when given the name of that course as a key
	 * @param courseName
	 * @return Course
	 */
	public Course viewCourse(String courseName) {
		return _courses.get(courseName);
	}
	
	/**
	 * Delets a course when given the name of that course as a key
	 * @param courseName
	 */
	public void deleteCourse(String courseName) {
		_courses.remove(courseName);
		_count--;
	}
	
	/**
	 * Returns the number of course entries currently in the HashMap
	 * @return
	 */
	public int getCount() {
		return _count;
	}
	
}
