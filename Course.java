/**
 * Represents a Course with a name, subject number, and meeting time.
 */
public class Course {

    /**
     * The name of the course.
     */
    private String name;

    /**
     * The subject number of the course.
     */
    private String subjectNumber;

    /**
     * The meeting time of the course.
     */
    private String meetingTime;

    /**
     * Constructs a new Course object.
     *
     * @param name          The name of the course.
     * @param subjectNumber The subject number of the course.
     * @param meetingTime   The meeting time of the course.
     */
    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime;
    }

    /**
     * Gets the name of the course.
     *
     * @return The name of the course.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the subject number of the course.
     *
     * @return The subject number of the course.
     */
    public String getSubjectNumber() {
        return this.subjectNumber;
    }

    /**
     * Gets the meeting time of the course.
     *
     * @return The meeting time of the course.
     */
    public String getMeetingTime() {
        return this.meetingTime;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return A string representation of the course in the format "subjectNumber: name meetingTime".
     */
    public String toString() {
        return this.subjectNumber + ": " + this.name + " " + this.meetingTime;
    }

    /**
     * Main method for testing the Course class.
     *
     * @param args 
     */
    public static void main(String[] args) {
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        System.out.println(csc120);
    }
}