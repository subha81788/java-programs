/*
 * The Quicksort is used by Arrays.sort for sorting primitive collections because stability isn't required (you won't
 * know or care if two identical ints were swapped in the sort)
 * MergeSort or more specifically TimSort is used by Arrays.sort for sorting collections of objects. Stability is required.
 * Quicksort does not provide for stability, TimSort does.
 * Collections.sort delegates to Arrays.sort which is why you see the javadoc referencing the MergeSort i.e TimSort.
 */

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
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Force Awakens", 8.3, 2015));
        movieList.add(new Movie("Star Wars", 8.7, 1977));
        movieList.add(new Movie("Empire Strikes Back", 8.8, 1980));
        movieList.add(new Movie("Return of the Jedi", 8.4, 1983));
 
        // By default sort movies by year
        Collections.sort(movieList);
 
        System.out.println("Movies after year wise sorting : ");
        movieList.forEach(movie -> System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear()));

        //Compare Movies by ascending order of their ratings
        Comparator<Movie> ratingCompare = (Movie m1, Movie m2)->{
            if (m1.getRating() > m2.getRating()) return 1;
            if (m1.getRating() < m2.getRating()) return -1;
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

/* Output
Movies after year wise sorting : 
Star Wars 8.7 1977
Empire Strikes Back 8.8 1980
Return of the Jedi 8.4 1983
Force Awakens 8.3 2015


Movies after rating wise sorting : 
Force Awakens 8.3 2015
Return of the Jedi 8.4 1983
Star Wars 8.7 1977
Empire Strikes Back 8.8 1980


Movies after name wise sorting : 
Empire Strikes Back 8.8 1980
Force Awakens 8.3 2015
Return of the Jedi 8.4 1983
Star Wars 8.7 1977
 */
