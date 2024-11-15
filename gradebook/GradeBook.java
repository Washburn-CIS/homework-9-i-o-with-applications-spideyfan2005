import java.util.Scanner;
import java.io.*;

public class GradeBook {
    private static Student[] students;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // TODO: initialize students from contents of grades.txt file

        try
        {
            File myFile = new File("grades.txt");
            Scanner fin = new Scanner(myFile);

            while (fin.hasNext())
            {
                students = new Student[] { new Student(), new Student() };
                students[0].setFirstName(fin.nextLine());
                students[0].setLastName(fin.nextLine());
                //students[0].setGrade(Double.parseDouble(fin.nextLine()));
                students[1].setFirstName(fin.nextLine());
                students[1].setLastName(fin.nextLine());
                //students[1].setGrade(Double.parseDouble(fin.nextLine()));
            }

        }catch (FileNotFoundException e)
        {
            System.out.println("ERROR: File not found");
            System.exit(1);
        }

        System.out.println("Welcome to the CM111 Grade Book App!");

        while(true) {
            System.out.println("\nPlease make a selection:\n");
            System.out.println("1) List Class Grades");
            System.out.println("2) Update Grade");
            System.out.println("3) Exit");
            System.out.print("\nPlease choose an option: ");
            String choice = input.nextLine();
            System.out.println();
            switch(choice) {
                case "1": 
                    for(Student student: students) {
                        System.out.printf("%s, %s: %f%n", student.getLastName(), 
                                                        student.getFirstName(), 
                                                        student.getGrade());
                    }
                    break;
                case "2":
                    System.out.println("Enter First Name: ");
                    String fname = input.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lname = input.nextLine();
                    
                    for(Student student: students) {
                        if(student.getFirstName().equals(fname) &&
                           student.getLastName().equals(lname)) {
                           System.out.println("Enter Grade: ");
                           student.setGrade(Double.parseDouble(input.nextLine()));
                           System.out.println("Grade updated");
                           continue;
                        }
                    }
                    System.out.println("Student not found");
                    break;
                case "3":
                    // Challenge: write code to save the grades to grades.txt
                    System.out.println("Goodbye!");
                    return;

            }
        }
    }
}
