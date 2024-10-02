package BreakAndContinue;

public class BreakAndContinue {
    public void breakFunc(){
        for (int i = 0; i < 7; i++) {
            System.out.println(i);
            if(i == 3) {
                break;
            }
        }
    }

    public void continueFunc(){
        for (int j = 0; j < 7; j++) {
            if(j == 3) {
                continue;
            }
            System.out.println(j);
        }
    }
}
