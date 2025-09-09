/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

/**
 * Candidate class to represent a job candidate's personal and professional
 * details.
 *
 * @author TrongTBCE190757
 */
public class Candidate {

    // Unique identifier for each candidate
    private String candidateId;

    // Candidate's first name
    private String firstName;

    // Candidate's last name
    private String lastName;

    // Candidate's birth year or full birthdate (int may not be ideal for full date)
    private int birthDate;

    // Candidate's address for communication or job location
    private String address;

    // Candidate's phone number for contact
    private String phone;

    // Candidate's email address
    private String email;

    // Type of candidate (Experience, Fresher, Intern)
    private int candidateType;

    // A counter for formatting purposes
    private int count = 1;

    // Candidate type description (Experience, Fresher, Intern)
    private String type;

    /**
     * Constructor to initialize the Candidate object with the provided details.
     *
     * @param candidateId The candidate's ID
     * @param firstName Candidate's first name
     * @param lastName Candidate's last name
     * @param birthDate Candidate's birth year or full birthdate
     * @param address Candidate's address
     * @param phone Candidate's phone number
     * @param email Candidate's email address
     * @param candidateType Type of the candidate (Experience, Fresher, Intern)
     */
    public Candidate(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    // Getter and setter methods for each field
    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    /**
     * Provides a string representation of the candidate object, including
     * formatted details. Converts candidate type into a readable format
     * (Experience, Fresher, Intern).
     *
     * @return A formatted string of candidate details
     */
    @Override
    public String toString() {
        // Mapping the candidateType to a string representation
        switch (String.valueOf(this.getCandidateType())) {
            case "0" ->
                type = "Experience";
            case "1" ->
                type = "Fresher";
            case "2" ->
                type = "Intern";
        }
        // Formatting the candidate's information into a clean output
        return String.format("|%5s|%-15s|%9s|%-20s|%10s|%-20s|%-15s|\n",
                this.count++, this.firstName + " " + this.lastName, this.birthDate, this.address, this.phone, this.email, type);
    }
}
