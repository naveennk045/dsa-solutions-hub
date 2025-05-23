package problems.companywise.servicenow;

public class Movie {
    public String name;
    public String genre;
    public String actor;
    public float rating;
    public String budget;
    public boolean isHit;

    public Movie(String name, String genre, String actor, float rating, String budget, boolean isHit) {
        this.name = name;
        this.genre = genre;
        this.actor = actor;
        this.rating = rating;
        this.budget = budget;
        this.isHit = isHit;
    }


    public void display(){
        System.out.println("Name : " +name+"\n"+"Genre : "+genre+"\n"+"Actor : "+actor+"\n"+"Rating : "+rating+"\n"+"Budget : "+budget+"\n"+"Hit or Flop : "+isHit+"\n");
    }

}