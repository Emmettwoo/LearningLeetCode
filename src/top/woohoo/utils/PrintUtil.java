package top.woohoo.utils;

import java.util.ArrayList;

/**
 * @author Emmettwoo
 */
public class PrintUtil {
    public static String printIntegerArrayList(ArrayList<Integer> arrayList) {
        StringBuilder result = new StringBuilder();
        arrayList.forEach((value) -> {
            result.append(value).append(" -> ");
        });
        result.append("NULL;");
        return result.toString();
    }
}
