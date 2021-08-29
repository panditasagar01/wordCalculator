import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This Program Works as a Word calculator
 * where you assign a integer value to each word
 * like def sagar 90 or def pandita 10 and can calculate like
 * calc sagar + pandita = which will provide the result word
 * and the add or subtract them with each other
 * @author Sagar Pandita
 */
public class wordCalculator {

    public static void main(String[] args) throws IOException {
        String Unknown = "unknown";
        Map<String, Integer> hashMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String delimiter = " ";
        while ((line = reader.readLine()) != null) {
            String[] lineArr = line.split(delimiter);
            String command = lineArr[0];
            if (command.equals("def")) {
                //put values in hashmap
                hashMap.put(lineArr[1], Integer.parseInt(lineArr[2]));
            } else if (command.equals("calc")) {
                //calculate
                Arrays.stream(lineArr).skip(1).forEach(result -> System.out.print(result + " "));
                boolean dataFound = true;
                for (int i = 1; i < lineArr.length; i += 2) {
                    if (!hashMap.containsKey(lineArr[i])) {
                        dataFound = false;
                        break;
                    }
                }
                // If dataFound is false print result as unknown
                if (!dataFound)
                    System.out.println(Unknown);
                else {
                    // traverse and find which operator are between two words and do addition or Subtraction
                    int result = hashMap.get(lineArr[1]);
                    for (int i = 2; i < lineArr.length; i += 2) {
                        if (lineArr[i].equals("-")) {
                            result = result - hashMap.get(lineArr[i + 1]);

                        } else if (lineArr[i].equals("+")) {
                            result = result + hashMap.get(lineArr[i + 1]);
                        }
                    }
                    String key = null;
                    // traverse over map to find the key which is matching the result
                    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                        if (entry.getValue() == result) {
                            key = entry.getKey();
                            System.out.println(key);
                        }
                    }
                    // if same value is not available in Map print unknown
                    if (key == null)
                        System.out.println(Unknown);
                }
            } else {
                //clear the map
                hashMap.clear();
            }
        }
    }
}
