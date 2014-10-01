package inf319.listaMateriais;

import static java.util.Collections.sort;
import java.util.LinkedList;

/* A idea desta classe de apresentação é fazer juz ao `Model-View separation
principle` A classe de domínio `Part` não deve, sob hipótese alguma, conhecer
como acontece a sua _apresentação_

A existência dessa classe revela a necessidade de permitir que um consumidor de
`Part` seja capaz de inspecionar as suas sub-partes. Isso é razoável e provavelente
necessário em java se formos persistir `Part` usando um ORM da vida.
 */

public class PartPresenter {
    private Part part;

    public PartPresenter(Part part) {
	this.part = part;
    }

    // Este é o metodo que expõe a apresentação em lista de uma `Part`
    public String list() {
	return list(0, part);
    }

    // Clientes não tem controle sob como se dá a identação das sub-partes.

    // Veja o comentário em Assembly#cost para comparação.
    private String list(int indent, Part parent) {
	String prefix = new String(new char[indent]).replace("\0", " ");

	LinkedList<Part> children = new LinkedList<Part>(parent.getParts());
	sort(children, null);

	String result = prefix + parent.toString();

	for(Part child : children)
	    result += list(indent + 1, child);

	return result;
    }
}
