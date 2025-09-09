/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package l01;

/**
 * L01 - Main class to manage doctor candidates Handles different types of
 * candidates: Experience, Fresher, and Intern Provides functionality for adding
 * new candidates and searching for candidates by name.
 *
 * @author TrongTBCE190757
 */
public class L01 {

    /**
     * The main method serves as the entry point of the program. It initializes
     * the CandidateManager and handles candidate-related operations.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a CandidateManager instance to manage the list of candidates
        CandidateManager cm = new CandidateManager();

        // Declare variables to store candidate details
        String candidateId, firstName, lastName, address, phone, email, proSkill,
                graduationRank, education, majors, semester, universityName;
        int birthDate, expInYear, graduationDate;

        try {
            boolean loop = true; // Start the loop that keeps the program running
            while (loop) {
                // Display the main menu for the user to select an option
                System.out.println("====== Doctor Management ======");
                System.out.println("       1. Experience");
                System.out.println("       2. Fresher");
                System.out.println("       3. Internship");
                System.out.println("       4. Search Doctor");
                System.out.println("       5. Exit");

                String s = MyLib.sc.nextLine().trim(); // Get the user's menu selection

                // Switch-case to handle different menu options based on user's choice
                switch (s) {
                    case "1":
                        // Case 1: Add an experienced doctor candidate
                        while (true) {
                            try {
                                // Get candidate's ID with validation and ensure it's unique
                                do {
                                    candidateId = MyLib.getInfor("Enter ID: ", "Please enter ID contains letters and numbers only").toUpperCase();
                                    if (cm.checkCode(candidateId)) { // Check if the ID already exists
                                        System.out.println("ID already exist, please enter another ID");
                                    }
                                } while (cm.checkCode(candidateId));

                                // Get candidate's personal details
                                cm.setCandidateType(0); // Set the candidate type to Experience
                                firstName = MyLib.getChar("Enter first name: ", "Please enter a name that contains only letters");
                                lastName = MyLib.getChar("Enter Last Name: ", "Please enter a name that contains only letters");
                                birthDate = cm.getBirthDate("Enter birthdate: ", "Please enter your year of birth that contains only numbers");
                                address = MyLib.getAddress("Enter address: ", "Please enter a valid address using letters, numbers, spaces, and the characters '/', '-', ',', and '.'");
                                phone = MyLib.getPhone("Enter phone number: ", "Please enter your phone number that contains only numbers");
                                email = MyLib.getEmail("Enter email: ", "Please enter your email with format <account name>@<domain>");
                                expInYear = cm.getExpInYear("Enter experience in year: ", 1, cm.currentYear - birthDate - 22);
                                proSkill = MyLib.getInfor("Enter professional skill: ", "Please enter your professional skill that contains numbers and letters only");

                                // Create a new Experience candidate object and add it to the list
                                Experience ex = new Experience(candidateId, firstName, lastName, birthDate, address, phone, email, cm.getCandidateType(), expInYear, proSkill);
                                cm.experienceList.add(ex); // Add to the experience list
                                cm.idList.add(candidateId); // Add ID to the list of IDs
                                System.out.println("Created candidate of experience successfully!");

                                break; // Exit the loop after successfully adding the candidate
                            } catch (Exception e) {
                                System.out.println(e.getMessage()); // Print any error messages
                            }
                        }
                        break;

                    case "2":
                        // Case 2: Add a fresher doctor candidate
                        while (true) {
                            try {
                                // Get candidate's ID with validation and ensure it's unique
                                do {
                                    candidateId = MyLib.getInfor("Enter ID: ", "Please enter ID contains letters and numbers only").toUpperCase();
                                    if (cm.checkCode(candidateId)) {
                                        System.out.println("ID already exist, please enter another ID");
                                    }
                                } while (cm.checkCode(candidateId));

                                // Get candidate's personal details
                                cm.setCandidateType(1); // Set the candidate type to Fresher
                                firstName = MyLib.getChar("Enter first name: ", "Please enter a name that contains only letters");
                                lastName = MyLib.getChar("Enter Last Name: ", "Please enter a name that contains only letters");
                                birthDate = cm.getBirthDate("Enter birthdate: ", "Please enter your year of birth that contains only numbers");
                                address = MyLib.getAddress("Enter address: ", "Please enter a valid address using letters, numbers, spaces, and the characters '/', '-', ',', and '.'");
                                phone = MyLib.getPhone("Enter phone number: ", "Please enter your phone number that contains only numbers");
                                email = MyLib.getEmail("Enter email: ", "Please enter your email with format <account name>@<domain>");
                                graduationDate = cm.getGraduationDate("Enter graduation date: ", "You must be 22 years old to graduate");
                                graduationRank = cm.getGraduationRank("Enter graduation rank: ", "There are only 4 types of graduation: excellent, good, fair and poor");
                                education = MyLib.getInfor("Enter education: ", "Please enter your education that contains only letters");

                                // Create a new Fresher candidate object and add it to the list
                                Fresher fr = new Fresher(candidateId, firstName, lastName, birthDate, address, phone, email, cm.getCandidateType(), graduationDate, graduationRank, education);
                                cm.idList.add(candidateId); // Add ID to the list of IDs
                                cm.fresherList.add(fr); // Add to the fresher list
                                System.out.println("Created candidate of fresher successfully!");

                                break; // Exit the loop after successfully adding the candidate
                            } catch (Exception e) {
                                System.out.println(e.getMessage()); // Print any error messages
                            }
                        }
                        break;

                    case "3":
                        // Case 3: Add an intern doctor candidate
                        while (true) {
                            try {
                                // Get candidate's ID with validation and ensure it's unique
                                do {
                                    candidateId = MyLib.getInfor("Enter ID: ", "Please enter ID contains letters and numbers only").toUpperCase();
                                    if (cm.checkCode(candidateId)) {
                                        System.out.println("ID already exist, please enter another ID");
                                    }
                                } while (cm.checkCode(candidateId));

                                // Get candidate's personal details
                                cm.setCandidateType(2); // Set the candidate type to Intern
                                firstName = MyLib.getChar("Enter first name: ", "Please enter a name that contains only letters");
                                lastName = MyLib.getChar("Enter Last Name: ", "Please enter a name that contains only letters");
                                birthDate = cm.getBirthDate("Enter birthdate: ", "Please enter your year of birth that contains only numbers");
                                address = MyLib.getAddress("Enter address: ", "Please enter a valid address using letters, numbers, spaces, and the characters '/', '-', ',', and '.'");
                                phone = MyLib.getPhone("Enter phone number: ", "Please enter your phone number that contains only numbers");
                                email = MyLib.getEmail("Enter email: ", "Please enter your email with format <account name>@<domain>");
                                majors = MyLib.getChar("Enter majors: ", "Please enter your major that contains only letters");
                                semester = MyLib.getInfor("Enter semester: ", "Please enter your semester that contains letters and numbers");
                                universityName = MyLib.getChar("Enter universityName: ", "Please enter your university name that contains only letters");

                                // Create a new Intern candidate object and add it to the list
                                Intern in = new Intern(candidateId, firstName, lastName, birthDate, address, phone, email, cm.getCandidateType(), majors, semester, universityName);
                                cm.internList.add(in); // Add to the intern list
                                cm.idList.add(candidateId); // Add ID to the list of IDs
                                System.out.println("Created candidate of intern successfully!");

                                break; // Exit the loop after successfully adding the candidate
                            } catch (Exception e) {
                                System.out.println(e.getMessage()); // Print any error messages
                            }
                        }
                        break;

                    case "4":
                        // Case 4: Search for doctors by a keyword (first name or last name)
                        cm.printList(); // Display the list of all candidates
                        System.out.println("--------- Search Candidate ---------");
                        System.out.print("Enter first name or last name: ");
                        String thing = MyLib.sc.nextLine().trim().toLowerCase(); // Get the search keyword
                        int type = MyLib.getNumber("Enter Type: ", "Please enter a number"); // Get the candidate type
                        try {
                            // Attempt to search candidates based on the keyword and type
                            cm.printTable(thing, type); // Print the search results in a table format
                        } catch (Exception e) {
                            System.out.println(e.getMessage()); // Handle any exceptions during the search operation
                        }
                        break;

                    case "5":
                        // Case 5: Exit the program
                        System.out.println("Good Bye!");
                        loop = false; // Exit the loop and terminate the program
                        break;
                }
            }
        } catch (Exception e) {
            // Handle any unexpected exceptions during program execution
            System.out.println(e.getMessage());
        }
    }
}
