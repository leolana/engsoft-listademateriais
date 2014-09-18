package inf319.listaMateriais;

public abstract class Part {

    private String description;
    private final PartNumber partNumber;
    
    public Part(PartNumber thePartNumber, String theDescription) {
        description = theDescription;
        partNumber = thePartNumber;
    }
    
    public abstract double cost();

    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String desc) {
    	description = desc;
    }

    public PartNumber getPartNumber() {
        return partNumber;
    }
}
