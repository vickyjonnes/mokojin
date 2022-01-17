package edu.problem.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestValuesFromLabel {

    public static void main(String[] args) {
        int values[] = {9,8,8,7,6};
        int labels[] = {0,0,0,1,1};

        LargestValuesFromLabel l= new LargestValuesFromLabel();
        System.out.println(l.largestValsFromLabels(values, labels, 3, 1));

    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }
        items = items.stream().sorted((i1, i2)->i2.value-i1.value).collect(Collectors.toList());

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < items.size() && j < numWanted; i++) {
            if(map.get(items.get(i).label)==null || map.get(items.get(i).label) < useLimit){
                sum = sum + items.get(i).value;
                map.put(items.get(i).label, map.getOrDefault(items.get(i).value, 0) + 1);
                j++;
            }
        }
        return sum;
    }

    class Item {
        int value;
        int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
