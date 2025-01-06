import java.util.Random;

public class Hint {

    public Hint(int number) {
        Random generator = new Random();
        int upperBound=number+10;
        int lowerBound=number-10;
        int closeNumber = generator.nextInt(upperBound-lowerBound +1)+lowerBound;
        while (closeNumber == number) closeNumber = generator.nextInt(upperBound-lowerBound +1)+lowerBound;


            System.out.println("The number is close to " + closeNumber);


    }
}
