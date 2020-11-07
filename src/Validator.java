import java.util.Vector;

public class Validator {
	
	MerkleTree update;
	MerkleTree original;
	
	Validator()
	{
		
	}
	
	Validator(MerkleTree update, MerkleTree original)
	{
		this.update = update;
		this.original = original;
	}
	
	public boolean checkPath()
	{
		return false;
	}
	
	public Vector<String> updateOriginal() 
	{
		return null;
	}

}
