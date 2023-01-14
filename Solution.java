import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("L4, 123 kings road,2022");
        input.add("L1, 123 kings road,2020");
        input.add("L2, 20 queen road,1990");
        input.add("L3, 20 queen road,1992");

        List<String> output = getMostRecentListings(input);
        System.out.println(output);
    }

    public static List<String> getMostRecentListings(List<String> input) {
        Map<String, String> listings = new HashMap<>();
        List<String> output = new ArrayList<>();

        for (String s : input) {
            String[] parts = s.split(",");
            String name = parts[0];
            String address = parts[1];
            int date = Integer.parseInt(parts[2]);

            String currentName = listings.get(address);
            if (currentName == null || date > Integer.parseInt(currentName.split(",")[1])) {
                listings.put(address, name + "," + date);
            }
        }

        for (String name : listings.values()) {
            output.add(name.split(",")[0]);
        }

        return output;
    }
}