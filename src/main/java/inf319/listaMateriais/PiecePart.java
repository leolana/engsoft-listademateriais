package inf319.listaMateriais;

public class PiecePart extends Part {

    private double cost;

    public PiecePart(PartNumber thePartNumber, String theDescription,
                     double theCost) {
        super(thePartNumber, theDescription);
        cost = theCost;
    }

    public double cost() {
        return cost;
    }

    public void setCost(double c) {
    	cost = c;
    }

    public String list(int indent) {
	String result;

	result = new String(new char[indent]).replace("\0", " ");

	result +=
	    "Part: " + getPartNumber().getNumber() +
	    "; Descrição: " + getDescription() +
	    "; Cost:" + cost() +
	    "\n";

	return result;
    }
}
