import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Evaldas on 2015-04-19.
 */
public class Marks {
    private static class stud implements Comparable<stud>{
        public float IR101;
        public float IR102;
        public String name;
        public int ID;
        public boolean pass1(){return IR101>=40;}
        public boolean pass2(){return IR102>=40;}

        public float aggr(){return (IR101+IR102)/2;}

        public String passed(){
            if (aggr() >= 70)
                return "1st";
            else if (aggr() >= 60)
                return "2.1";
            else if (aggr() >= 50)
                return "2.2";
            else if (aggr() >= 40)
                return "3rd";
            else
                return "Fail";
        }

        public int passNum(){
            if(pass1()&& pass2())
                return 2;
            else if(pass1()||pass2())
                return 1;
            else
                return 0;
        }

        public int compareTo(stud students){
            float comp = students.aggr()- aggr();
            return(int)comp;
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<stud> students = new ArrayList<stud>();
        File fl = new File("IRStudents.txt");
        Scanner input = new Scanner(fl);
        stud Student;
        while (input.hasNext()) {
            Student = new stud();
            Student.ID = input.nextInt();
            Student.name = input.next();
            students.add(Student);
        }
        fl = new File("IR101.txt");
        input = new Scanner(fl);
        int ID;
        while(input.hasNext()){
            ID = input.nextInt();
            for(stud student : students ){
                if(student.ID == ID)
                    student.IR101 = input.nextFloat();
            }
        }
        fl = new File("IR102.txt");
        input = new Scanner(fl);
        while(input.hasNext()){
            ID = input.nextInt();
            for(stud student : students ){
                if(student.ID == ID)
                    student.IR102 = input.nextFloat();
            }
        }
        Collections.sort(students);
        for(stud student : students ){
            System.out.println(student.ID + " " + student.name);
            System.out.printf("IR101 %.1f IR102 %.1f aggregate %.1f\n", student.IR101, student.IR102, student.aggr());
            System.out.printf("Class: %s Outcome: ", student.passed());
            if (student.passNum() == 2)
                System.out.println("Proceed to Stage 2");
            else if (student.passNum() == 0)
                System.out.println("Repeat Year");
            else if (!student.pass1())
                System.out.println("Resit IR101");
            else if (!student.pass2())
                System.out.println("Resit IR102");
            System.out.println("---------------------------------------");
        }
    }
}
