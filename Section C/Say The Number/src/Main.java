import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("0");
        BigInteger number2 = new BigInteger("11");
        BigInteger number3 = new BigInteger("1043283");
        BigInteger number4 = new BigInteger("90376000010012");

        String result1 = sayTheNumber(number1);
        String result2 = sayTheNumber(number2);
        String result3 = sayTheNumber(number3);
        String result4 = sayTheNumber(number4);
        System.out.println(result1
                + "\n"
                + result2
                + "\n"
                + result3
                + "\n"
                + result4);
    }
    public static String sayTheNumber(BigInteger num) {
        if (num.equals(BigInteger.ZERO)) {
            return "Zero";
        }
        String[] units = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion", "undecillion", "duodecillion", "tredecillion", "quattuordecillion", "quindecillion", "sexdecillion", "septendecillion", "octodecillion"};
        int x = 0;
        String inWords = "";

        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger numericalValue = num.mod(BigInteger.valueOf(1000));
            if (numericalValue.compareTo(BigInteger.ZERO) > 0) {
                String words = "";
                if (numericalValue.compareTo(BigInteger.valueOf(20)) < 0) {
                    words = getSingleDigits(numericalValue.intValue());
                } else if (numericalValue.compareTo(BigInteger.valueOf(100)) < 0) {
                    words = getDoubleDigits(numericalValue.divide(BigInteger.valueOf(10)).intValue()) + (numericalValue.mod(BigInteger.TEN).intValue() > 0 ? " " + getSingleDigits(numericalValue.mod(BigInteger.TEN).intValue()) : "");
                } else {
                    words = getSingleDigits(numericalValue.divide(BigInteger.valueOf(100)).intValue()) + " hundred" + (numericalValue.mod(BigInteger.valueOf(100)).intValue() > 0 ? " and " + getDoubleDigits(numericalValue.mod(BigInteger.valueOf(100)).divide(BigInteger.TEN).intValue()) + (numericalValue.mod(BigInteger.TEN).intValue() > 0 ? " " + getSingleDigits(numericalValue.mod(BigInteger.TEN).intValue()) : "") : "");
                }
                inWords = words + " " + units[x] + (inWords.isEmpty() ? "" : ", ") + inWords;
            }
            num = num.divide(BigInteger.valueOf(1000));
            x++;
        }
        return inWords + ".";
    }
    public static String getSingleDigits(int numSingle) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        return ones[numSingle];
    }
    public static String getDoubleDigits(int numDouble) {
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        return tens[numDouble];
    }
}
