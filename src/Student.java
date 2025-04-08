public class Student {
    private String studentID = "Invalid";
    private String name;
    private int[] marks = new int[6];
    private boolean registered;

    public String getStudentID() {
        return studentID;
    }

    public Student(String name,String studentID, boolean registered) {
        setStudentID(studentID);
        setName(name);
        setRegistered(registered);
    }

    public void setStudentID(String studentID) {
        if (studentID.length() == 8) {
            this.studentID = studentID;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 20) {
            this.name = name.substring(0, 20);
        } else {
            this.name = name;
        }
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 0 && marks[i] <= 100) {
                this.marks[i] = marks[i];
            }
        }
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    private String printMarks() {
        String output = "";
        for (int i = 0; i < marks.length; i++) {
            output += marks[i] + " ";
        }
        return output;
    }

    @Override
    public String toString() {
        String registerMessage;

        if (registered) {
            registerMessage = " is a registered student";
        } else {
            registerMessage = " is not a registered student";
        }

        return "Student : " + name +
                ", ID : " + studentID +
                registerMessage +
                ", List of student marks: " + printMarks();
    }

    public double calculateAverage() {
        double sum = 0;

        for (int i = 0; i < 6; i++) {
            sum += marks[i];
        }

        return sum / 6;
    }

    public boolean hasPassedCourse() {
        for (int i = 0; i < 6; i++) {
            if (marks[i] < 40) {
                return false;
            }
        }
        return true;
    }

    public boolean canPassByCompensation() {
        int notPassedCount = 0;
        double notPassedMarks = 0;
        double passedMarks = 0;

        for (int i = 0; i < 6; i++) {
            if (marks[i] < 35) {
                return false;
            } else if (marks[i] < 40) {
                notPassedCount += 1;
                notPassedMarks += (40 - marks[i]);
            } else {
                passedMarks += (marks[i] - 40);
            }
        }

        if (notPassedCount > 2) {
            return false;
        } else if (passedMarks < notPassedMarks * 2) {
            return false;
        } else {
            return true;
        }
    }
}
