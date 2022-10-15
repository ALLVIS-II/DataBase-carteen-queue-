
/* @author (Alvis)
 * @version (1/06/2022)
 */
import java.io.File;
import java.util.Scanner;

public class project {
    final String myFile = "arrivals.txt";
    public int student_served = 0;//use it in std calculation
    public int teacher_served = 0;//use it in tchr calculation
    int Teacher_served = 0;

    final int Maxline = 70;
    final int object = 4;
    queue cafe;

    public project() {
        cafe = new queue();

        File readTheFile = new File("arrivals.txt");

        try {
            Scanner readfile = new Scanner(readTheFile);
            String writeFile = readfile.nextLine();
            // System.out.println(writeFile);
            while (readfile.hasNextLine()) {
                System.out.println(readfile.nextLine());
            }
        } catch (Exception E) {
            System.out.println("File not find");
        }

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
                        people stdName = new people(true, studentNumber, false);

                        stdName.result();

                        cafe.enqueue(stdName);
                    }

                    for (int y = 1; y <= stuffNumber; y++) {
                        // System.out.println(number);
                        // System.out.println(stuffNumber);
                        people tchrName = new people(false, stuffNumber, true);

                        tchrName.resultII();
                        cafe.enqueue(tchrName);
                    }
                    for (int z = 1; z <= servedNumber; z++) {
                        // System.out.println(number);
                        // System.out.println(servedNumber);

                        people served = cafe.dequeue();

                        if (served.isStd()) {
                            served.result();// how many student get into the queue and when they have been served
                            System.out.println("Average waiting time of student "+ String.format(" ",(student_served > 0)?studentNumber*1.0/student_served:0.00));// ??
                            // How many people get into the queue and when they have been served
                            // How many people(std,tchr) have been served in the queue
                        }

                        if (served.isTchr()) {
                            served.resultII();// how many teacher get into the queue
                            System.out.println("Average waiting time of teacher "+ String.format(" ", (teacher_served > 0)? stuffNumber*1.0 / teacher_served:0.00) );

                        }

                        if (z == servedNumber) {
                            int sum = studentNumber + stuffNumber - stuffNumber;
                            System.out.println("In " + number + "min(s), " + sum + " people are hungry!");
                            System.out.println(" ");
                        }
                        if (z == servedNumber) {
                            System.out.println("-----------------------------------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("In the " + number + " min(s), the average wait time of student is ");
                            System.out.println("In the " + number + " min(s), the average wait time of student is ");
                        }
                    }

                } catch (Exception E) {
                    System.out.println(E);
                }
            }
            //System.out.println(
                    //"In the final cauculation, the average time of student waiting time is 1.2 (1.29353233831)");
            ///System.out.println(
                    //"In the final cauculation, the average time of teacher waiting time is 1.9 (1.90909090909)");

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
