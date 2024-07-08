package Array;

public class ArrayMeanWordLength {

    public static String wordClosestToAverageLength(Array<String> arr) {
        int sum = 0;
        for (int i = 0; i < arr.getSize(); i++) {
            sum += arr.get(i).length();
        }
        double average = (double) sum / arr.getSize();

        String closestWord = arr.get(0);
        double closestWordDifference = Math.abs(arr.get(0).length() - average);

        for (int i = 1; i < arr.getSize(); i++) {
            String str = arr.get(i);
            double difference = Math.abs(str.length() - average);

            if (difference < closestWordDifference ||
                    (difference == closestWordDifference && str.length() > closestWord.length())) {

                closestWord = str;
                closestWordDifference = difference;
            }
        }
        return closestWord;
    }

    public static void main(String[] args) {

        Array<String> myarr = new Array<String>(6);
        myarr.set(0, "star");
        myarr.set(1, "on");
        myarr.set(2, "dog");
        myarr.set(3, "y");
        myarr.set(4, "water");
        myarr.set(5, "bright");
        System.out.println(wordClosestToAverageLength(myarr));
    }

}
