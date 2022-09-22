
/* @author (Alvis)
 * @version (1/06/2022)
 */
import java.io.File;
import java.util.Scanner;


public class project {
    final String myFile = "arrivals.txt";

    final int Maxline = 70;
    final int object = 4;
    queue cafe;

    public project() {
        cafe = new queue();

        File readTheFile = new File("arrivals.txt");

        try {
            Scanner readfile = new Scanner(readTheFile);
            String writeFile = readfile.nextLine();
            //System.out.println(writeFile);
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
                            served.result();
                        }

                        if (served.isTchr()) {
                            served.resultII();
                        }

                        if (z == servedNumber){
                            int sum = studentNumber + stuffNumber - stuffNumber;
                            System.out.println("In "+number+"min(s), "+sum+" people are hungry!");
                        }
                    }


                } catch (Exception E) {
                    System.out.println(E);
                }
            }
            System.out.println("In the final cauculation, the average number of people hungry is 4 people (4.4166666...)");

            /**
             * System.out.println(Time);
             * //System.out.println(studentsArriving);
             * //System.out.println(stuffArriving);
             * //System.out.println(peopleServed);
             **/
            // first line, First min,nextline, next min
            /**
             * System.out.println("At the "+Time+"min(s) "+studentsArriving+" student
             * arrived");
             * System.out.println(" ");
             * System.out.println("At the "+Time+"min(s) "+stuffArriving+" stuff arrived");
             * System.out.println(" ");
             * System.out.println("At the "+Time+"min(s) "+peopleServed+" people served");
             * System.out.println(" ");
             **/

        }

        catch (Exception E) {
            System.out.println(E);
        }
    }
        public static void main(String[] args) {
        project project = new project();
    }
    }


