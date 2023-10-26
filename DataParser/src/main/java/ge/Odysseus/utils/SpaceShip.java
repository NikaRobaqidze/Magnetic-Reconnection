package ge.Odysseus.utils;

public class SpaceShip {

    private double sumOfFMA;
    private int countOfFMA;

    public SpaceShip() {
        this.sumOfFMA = 0;
        this.countOfFMA = 0;
    }

    public void increaseValue(double FMAval){
        this.sumOfFMA += FMAval;
        this.countOfFMA++;
    }

    public double getAverage(){
        return this.sumOfFMA / this.countOfFMA;
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "sumOfFMA=" + sumOfFMA +
                ", countOfFMA=" + countOfFMA +
                '}';
    }
}
