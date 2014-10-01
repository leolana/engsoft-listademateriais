package inf319.listaMateriais;

import java.util.*;

public class PiecePart extends Part {

    private double cost;

    public PiecePart(PartNumber thePartNumber, String theDescription,
                     double theCost) {
        super(thePartNumber, theDescription);
        cost = theCost;
    }

    public Set<Part> getParts() {
	return new HashSet<Part>();
    }

    // Caso trivial que termina a recursão no cálculo de custo de `Assembly`
    public double cost() {
        return cost;
    }

    // Não gosto desse tipo de mutabilidade, mas também não sei qual é a forma
    // idiomática em java de fazer isso.
    public void setCost(double c) {
    	cost = c;
    }
}
