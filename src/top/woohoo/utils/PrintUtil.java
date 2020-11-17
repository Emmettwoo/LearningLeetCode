package top.woohoo.utils;

import java.util.List;

/**
 * @author Emmettwoo
 */
public class PrintUtil {
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
