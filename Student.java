import java.util.ArrayList;

/**
 * Represents a student with a name, ID, class year, and a list of courses.
 */
public class Student {

    private String name; 
    private String id; 
    private int classYear; 
    private ArrayList<Course> classes; 

    /**
     * Constructs a new Student object with the given name, ID, and class year.
     *
     * @param name      The name of the student.
     * @param id        The ID of the student.
     * @param classYear The class year of the student.
     */
    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<>(); 
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return this.name; 
    }

    /**
     * Returns a string representation of the student.
     *
     * @return A string containing the student's name, ID, and class year.
     */
    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    /**
     * Main method for testing the Student class.
     *
     * @param args 
     */
    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        ab.classes.add(csc120);
        System.out.println(ab.classes);
    }
    
}
