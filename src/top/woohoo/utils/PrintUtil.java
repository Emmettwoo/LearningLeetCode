package top.woohoo.utils;

import java.util.List;

/**
 * @author Emmettwoo
 */
public class PrintUtil {

    public static String printIntegerArrayLists(List<List<Integer>> arrayLists) {
        if (arrayLists == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        result.append("[\n");
        int listCount = arrayLists.size();
        for (int listIndex = 0; listIndex < arrayLists.size(); listIndex++) {
            List<Integer> arrayList = arrayLists.get(listIndex);

            result.append("  [");

            int listLength = arrayList.size();
            for (int valueIndex = 0; valueIndex < listLength; valueIndex++) {
                result.append(arrayList.get(valueIndex));
                if (valueIndex != listLength - 1) {
                    result.append(',');
                }
            }

            result.append("]");
            if (listIndex != listCount - 1) {
                result.append(',');
            }
            result.append("\n");
        }
        result.append(']');

        return result.toString();
    }

    public static String printIntegerArrayList(List<Integer> arrayList) {
        StringBuilder result = new StringBuilder();
        arrayList.forEach((value) -> {
            result.append(value).append(" -> ");
        });
        result.append("NULL;");
        return result.toString();
    }

    public static String printIntegerArray(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value).append(" -> ");
        }
        result.append("NULL;");
        return result.toString();
    }
}
