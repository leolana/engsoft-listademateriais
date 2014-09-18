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
    
    public void addPart(Part thePart) {
        parts.add(thePart);
    }
    
    public Set<Part> getParts() {
        return parts;
    }
}
