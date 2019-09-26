package util;

public class Pair<X,Y> {
	
	private X first;
	private Y second;
	
	
	public Pair(X x,Y y) {
		first = x;
		second = y;
	}

	public X getFirst() {
		return first;
	}

	public void setFirst(X first) {
		this.first = first;
	}

	public Y getSecond() {
		return second;
	}

	public void setSecond(Y second) {
		this.second = second;
	}
	

}
