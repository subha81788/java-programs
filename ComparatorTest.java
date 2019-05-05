import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;
 
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
 
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
 
    // Used to sort movies by year
    public int compareTo(Movie m) {
        return this.year - m.year;
    }
}
 
class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Force Awakens", 8.3, 2015));
        movieList.add(new Movie("Star Wars", 8.7, 1977));
        movieList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        movieList.add(new Movie("Return of the Jedi", 8.4, 1983));
 
        Collections.sort(movieList);
 
        System.out.println("Movies after year wise sorting : ");
        movieList.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()));

        //Compare Movies by rating
        Comparator<Movie> ratingCompare = (Movie m1, Movie m2)->{
            if (m1.getRating() < m2.getRating()) return -1;
            if (m1.getRating() > m2.getRating()) return 1;
            else return 0;
        };
        movieList.sort(ratingCompare);
        System.out.println("\n\nMovies after rating wise sorting : ");
        movieList.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()));

        //Compare Movies by name
        Comparator<Movie> nameComparator = (Movie m1, Movie m2)->m1.getName().compareTo(m2.getName());
        movieList.sort(nameComparator);
        System.out.println("\n\nMovies after name wise sorting : ");
        movieList.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()));
    }
}
