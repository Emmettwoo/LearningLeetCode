package top.woohoo.utils;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Emmettwoo
 */
public class RandomUtil {
    public static ArrayList<Integer> generateIntegerArrayList(int minimum, int maximum, int length) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int count = 0; count < length; count++) {
            arrayList.add(RandomUtil.generateInteger(minimum, maximum));
        }
        System.out.println("Integer ArrayList Generated: " + PrintUtil.printIntegerArrayList(arrayList));
        return arrayList;
    }

    public static ArrayList<Integer> generateIntegerArrayListNearlyOrdered(int minimum, int maximum, int length, int swapTimes) {
        // Generate a random integer list and make it sorted.
        ArrayList<Integer> arrayList = RandomUtil.generateIntegerArrayList(minimum, maximum, length);
        arrayList.sort(Integer::compareTo);

        // Swap limited times between two random values.
        for (int count=0; count<swapTimes; count++) {
            int indexA = (int)(Math.random()*(length));
            int indexB = (int)(Math.random()*(length));

            Integer temp = arrayList.get(indexA);
            arrayList.set(indexA, arrayList.get(indexB));
            arrayList.set(indexB, temp);
        }

        // Return the sorted integer list which been swap times.
        return arrayList;
    }

    public static Integer generateInteger(int minimum, int maximum) {
        return (int)(minimum + Math.random() * (maximum - minimum));
    }

    public static String generateStringWithCharacterSet(int stringLength, Character[] characterSet) {
        StringBuilder result = new StringBuilder();
        for (int count = 0; count < stringLength; count++) {
            result.append(RandomUtil.generateCharacterWithCharacterSet(characterSet));
        }
        return result.toString();
    }

    public static Character generateCharacterWithCharacterSet(Character[] characterSet) {
        return characterSet[(int)(Math.random() * characterSet.length)];
    }
}
