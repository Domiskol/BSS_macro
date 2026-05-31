import java.awt.event.KeyEvent;

public class PolarBearQuest implements BearQuest{

    @Override
    public void walkToBear(MacroRobot robot) {

        robot.pressKey(KeyEvent.VK_ESCAPE, 100);
        robot.pressKey(KeyEvent.VK_R, 100);
        robot.pressKey(KeyEvent.VK_ENTER, 100);
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }

        robot.walkForward(3000);
        robot.walkD(7000);
        robot.pressKey(KeyEvent.VK_SPACE, 100);
        robot.walkD(500);
        robot.walkForward(200);
        robot.walkD(500);
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
        robot.pressKey(KeyEvent.VK_E, 100);
        try{
            Thread.sleep(600);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
        robot.pressKey(KeyEvent.VK_SPACE, 200);
        robot.pressKey(KeyEvent.VK_SPACE, 200);
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
        robot.walkBackwards(1000);
        robot.walkD(3000);
        robot.walkForward(500);
        robot.walkD(1000);
        robot.walkA(200);
        robot.walkBackwards(200);


    }

    @Override
    public void claimQuest(MacroRobot robot) {
        robot.pressKey(KeyEvent.VK_E, 100);
        robot.moveMouseTo(1000, 800);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
        robot.moveMouseTo(1050, 820);
        robot.click();
        robot.click();
        robot.click();
        robot.click();
        robot.click();
        robot.click();
        robot.click();
        robot.click();

    }

    @Override
    public void doQuestLogic(MacroRobot robot) {

        robot.walkD(500);
        robot.pressKey(KeyEvent.VK_SPACE, 50);
        robot.walkD(2000);



        long startTime = System.currentTimeMillis();
        long duration = 5 * 60 * 1000;
        long endTime = startTime + duration;

        while (System.currentTimeMillis() < endTime && !Thread.currentThread().isInterrupted()) {
            robot.walkD(1000);
            robot.click();
            if (Thread.currentThread().isInterrupted()) return;
            robot.walkA(1000);
            robot.click();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }


    }
}

