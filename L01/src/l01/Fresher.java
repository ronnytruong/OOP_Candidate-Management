/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * The Fresher class extends the Candidate class and represents a fresher
 * candidate. It stores additional information such as graduation date,
 * graduation rank, and education level.
 * 
 * @author TrongTBCE190757
 */
public class Fresher extends Candidate {

    private int graduationDate;  // Variable to store the graduation year
    private String graduationRank; // Variable to store the graduation rank (e.g., Excellence, Good)
    private String education; // Variable to store the education background

    /**
     * Constructor for the Fresher class.
     *
     * @param candidateId the candidate's ID
     * @param firstName the candidate's first name
     * @param lastName the candidate's last name
     * @param birthDate the candidate's birth year
     * @param address the candidate's address
     * @param phone the candidate's phone number
     * @param email the candidate's email
     * @param candidateType the candidate's type (Fresher in this case)
     * @param graduationDate the candidate's graduation year
     * @param graduationRank the candidate's graduation rank
     * @param education the candidate's education background
     */
    public Fresher(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, int graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType); // Call to parent constructor
        this.graduationDate = graduationDate; // Set the graduation year
        this.graduationRank = graduationRank; // Set the graduation rank
        this.education = education; // Set the education background
    }

    /**
     * Getter for the graduation date.
     *
     * @return the graduation date (year)
     */
    public int getGraduationDate() {
        return graduationDate;
    }

    /**
     * Setter for the graduation date.
     *
     * @param graduationDate the graduation year to set
     */
    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * Getter for the graduation rank.
     *
     * @return the graduation rank (e.g., Excellence, Good)
     */
    public String getGraduationRank() {
        return graduationRank;
    }

    /**
     * Setter for the graduation rank.
     *
     * @param graduationRank the graduation rank to set
     */
    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    /**
     * Getter for the education background.
     *
     * @return the education background
     */
    public String getEducation() {
        return education;
    }

    /**
     * Setter for the education background.
     *
     * @param education the education background to set
     */
    public void setEducation(String education) {
        this.education = education;
    }
}
