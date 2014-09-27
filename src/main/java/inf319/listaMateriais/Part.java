package inf319.listaMateriais;

import java.util.Comparator;

public abstract class Part implements Comparable<Part> {

    private String description;
    private final PartNumber partNumber;

    public Part(PartNumber thePartNumber, String theDescription) {
        description = theDescription;
        partNumber = thePartNumber;
    }

    public abstract double cost();

    public abstract String list(int indent);

    public String getDescription() {
    	return description;
    }

    public void setDescription(String desc) {
    	description = desc;
    }

    public PartNumber getPartNumber() {
        return partNumber;
    }

    public int compareTo(Part p2) {
        return getPartNumber().compareTo(p2.getPartNumber());
    }
}
