/*

import sorryGame.GameApplet;

*/
/**
 * CS Program: AppletTest Programmer: Christopher Morse Date: 4/15/12
 *//*

public class AppletTest {
    public static void main(String[] args) throws Exception {
        GameApplet testApplet = new GameApplet();
//        testApplet.startGame("morsecp", "red", "easy");
        //                for(Integer i =0; i<10; i++){
        //                    System.out.println(testApplet.drawCard());
        //                }
        int crd = testApplet.drawCard();
        while(crd != 1){
            crd = testApplet.drawCard();
            System.out.println(crd);
        }
        testApplet.validateMove("y0", "ystart", "49");
        System.out.println("yellow move is valid: " + testApplet.valid);
        testApplet.validateMove("r0", "rstart", "19");
        System.out.println("red move is valid: " + testApplet.valid);
        while(crd != 10){
            crd = testApplet.drawCard();
            System.out.println(crd);
        }
        for (int i=49;i<99; i=i+10) {
            int init = i % 60;
            int fin = (init + 10) % 60;
            String initialPos = Integer.toString(init);
            String finalPos = Integer.toString(fin);
            testApplet.validateMove("y0", initialPos, finalPos);
            System.out.println(testApplet.valid);
        }
        testApplet.validateMove("y0", "39", "79");
        System.out.println("yellow move is valid: " + testApplet.valid);


        //System.out.println(valid1);
        //        testApplet.setGame(new SorryGame());
    }
}
*/
