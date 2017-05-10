/**
 *
 * @author AArgento
 * @date 23 April 2017
 * @class CMSC 350
 * @purpose  Determine order of fractions.
 *
 */

public class Fractions implements Comparable {

    private String fractionOutput;
    Fractions(String fractionInput) {
        this.fractionOutput = fractionInput;
    }

    /* cross multiplies numeratorA to denominator B and numeratorB to denominatorA to complete comparison. the
    * largest product indicates that the numerator used belongs to the largest fraction.
    */
    @Override
    public int compareTo(Object unsplitFraction) {

        String values[] = fractionOutput.split("/");

        int numeratorA = Integer.valueOf(values[0]);
        int denominatorA = Integer.valueOf(values[1]);

        String stringToSplit = unsplitFraction.toString();
        values = stringToSplit.split("/");

        int numeratorB = Integer.valueOf(values[0]);
        int denominatorB = Integer.valueOf(values[1]);

        int resultA = numeratorA * denominatorB;
        int resultB = numeratorB * denominatorA;

        if (resultA < resultB) {
            return -1;
        } else if (resultA == resultB)
            return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return fractionOutput;
    }

} //end Fractions

