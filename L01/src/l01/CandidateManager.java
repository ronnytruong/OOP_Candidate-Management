/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * CandidateManager class is responsible for managing candidates of different
 * types: Experience, Fresher, and Intern. It allows for adding candidates,
 * searching candidates by name or type, and displaying candidate details.
 *
 * @author TrongTBCE190757
 */
public class CandidateManager {

    // Lists to store candidates of different types
    ArrayList<Experience> experienceList = new ArrayList<>();
    ArrayList<Fresher> fresherList = new ArrayList<>();
    ArrayList<Intern> internList = new ArrayList<>();
    ArrayList<String> idList = new ArrayList<>();
    ArrayList<Candidate> searchedList = new ArrayList<>();

    // Variable used to store the current year
    int currentYear = LocalDate.now().getYear();

    // Variables for candidate details
    private int n = 0;
    private int candidateType;

    /**
     * Getter for candidate type.
     *
     * @return candidate type
     */
    public int getCandidateType() {
        return candidateType;
    }

    /**
     * Setter for candidate type.
     *
     * @param candidateType the type of candidate (Experience, Fresher, Intern)
     */
    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    /**
     * Retrieves and validates the birth year of the candidate. The method
     * ensures that the input is a valid integer, falls within the acceptable
     * range (from 1900 to the current year), and meets the age requirement
     * based on the candidate type.
     *
     * @param msg The message prompting the user for input.
     * @param errorMsg The error message displayed when the input is invalid.
     * @return The validated birth year.
     */
    public int getBirthDate(String msg, String errorMsg) {
        // Loop until a valid birth year is entered
        while (true) {
            try {
                System.out.print(msg); // Prompt the user for input
                String s = MyLib.sc.nextLine().trim();
                n = Integer.parseInt(s); // Convert input string to an integer

                // Check if input is empty
                if (s.isEmpty()) {
                    System.out.println(errorMsg);
                    continue; // Re-prompt the user
                }

                // Ensure the input is not a character (redundant check since it's already parsed as an integer)
                if (n >= 'a' && n <= 'z' || n >= 'A' && n <= 'Z') {
                    System.out.println(errorMsg);
                    continue; // Re-prompt the user
                }

                // Check if the year is within the general valid range
                if (!(n >= 1900 && n <= currentYear)) {
                    System.out.println(errorMsg);
                    continue; // Re-prompt the user
                }

                // Validate birth year based on candidate type
                switch (this.getCandidateType()) {
                    case 0 -> { // Experience candidate must be at least 23 years old
                        if (!(n <= currentYear - 23)) {
                            System.out.println("Invalid experience year! Your birth year must be " + (currentYear - 23) + " or earlier.");
                        }
                    }
                    case 1 -> { // Fresher candidate must be at least 22 years old
                        if (!(n <= currentYear - 22)) {
                            System.out.println("Invalid fresher year! Your birth year must be " + (currentYear - 22) + " or earlier.");
                        }
                    }
                    case 2 -> { // Intern candidate must be at least 18 years old
                        if (!(n <= currentYear - 18)) {
                            System.out.println("Invalid intern year! Your birth year must be " + (currentYear - 18) + " or earlier.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(errorMsg); // Display error message for invalid input
            }
            break; // Exit loop after processing input
        }

        return n; // Return the validated birth year
    }

    /**
     * Method to get the graduation date of the candidate.
     *
     * @param msg message to prompt the user for input
     * @param errorMsg error message displayed when input is invalid
     * @return the validated graduation year
     */
    public int getGraduationDate(String msg, String errorMsg) {
        int gd;
        while (true) {
            try {
                System.out.print(msg);
                String s = MyLib.sc.nextLine();
                gd = Integer.parseInt(s);
                if (gd >= n + 22 && gd <= n + 29) {
                    return gd;
                } else {
                    System.out.println(errorMsg);
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Method to get the experience years of the candidate.
     *
     * @param msg message to prompt the user for input
     * @param min minimum years of experience
     * @param max maximum years of experience
     * @return the validated years of experience
     */
    public int getExpInYear(String msg, int min, int max) {
        // Declare a variable to store the user input
        int input;
        while (true) {
            // Display the prompt message asking the user for input
            System.out.print(msg);

            try {
                if (n <= currentYear - 23) {
                    // Read the input as a string and convert it to an integer
                    input = Integer.parseInt(MyLib.sc.nextLine());
                    // Check if the input is within the specified range
                    if (input >= min && input <= max) {
                        return input; // Return the valid input
                    } else if (max != min) {
                        // Inform the user if the input is out of the valid range
                        System.out.println("Input must be between " + min + " and " + max);
                    } else {
                        // Inform the user if the input is equal of the valid range
                        System.out.println("Input must be " + min);
                    }
                }
            } catch (NumberFormatException e) {
                // Inform the user if the input is not a valid integer
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    /**
     * Method to get the graduation rank of the candidate.
     *
     * @param msg message to prompt the user for input
     * @param erorMsg error message displayed when input is invalid
     * @return the validated graduation rank
     */
    public String getGraduationRank(String msg, String erorMsg) {
        String gr = null;
        boolean isTrue;
        do {
            isTrue = false;
            try {
                System.out.print(msg);
                gr = MyLib.sc.nextLine().trim();

                if (gr.equalsIgnoreCase("Excellence") || gr.equalsIgnoreCase("Good")
                        || gr.equalsIgnoreCase("Fair") || gr.equalsIgnoreCase("Poor")) {
                    isTrue = true;
                } else {
                    System.out.println(erorMsg);
                }
            } catch (Exception e) {
                System.out.println(erorMsg);
            }
        } while (!isTrue);
        return gr;
    }

    /**
     * Method to check if a candidate code already exists in the id list.
     *
     * @param code the candidate code to check
     * @return true if the code exists in the list, otherwise false
     */
    public boolean checkCode(String code) {

        // Check if the doctorMap contains the provided code
        return idList.contains(code);
    }

    /**
     * Method to search candidates by name or ID.
     *
     * @param thing search keyword (name or ID)
     * @param type the candidate type (Experience, Fresher, Intern)
     * 
     */
    public void searchCandidates(String thing, int type) {

        if (searchedList != null) {
            if (type == 0) {
                for (Experience e : experienceList) {
                    if (e.getFirstName().toLowerCase().contains(thing) && e.getCandidateType() == type) {
                        searchedList.add(e);
                    } else if (e.getLastName().toLowerCase().contains(thing) && e.getCandidateType() == type) {
                        searchedList.add(e);
                    }
                }
            }

            if (type == 1) {
                for (Fresher f : fresherList) {
                    if (f.getFirstName().toLowerCase().contains(thing) && f.getCandidateType() == type) {
                        searchedList.add(f);
                    } else if (f.getLastName().toLowerCase().contains(thing) && f.getCandidateType() == type) {
                        searchedList.add(f);
                    }
                }
            }

            if (type == 2) {
                for (Intern i : internList) {
                    if (i.getFirstName().toLowerCase().contains(thing) && i.getCandidateType() == type) {
                        searchedList.add(i);
                    } else if (i.getLastName().toLowerCase().contains(thing) && i.getCandidateType() == type) {
                        searchedList.add(i);
                    }
                }
            }
        }
    }

    /**
     * Method to print the list of candidates categorized by type.
     */
    public void printList() {
        System.out.println("List of candidate: ");
        if (!experienceList.isEmpty()) {
            System.out.println("===========EXPERIENCE CANDIDATE===========");
            for (Experience e : experienceList) {
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }
        }
        if (!fresherList.isEmpty()) {
            System.out.println("==========FRESHER CANDIDATE===============");
            for (Fresher f : fresherList) {
                System.out.println(f.getFirstName() + " " + f.getLastName());
            }
        }
        if (!internList.isEmpty()) {
            System.out.println("===========INTERN CANDIDATE===============");
            for (Intern i : internList) {
                System.out.println(i.getFirstName() + " " + i.getLastName());
            }
        }
    }

    /**
     * Method to print a table of candidates found based on search criteria.
     *
     * @param thing the search keyword (name or ID)
     * @param type the candidate type (Experience, Fresher, Intern)
     * @throws Exception if an error occurs during the printing
     */
    public void printTable(String thing, int type) throws Exception {

        this.searchCandidates(thing, type);

        String line = "+-----+---------------+---------+--------------------+----------+--------------------+---------------+\n";

        System.out.println("The candidates found:");
        System.out.print(line);
        System.out.printf("|%-5s|%-15s|%-9s|%-20s|%-10s|%-20s|%-15s|\n",
                "No.", "Fullname", "Birthdate", "Address", "Phone", "Email", "Type");
        System.out.print(line);

        for (int i = 0; i < searchedList.size(); i++) {
            System.out.print(searchedList.get(i));
        }
        System.out.print(line);
        searchedList.clear();
    }
}
