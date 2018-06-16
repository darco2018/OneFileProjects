import java.util.Objects;


public class Pair<F,S> implements Comparable<Pair<F,S>>{
	
	private F first;
	private S second;
	
	public Pair(F first, S second){
		
		this.first = first;
		this.second = second;
	}
	
	public F getFirst(){
		return first;
	}
	
	public S getSecond(){
		return second;
	}
	
	public void setFirst(F first){
		this.first = first;
	}
	
	public void setSecond(S second){
		this.second = second;
	}
	
	@Override
	public String toString(){
		return first + "," + second;
	}
	
	@Override
	public  int compareTo(Pair<F,S> other){
		
		return 0;
	}
	
	@Override
	public boolean equals(Object other){
		
		if (!(other instanceof Pair)) 
            return false;
		
		Pair<?, ?> p = (Pair<?, ?>) other;
		return Objects.equals(this.getFirst(), p.getFirst()) && 
        		Objects.equals(this.getSecond(), p.getSecond());
		
	}

}
