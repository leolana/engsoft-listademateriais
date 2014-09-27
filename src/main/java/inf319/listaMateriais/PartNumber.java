package inf319.listaMateriais;

import java.util.Comparator;

public class PartNumber implements Comparable<PartNumber> {

    private int number;

    public PartNumber(int theNumber) {
        number = theNumber;
    }

    public int getNumber() {
        return number;
    }

    public int compareTo(PartNumber n2) {
        return getNumber() - n2.getNumber();
    }
}
