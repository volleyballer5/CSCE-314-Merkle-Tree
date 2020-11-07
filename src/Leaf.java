import java.util.Vector;

public class Leaf extends BinaryNode {
	
	private Vector<String> data;
	
	Leaf(Vector<String> data)
	{
		this.data = data;
	}

	public Vector<String> getData() {
		return data;
	}

	public void setData(Vector<String> data) {
		this.data = data;
	}
	
	public void addData(String datum)
	{
		
	}
	
	public Leaf duplicate()
	{
		return this;
	}

	public boolean equals(Leaf leaf)
	{
		return false;
	}
	
	public String toString()
	{
		return "implement me";
	}
	
}
