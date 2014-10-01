package inf319.listaMateriais;

///////////////////////////////////////////////////////////////////
/// Existe uma solução alternativa no branch `desaf` deste repo ///
///////////////////////////////////////////////////////////////////

// Não sei se esse .* é eficiente, mas ficar importando classe a classe é muito chato e sujo.
import java.util.*;

public abstract class Part implements Comparable<Part> {
    private String description;
    private final PartNumber partNumber;

    public Part(PartNumber thePartNumber, String theDescription) {
        description = theDescription;
        partNumber = thePartNumber;
    }

    public abstract double cost();

    // O tipo `Part' deve fornecer uma maneira de acessar suas sub-partes.
    // Sem esse mecanismo, fica impossivel desacoplar a apresentacao em forma de lista
    // da estrutura interna.
    public abstract Set<Part> getParts();

    public String getDescription() {
    	return description;
    }

    public String toString() {
	return new StringBuilder()
	    .append("Part: ")
	    .append(getPartNumber().getNumber())
	    .append("; Descrição: ")
	    .append(getDescription())
	    .append("; Cost:")
	    .append(cost())
	    .append("\n")
	    .toString();
    }

    public void setDescription(String desc) {
    	description = desc;
    }

    public PartNumber getPartNumber() {
        return partNumber;
    }

    // Comparação é delegada para os PartNumbers, conforme requisito.
    public int compareTo(Part p2) {
        return getPartNumber().compareTo(p2.getPartNumber());
    }
}
