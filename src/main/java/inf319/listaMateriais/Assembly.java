package inf319.listaMateriais;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Assembly extends Part {

    private Set<Part> parts;

    public Assembly(PartNumber thePartNumber, String theDescription) {
        super(thePartNumber, theDescription);
        parts = new HashSet<Part>();
    }

    public double cost() {
        double totalCost = 0;
        for (Iterator<Part> i = parts.iterator(); i.hasNext(); ) {
            Part part = (Part) i.next();
            totalCost += part.cost();
        }
        return totalCost;
    }

    public String list(int indent) {
	String result;

	result = new String(new char[indent]).replace("\0", " ");

	result +=
	    "Part: " + getPartNumber().getNumber() +
	    "; Descrição: " + getDescription() +
	    "; Cost:" + cost()
	    + "\n";

	for(Iterator<Part> i = parts.iterator(); i.hasNext();) {
	    Part part = (Part) i.next();
	    result += part.list(indent + 1);
	}

	return result;
    }

    public void addPart(Part thePart) {
        parts.add(thePart);
    }

    public Set<Part> getParts() {
        return parts;
    }
}
