package collections.map.problems;

import java.util.*;

public class FindSecondLastKeyValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("please provide input:");
        StringBuilder par = new StringBuilder();
        int i = 0;
        while (i < 4) {
            par.append(" ").append(in.nextLine());
            ++i;
        }

        System.out.println("created paragraph is: " + par);
        char c = findMaxCountSec(new String(par).toCharArray());
        System.out.println("result: " + c);
    }

    static char findMaxCountSec(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : arr) {
            if(c == ' ') {
                continue;
            }
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> el = new ArrayList<>(map.entrySet());
        Map.Entry<Character, Integer> first = el.get(0);
        Map.Entry<Character, Integer> second = el.get(0);

        for (Map.Entry<Character, Integer> e : el) {
            int value = e.getValue();
            if (value > first.getValue()) {
                second = first;
                first = e;
            } else if (value > second.getValue() && value != first.getValue()) {
                second = e;
            }
        }

        System.out.println("second highest occurrant key: " + second.getKey() + ", value: "+ second.getValue());
        return second.getKey();
    }
}
