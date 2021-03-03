package sample;

public class StudentRecord {
    private String StudentID;
    private float Midterm;
    private float Assignmnets;
    private float Final_exam;
    private double Final_Mark;
    private String Letter_grade;

    public StudentRecord(String studentID, float midterm, float Assignmnets, float Final_exam){
        this.StudentID = studentID;
        this.Midterm = midterm;
        this.Assignmnets = Assignmnets;
        this.Final_exam = Final_exam;
        this.Final_Mark = (0.20 * Assignmnets) + (0.5 * Final_exam) + (0.3 * midterm);
        if (this.Final_Mark >= 0 && this.Final_Mark < 50){
            this.Letter_grade = "F";
            }
        else if (this.Final_Mark >= 50 && this.Final_Mark < 60){
            this.Letter_grade = "D";
        }
        else if (this.Final_Mark >= 60 && this.Final_Mark <70){
            this.Letter_grade = "C";
        }
        else if (this.Final_Mark >= 70 && this.Final_Mark <80){
            this.Letter_grade = "B";
        }
        else if (this.Final_Mark >= 80 && this.Final_Mark <= 100){
            this.Letter_grade = "A";
        }

    }

    public String getStudentID() {
        return this.StudentID;
    }

    public float getMidterm() {
        return this.Midterm;
    }

    public float getAssignmnets() {
        return this.Assignmnets;
    }

    public float getFinal_exam() {
        return this.Final_exam;
    }

    public double getFinal_Mark(){
        return  this.Final_Mark;
    }

    public String getLetter_grade(){
        return  this.Letter_grade;
    }

}
