public class WhileLoop {
    public void WhileLoopNoDo(int whileLoop) {
        while (whileLoop < 10) {
            System.out.println(whileLoop);
            whileLoop++;
        }
    }

    public void DoWhileLoop(int doWhileLoop) {
        do {
            System.out.println("In lần đầu");
            System.out.println(doWhileLoop);
            doWhileLoop++;
        } while (doWhileLoop < 7);
    }
}
