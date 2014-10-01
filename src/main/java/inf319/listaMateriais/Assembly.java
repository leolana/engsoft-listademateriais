package inf319.listaMateriais;

import java.util.*;

// Essa é a classe que permite a manipulação da lista de subpartes com #addPart.
// Pode-se argumentar que essa classe faz muito pouco diferente de `Part` e
// poderia ser unida com ela.

// Eu acredito que a separação 'força' a idéia que `Part` é somente leitura, e
// não pode ser alterada diretamente.

public class Assembly extends Part {
    private Set<Part> parts;

    public Assembly(PartNumber thePartNumber, String theDescription) {
        super(thePartNumber, theDescription);
        parts = new HashSet<Part>();
    }

    // Pode-se argumentar que a implementação de Assembly#cost é muito similar a
    // PartPresenter#list e que PartPresenter seria desnecessária. Aqui eu quero
    // fazer uma distinção: Apesar de as implementações serem identicas (afinal,
    // ambas são um reduce nos filhos) a lógica que em Assembly#cost se
    // manifesta é uma lógica que define o 'comportamento' de um objeto do tipo
    // Assembly. O custo de um Assembly é uma redução no custo de suas partes.
    // Já em PartPresenter#list, a recursão ocorre por um mero 'acidente' da
    // forma como se deseja a apresentação textual do objeto, e não tem nenhuma
    // relevância do ponto de vista da especificação de como um objeto do tipo
    // Part deve se 'comportar'.

    // ps: Esse método certamente não é thread-safe...
    public double cost() {
        double totalCost = 0;

	// Em ruby isso tudo seria:
	// `parts.map(&:cost).reduce(&:+)`.

	for (Part part : parts)
            totalCost += part.cost();

	return totalCost;
    }

    public void addPart(Part thePart) {
	parts.add(thePart);
    }

    public Set<Part> getParts() {
	return parts;
    }
}
