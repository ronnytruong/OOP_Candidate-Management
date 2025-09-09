/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * The Intern class extends the Candidate class and represents an intern
 * candidate. It stores additional information such as major, semester, and
 * university name.
 *
 * @author TrongTBCE190757
 */
public class Intern extends Candidate {

    private String majors;  // Variable to store the intern's major
    private String semester; // Variable to store the intern's current semester
    private String universityName; // Variable to store the university's name

    /**
     * Constructor for the Intern class.
     *
     * @param candidateId the intern's ID
     * @param firstName the intern's first name
     * @param lastName the intern's last name
     * @param birthDate the intern's birth year
     * @param address the intern's address
     * @param phone the intern's phone number
     * @param email the intern's email
     * @param candidateType the intern's type (Intern in this case)
     * @param majors the intern's major field of study
     * @param semester the intern's current semester
     * @param universityName the name of the intern's university
     */
    public Intern(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType); // Call to parent constructor
        this.majors = majors; // Set the intern's major
        this.semester = semester; // Set the intern's semester
        this.universityName = universityName; // Set the intern's university name
    }

    /**
     * Getter for the major.
     *
     * @return the intern's major
     */
    public String getMajors() {
        return majors;
    }

    /**
     * Setter for the major.
     *
     * @param majors the major to set
     */
    public void setMajors(String majors) {
        this.majors = majors;
    }

    /**
     * Getter for the semester.
     *
     * @return the intern's current semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Setter for the semester.
     *
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Getter for the university name.
     *
     * @return the name of the intern's university
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Setter for the university name.
     *
     * @param universityName the university name to set
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
