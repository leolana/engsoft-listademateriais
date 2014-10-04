package inf319.listaMateriais;

import junit.framework.TestCase;

/**
 *   Esta versão da lista de materiais contém a solução
 *   do exercício 1.
 */

public class IPartTest extends TestCase {

    public void testPart() {
        PartNumber number = new PartNumber(42);
        Part part = new PiecePart(number, "description", 23);
        assertEquals(42, part.getPartNumber().getNumber());
        assertEquals("description", part.getDescription());
        part.setDescription("new description");
        assertEquals("new description", part.getDescription());
    }

    public void testPiecePart() {
        PartNumber number = new PartNumber(42);
        PiecePart part = new PiecePart(number, "description", 23);
        assertEquals(23, part.cost(), 0);
        part.setCost(5);
        assertEquals(5, part.cost(), 0);
    }

    public void testAssembly() {
        PartNumber number1 = new PartNumber(23);
        PartNumber number2 = new PartNumber(42);
        PartNumber number3 = new PartNumber(69);

        Assembly assembly1 = new Assembly(number1, "assembly1");
        Assembly assembly2 = new Assembly(number2, "assembly2");
        Assembly assembly3 = new Assembly(number3, "assembly3");

        for (int i = 0; i < 10; i++) {
            assembly1.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
        }
        assertEquals(((9 + 0) * 10)/2, assembly1.cost(), 0);

        for (int i = 10; i < 20; i++) {
            assembly2.addPart(new PiecePart(new PartNumber(i), "pp" + i, i));
        }
        assertEquals(((19 + 10) * 10)/2, assembly2.cost(), 0);

        assembly3.addPart(assembly1);
        assembly3.addPart(assembly2);
        assertEquals(assembly1.cost() + assembly2.cost(), assembly3.cost(), 0);

        double cost = assembly3.cost();
        assembly2.addPart(new PiecePart(new PartNumber(75), "piece", 10));
        assertEquals(cost + 10, assembly3.cost(), 0);
    }

    public void testListPiecePart() {
        Part part = new PiecePart(new PartNumber(42), "Uma peca", 23);
        String expected = "Parte: 42; Descricao: Uma peca; Custo: 23.0\n";
        assertEquals(expected, part.list());
        part = new PiecePart(new PartNumber(2), "Outra peca", 5);
        expected = "Parte: 2; Descricao: Outra peca; Custo: 5.0\n";

        assertEquals(expected, part.list());
    }

    public void testListAssembly() {
        Assembly floppy = new Assembly(new PartNumber(1), "Disquete");
        Assembly disc = new Assembly(new PartNumber(11), "Disco");
        Assembly lid = new Assembly(new PartNumber(13), "Tampa corredica");
        floppy.addPart(disc);
        floppy.addPart(new PiecePart(new PartNumber(12), "Caixa plastica", 5));
        floppy.addPart(lid);
        lid.addPart(new PiecePart(new PartNumber(3), "Folha de aluminio", 3));
        lid.addPart(new PiecePart(new PartNumber(4), "Mola", 1));
        disc.addPart(new PiecePart(new PartNumber(5), "Anel de tracao", 2));
        disc.addPart(new PiecePart(new PartNumber(6), "Disco magnetico", 15));

        String expected =
            "Parte: 1; Descricao: Disquete; Custo: 26.0\n" +
            " Parte: 11; Descricao: Disco; Custo: 17.0\n" +
            "  Parte: 5; Descricao: Anel de tracao; Custo: 2.0\n" +
            "  Parte: 6; Descricao: Disco magnetico; Custo: 15.0\n" +
            " Parte: 12; Descricao: Caixa plastica; Custo: 5.0\n" +
            " Parte: 13; Descricao: Tampa corredica; Custo: 4.0\n" +
            "  Parte: 3; Descricao: Folha de aluminio; Custo: 3.0\n" +
            "  Parte: 4; Descricao: Mola; Custo: 1.0\n";
        assertEquals(expected, floppy.list());
    }
}
