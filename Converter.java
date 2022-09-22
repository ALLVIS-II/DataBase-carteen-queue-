/**
 * @author (Alvis)
 * @version (2/08/2023)
 */
public class Converter
{
    private people Stay;//The value looking after

    private Converter push;//the person behind is push

    public Converter(people putln)
    {
        this.Stay = putln;
        this.push = null;

    }
    public void setFollows(Converter followingMe){
        this.push = followingMe;

    }

    public Converter getFollows(){
        return this.push;
    }

    public people getValue(){
        return this.Stay;
    }
}
