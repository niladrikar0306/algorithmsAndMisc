package org.niladri.test1;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Test3
{ 
	/*// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN AN EMPTY SET IF NO SIMILAR MOVIE TO THE GIVEN MOVIE IS FOUND
	public Set<Movie> getMovieRecommendations (Movie movie, int N) 
	{
		List<Movie> sm = movie.getSimilarMovies();
		List<Solution.myClass> rat = new ArrayList<Solution.myClass>();
		Set<Movie> rec = new  HashSet<Movie>();
		int i = 0;
		for(i=0;i<sm.size();i++){
		    rat.add(new Solution.myClass(sm.get(i).getRating(), sm.get(i)));
		}
		Collections.sort(rat);
		int j = 0;
		int n = 0;
		for(j=rat.size() - 1;j==0;j--){
		    if(movie.getRating>rat.get(j).getRating){
		        rec.add(rat.get(j).getMovie());
		        n++;
		        
		    }
		    if(n==N){
		        break;
		    }
		}
		return rec;
		
	}
	// METHOD SIGNATURE ENDS
	
	public class myClass implements Comparable<myClass> {
	    
	    Float f;
	    Movie m;
	    
	    public myClass(Float f, Movie m){
	        this.f= f;
	        this.m = m;
	    }
	    
	    public float getRating(){
	        return f;
	    }
	    
	    public Movie getMovie(){
	        return m;
	    }
	    public int compareTo(myClass o) {
	    	
	        if(o.f==this.f){
	            return 0;
	        }
	        else {
	           return this.f > o.f ? 1 :-1;
	        }
	    }
	    
	    
	}*/
}