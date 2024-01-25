package EX99_Board.Q2;

import java.util.Objects;

public class Student {
    public int studentNum;
    public String name;

    public Student(int studentNum, String name) {
        this.studentNum = studentNum;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNum);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if(s.studentNum == studentNum){
                return true;
            }
            else{
                return false;
            }
        } else {
            return false;
        }
    }
}
