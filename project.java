
/* @author (Alvis)
 * @version (1/06/2022)
 */
import java.io.File;
import java.util.Scanner;
import java.util.Queue;

public class project {
    final String myFile = "arrivals.txt";
    public int student_served = 0;//use it at how many student get served
    public int teacher_served = 0;//use it at how many teacher get served
    public int student_wait = 0;//How long does all the student waited
    public int teacher_wait = 0;//how long does all the teacher waited
    ;

    final int Maxline = 70;
    final int object = 4;
    private static queue queue=new queue();
    queue cafe;

    public project() {
        cafe = new queue();

        File readTheFile = new File("arrivals.csv");

        /*try {
            Scanner readfile = new Scanner(readTheFile);
            String writeFile = readfile.nextLine();
            // System.out.println(writeFile);
            while (readfile.hasNextLine()) {
                System.out.println(readfile.nextLine());
            }
        } catch (Exception E) {
            System.out.println(E);
        }*/

        File newfile = new File(myFile);
        String CSVline[] = new String[Maxline];
        int lineCount = 0;

        try {
            Scanner readSys = new Scanner(newfile);// open file with Scanner

            while (readSys.hasNextLine() && lineCount < Maxline) {
                // scanning a line can make the system easier to run Check and rebuild the
                // "print" easily
                String line = readSys.nextLine();
                CSVline[lineCount] = line;
                lineCount++;
                

            }
        } catch (Exception E) {
            System.out.println(E);
        }
        
        // make out [,]
        try {
            for (int i = 1; i < lineCount; i++) {
                String values[] = CSVline[i].split(",");
                System.out.println(CSVline[i]);
                String time = values[0];
                String studentsArriving = values[1];
                String stuffArriving = values[2];
                String peopleServed = values[3];

                // String convert to interger
                try {
                    Scanner myscn = new Scanner(System.in);
                    String str = myscn.nextLine();
                    Integer number = Integer.valueOf(time);
                    int studentNumber = Integer.parseInt(studentsArriving);

                    int stuffNumber = Integer.parseInt(stuffArriving);
                    int servedNumber = Integer.parseInt(peopleServed);

                    for (int x = 1; x <= studentNumber; x++) {
                        // System.out.println(number);
                        // System.out.println(studentNumber);
                        people stdName = new people(true, number, false);

                        stdName.result();

                        cafe.enqueue(stdName);
                    }

                    for (int y = 1; y <= stuffNumber; y++) {
                        // System.out.println(number);
                        // System.out.println(stuffNumber);
                        people tchrName = new people(false, number, true);

                        tchrName.resultII();
                        cafe.enqueue(tchrName);
                    }
                    for (int z = 1; z <= servedNumber; z++) {
                        // System.out.println(number);
                        // System.out.println(servedNumber);

                        people served = cafe.dequeue();
                        
                        
                        if (served.isStd()) {
                            served.result();// how many student get into the queue and when they have been served
                            student_served++;
                            student_wait += number - served.getTm();
                            //int stdGetIn = student_wait++;
                            //int std_served = number - (served.getTm);
                            System.out.println("current time is  = "+number);
                            System.out.println("The time student waited is : "+ (number - served.getTm()));
                            System.out.println();
                            //curent time and the people time get in 
                            // How many people get into the queue and when they have been served
                            // How many people(std,tchr) have been served in the queue
                        }

                        if (served.isTchr()) {
                            served.resultII();// how many teacher get into the queue
                            teacher_served++;
                            teacher_wait += number - served.getTm();
                            System.out.println("current time is  = "+number);
                            System.out.println("The time teacher waited is : "+ (number - served.getTm()));
                            System.out.println("here is the teacher");
                        }

                        
                        if (z == servedNumber) {
                            System.out.println("-----------------------------------------------------------------------------\n");
                            System.out.println("Total served = "+ servedNumber + "\n");
                            
                        }
                        
                        System.out.println("In "+number+ " min(s)\n");
                        System.out.println("Student result\n");
                        System.out.println(studentNumber + " student come");
                        System.out.println("average wait time :" + (float)student_wait / student_served);
                        System.out.println("Total served of student : " + student_served);
                        System.out.println("total amount of student wait : " + student_wait + "\n");
                        
                        
                        
                        System.out.println("Teacher result\n");
                        System.out.println(stuffNumber + " teacher come");
                        System.out.println("average wait time :" + (float)teacher_wait / teacher_served);
                        System.out.println("Total served of teacher : " + teacher_served);
                        System.out.println("total amount of teacher wait : " + teacher_wait);
                        
      
                        
                    }

                } catch (Exception E) {
                    System.out.println(E);
                }
            }
           
            //people served need teacher ++, student ++ finailly print out 
        }

        catch (Exception E) {
            System.out.println(E);
        }
    }
  //Vsc running System overhere
    public static void main(String[] args) {
        project project = new project();
    }
}
