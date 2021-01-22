package learning.pattern.visitor.computor;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();

        computer.accept(new ComputerPartVisitor() {
            @Override
            public void visit(Computer computer) {
                System.out.println("Displaying Computer.");
            }

            @Override
            public void visit(Mouse mouse) {
                System.out.println("Displaying Mouse.");
            }

            @Override
            public void visit(Keyboard keyboard) {
                System.out.println("Displaying Keyboard.");
            }

            @Override
            public void visit(Monitor monitor) {
                System.out.println("Displaying Monitor.");
            }
        });
    }
}