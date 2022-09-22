/* *
 * @author (Alvis)
 * @version (8/7/'23)
 */


public class people {
    private int tm;
    private boolean tchr;
    private boolean std;
    // private boolean done;
    // private String tchr;

    /**
     * Constructor for objects of class people
     */
    public people(boolean student, int time, boolean teacher) {
        this.tm = time;
        this.std = student;

    }

    public people(boolean teacher, int time) {
        this.tm = time;
        this.tchr = teacher;
    }

    public void result() {
        System.out.println("At the " + this.tm + "min(s) " + this.std + " student arrived");

        System.out.println(" ");

        // return new people(std, tm, false);
    }

    public void resultII() {
        System.out.println("At the " + this.tm + "min(s) " + this.tchr + " teacher arrived");

        System.out.println(" ");

        // return new people(tchr,tm, false);
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public boolean isTchr() {
        return tchr;
    }

    public void setTchr(boolean tchr) {
        this.tchr = tchr;
    }

    public boolean isStd() {
        return std;
    }

    public void setStd(boolean std) {
        this.std = std;
    }
}
