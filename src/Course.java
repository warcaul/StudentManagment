public class Course {
    private int studentCount = 0;
    private String courseName;
    private Student[] students;

    public Course(String courseName, int numberOfStudents) {
        this.courseName = courseName;
        if (numberOfStudents <= 1 || numberOfStudents > 30) {

            students = new Student[30];
        } else {
            students = new Student[numberOfStudents];
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private boolean isValidIndex(int index) {
        return (index >= 0 && index < studentCount);
    }

    private boolean isEmpty() {
        return studentCount == 0;
    }

    private boolean isFull() {
        return studentCount == students.length;
    }

    public boolean addStudent(Student student) {
        if (isFull()) {
            return false;
        } else {
            students[studentCount] = student;
            studentCount++;
            return true;
        }
    }

    public String listStudents() {
        if (isEmpty()) {
            return "No students " + "\n";
        } else {
            String output = "";
            for (int i = 0; i < studentCount; i++) {
                output = output + i + ": " + students[i].toString() + "\n";
            }
            return output;
        }
    }

    public String listCurrentStudents() {
        if (isEmpty()) {
            return "No students" + "\n";
        } else {
            String output = "";
            for (int i = 0; i < studentCount; i++) {
                if (students[i].isRegistered()) {
                }
                output = output + students[i].toString() + "\n";
            }
            return output;
        }
    }

    public String listOfStudentsWhoPassedTheCourse() {
        if (isEmpty()) {
            return "No students" + "\n";
        } else {
            String output = "";
            for (int i = 0; i < studentCount; i++) {
                if (students[i].isRegistered()) {
                    if (students[i].hasPassedCourse()) {
                        output = output + students[i].getName() + ": Passed" + "\n";
                    } else if (students[i].canPassByCompensation()) {
                        output = output + students[i].getName() + ": Passed by compensation" + "\n";
                    }
                }
            }
            return output;
        }
    }

    public String listOfStudentsWithAverageMark() {
        if (isEmpty()) {
            return "No students" + "\n";
        } else {
            String output = "";
            for (int i = 0; i < studentCount; i++) {
                output = output + students[i].getName() + ": " + students[i].calculateAverage() + "\n";
            }
            return output;
        }
    }

    public String listStudentsAboveGivenAverageMark(double pointMark) {
        if (isEmpty()) {
            return "No students" + "\n";
        } else {
            String output = "";
            for (int i = 0; i < studentCount; i++) {
                if (students[i].calculateAverage() >= pointMark) {
                    output = output + students[i].toString() + "\n";
                }
            }
            return output;
        }
    }

    public Student studentWithLowestAverageMark() {
        if (isEmpty()) {
            return null;
        } else {
            int minMarkIndex = 0;

            for (int i = 0; i < studentCount; i++) {
                if (students[i].calculateAverage() < students[minMarkIndex].calculateAverage()) {
                    minMarkIndex = i;
                }
            }


            return students[minMarkIndex];
        }
    }


    public Student studentWithHighestAverageMark() {
        int maxMarkIndex = 0;

        if (isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < studentCount; i++) {
                if (students[i].calculateAverage() > students[maxMarkIndex].calculateAverage()) {
                    maxMarkIndex = i;
                }
            }
            return students[maxMarkIndex];
        }
    }

    public double calculateCourseAverage() {
        if (isEmpty()) {
            return -1;
        } else {

            double sum = 0;
            for (int i = 0; i < studentCount; i++) {
                sum += students[i].calculateAverage();
            }
            return sum / studentCount;
        }
    }


    public Student getStudent(int index) {
        if (isValidIndex(index)) {
            return students[index];
        } else {
            return null;
        }
    }

    public Student deRegisterStudent(int index) {
        if (isValidIndex(index)) {
            if (students[index].isRegistered()) {
                students[index].setRegistered(false);
                return students[index];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public Student registerStudent(int index) {

        if (isValidIndex(index)) {
            if (!students[index].isRegistered()) {
                students[index].setRegistered(true);
                return students[index];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
