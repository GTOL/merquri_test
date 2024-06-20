public class GamePlatform {
    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;
        int step = 0, max = inclinations.length;
        while (speed > 0 && step < max) {
            speed -= inclinations[step];
            step++;
        }
        return speed > 0 ? speed : 0;
    }
    public static void main(String[] args){
        System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); //should print 45
    }
}
