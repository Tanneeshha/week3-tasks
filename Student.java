public class Student{
    private String name;
    private int standard;
    private int rollno;
    private int age;
    private double[] grades;

    public Student(String name, int standard, int rollno, int age, double[] grades){
        this.name =  name;
        this.age = age;
        this.standard = standard;
        this.rollno = rollno;
        this.grades = grades;
    }

    public double calculateAverageGrade(){
        double sum = 0;
        for (double grade : grades){
            sum += grade;
        }
        return grades.length > 0 ? sum / grades.length : 0;
    }

    public void displayInfo(){
        System.out.println("Student Information");
        System.out.println("--------------------------");
        System.out.println("Student Name: " + name); 
        System.out.println("Student Class: " + standard ); 
        System.out.println("Roll Number: " + rollno );
        System.out.println("Age: " + age );
        System.out.println("Average Grade: " + calculateAverageGrade());
    }

    public class Main {
        public static void main(String[] args) {
            Student student = new Student("Student 1", 5, 20, 10, new double[]{85, 90, 78});
            student.displayInfo();
        }
    }
}