import java.text.DecimalFormat;
import java.util.Scanner;

public class Driver {
    /**
     Name : Roman Aleinykov
     Student id : 20111631
     Programme and group : Computer Science W1
     Statement of understanding : This work is my own (adapted from class notes).
     I fully understand the code - the syntax and how it works and am happy to explain any part if asked
     **/

    Course course;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Driver driver = new Driver();
    }

    public Driver() {
        processCourse();
        runMenu();
    }

    private int mainMenu() {
        System.out.print("""
                Shop Menu
                ---------
                   1) Add a student
                   2) Add student marks
                   3) Add a student to the course (Register)
                   4) Remove a student from the course (De-Register)
                   5) List all students
                   6) List the student that are currently enrolled in a course
                   7) List students whose average mark is greater than a given mark
                   8) List students' names with their average mark
                   9) Display average student marks
                   10) Display student with the lowest average mark
                   11) Display student with the highest average mark
                   12) List the students' names who has passed the score
                   0) Exit
                ==>> """);
        return input.nextInt();
    }

    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> addStudent();
                case 2 -> addStudentMarks();
                case 3 -> addStudentToCourse();
                case 4 -> removeStudentFromCourse();
                case 5 -> printStudents();
                case 6 -> printCurrentStudents();
                case 7 -> printStudentsWithAverageMarkAboveAGivenMark();
                case 8 -> printStudentsWithAverageMark();
                case 9 -> printAverageStudentMark();
                case 10 -> printStudentWithLowestMark();
                case 11 -> printStudentWithHighestMark();
                case 12 -> printStudentsWhoPassedCourse();

                default -> System.out.println("Invalid option entered: " + option);
            }


            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();

            option = mainMenu();
        }


        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void processCourse() {
        System.out.print("What is the name of the course:  ");
        String courseName = input.next();
        System.out.print("How many students would you like to add? ");
        int numberStudents = input.nextInt();

        course = new Course(courseName, numberStudents);

        System.out.print("Enter any to continue: ");

    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String studentName = input.next();
        System.out.print("Enter student ID: ");
        String studentID = input.next();
        System.out.print("Is register (Y/N)");
        char currentStudent = input.next().charAt(0);
        boolean isRegister = false;
        if ((currentStudent == 'y') || (currentStudent == 'Y'))
            isRegister = true;

        boolean isAdded = course.addStudent(new Student(studentName, studentID, isRegister));

        if (isAdded) {
            System.out.println("Student Added Successfully");
        } else {
            System.out.println("No Student Added");
        }

    }

    private void addStudentMarks() {
        System.out.print(course.listStudents());
        System.out.print("Enter student`s number from a list : ");
        int indexStudent = input.nextInt();

        int[] marks = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Mark " + (i + 1) + ": ");
            marks[i] = input.nextInt();
        }

        course.getStudent(indexStudent).setMarks(marks);
        System.out.print(course.getStudent(indexStudent));
    }

    private void addStudentToCourse() {
        System.out.print(course.listStudents());
        System.out.print("Enter student`s number from a list : ");
        int indexStudent = input.nextInt();

        course.registerStudent(indexStudent);
        System.out.print(course.getStudent(indexStudent));
    }

    private void removeStudentFromCourse() {
        System.out.print(course.listStudents());
        System.out.print("Enter student`s number from a list : ");
        int indexStudent = input.nextInt();

        course.deRegisterStudent(indexStudent);
        System.out.print(course.getStudent(indexStudent));
    }

    private void printStudents() {
        System.out.print(course.listStudents());
    }

    private void printCurrentStudents() {
        System.out.print(course.listCurrentStudents());
    }

    private void printStudentsWithAverageMarkAboveAGivenMark() {
        System.out.print("Enter a Mark");
        double givenMark = input.nextDouble();

        System.out.print(course.listStudentsAboveGivenAverageMark(givenMark));
    }

    private void printStudentsWithAverageMark() {
        System.out.print(course.listOfStudentsWithAverageMark());
    }

    private void printAverageStudentMark() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.print("The average student mark is " + numberFormat.format(course.calculateCourseAverage()));
    }

    private void printStudentWithLowestMark() {
        System.out.print(course.studentWithLowestAverageMark());
    }

    private void printStudentWithHighestMark() {
        System.out.print(course.studentWithHighestAverageMark());
    }

    private void printStudentsWhoPassedCourse() {
        System.out.print("Students who passed:" + "\n");
        System.out.print(course.listOfStudentsWhoPassedTheCourse());

    }
}
