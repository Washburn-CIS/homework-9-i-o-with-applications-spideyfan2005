import java.util.Scanner;
import java.io.*;

public class GradeBook {
    private static Student[] students;

    public static void main(String[] args) 
    {
        // TODO: initialize students from contents of grades.txt file
        try
        {
            File myFile = new File("grades.txt");
            Scanner fin = new Scanner(myFile);

            int numStudents = Integer.parseInt(fin.nextLine());
            students = new Student[numStudents];

            for (int i = 0; i < numStudents; i++)
            {
                String[] tokens = fin.nextLine().split(",");
                students[i] = new Student();
                students[i].setFirstName(tokens[0]);
                students[i].setLastName(tokens[1]);
                students[i].setGrade(Double.parseDouble(tokens[2]));
            }
            fin.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: File not found");
            System.exit(1);
        }

        Scanner input = new Scanner(System.in);

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
                        System.out.printf("%s, %s: %.2f%n", student.getLastName(), 
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

                           //Save grades to grades.txt
                           try 
                           {
                               FileWriter writer = new FileWriter("grades.txt", true);
                               //I have no idea how to get rid of the previous number
                               writer.write(String.valueOf(student.getGrade()));
                               writer.close();
                           }catch (IOException e)
                               {
                                    System.out.println("ERROR"); 
                                    System.exit(1);
                               }
                           System.out.println("Grade updated");
                        }else{
                            System.out.println("Student not found");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;

            }
        }
    }
}
