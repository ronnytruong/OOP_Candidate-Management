/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * The Experience class extends the Candidate class and represents candidates
 * with experience. It stores additional information such as the number of years
 * of experience and professional skills.
 * 
 * @author TrongTBCE190757
 */
public class Experience extends Candidate {

    private int expInYear;  // Variable to store years of experience
    private String proSkill; // Variable to store professional skills

    /**
     * Constructor for the Experience class.
     *
     * @param candidateId the candidate's ID
     * @param firstName the candidate's first name
     * @param lastName the candidate's last name
     * @param birthDate the candidate's birth year
     * @param address the candidate's address
     * @param phone the candidate's phone number
     * @param email the candidate's email
     * @param candidateType the candidate's type (Experience in this case)
     * @param expInYear the number of years of experience
     * @param proSkill the professional skill of the candidate
     */
    public Experience(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType); // Call to parent constructor
        this.expInYear = expInYear; // Set years of experience
        this.proSkill = proSkill;  // Set professional skills
    }

    /**
     * Getter for the years of experience.
     *
     * @return the number of years of experience
     */
    public int getExpInYear() {
        return expInYear;
    }

    /**
     * Setter for the years of experience.
     *
     * @param expInYear the number of years of experience to set
     */
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    /**
     * Getter for the professional skills.
     *
     * @return the professional skills
     */
    public String getProSkill() {
        return proSkill;
    }

    /**
     * Setter for the professional skills.
     *
     * @param proSkill the professional skill to set
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
