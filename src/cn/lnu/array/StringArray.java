package cn.lnu.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringArray {
    public static void main(String[] args) {
        //����union
        String[] arr1 = {"abc", "df","ac","ac","abc"};
        String[] arr2 = {"abc", "cc", "cc","df", "d", "abc"};
        String[] result_union = union(arr1, arr2);
        System.out.println("�󲢼��Ľ�����£�");
        for (String str : result_union) {
            System.out.println(str);
        }
        System.out.println("---------------------�ɰ��ķָ���------------------------");

        //����insect
        String[] result_insect = intersect(arr1, arr2);
        System.out.println("�󽻼��Ľ�����£�");
        for (String str : result_insect) {
            System.out.println(str);
        }

         System.out.println("---------------------���ķָ���------------------------");
          //����minus
        String[] result_minus = minus(arr1, arr2);
        System.out.println("���Ľ�����£�");
        for (String str : result_minus) {
            System.out.println(str);
        }
    }

    //�������ַ�������Ĳ���������set��Ԫ��Ψһ��
    public static String[] union(String[] arr1, String[] arr2) {
        Set<String> set = new HashSet<String>();
        for (String str : arr1) {
            set.add(str);
        }
        for (String str : arr2) {
            set.add(str);
        }
        String[] result = {};
        return set.toArray(result);
    }

    //����������Ľ���
    public static String[] intersect(String[] arr1, String[] arr2) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        LinkedList<String> list = new LinkedList<String>();
        for (String str : arr1) {
            if (!map.containsKey(str)) {
                map.put(str, Boolean.FALSE);
            }
        }
        for (String str : arr2) {
            if (map.containsKey(str)) {
                map.put(str, Boolean.TRUE);
            }
        }

        for (Entry<String, Boolean> e : map.entrySet()) {
            if (e.getValue().equals(Boolean.TRUE)) {
                list.add(e.getKey());
            }
        }

        String[] result = {};
        return list.toArray(result);
    }

    //����������Ĳ
    public static String[] minus(String[] arr1, String[] arr2) {
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String> history = new LinkedList<String>();
        String[] longerArr = arr1;
        String[] shorterArr = arr2;
        //�ҳ��ϳ������������϶̵�����
        if (arr1.length > arr2.length) {
            longerArr = arr2;
            shorterArr = arr1;
        }
        for (String str : longerArr) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        for (String str : shorterArr) {
            if (list.contains(str)) {
                history.add(str);
                list.remove(str);
            } else {
                if (!history.contains(str)) {
                    list.add(str);
                }
            }
        }

        String[] result = {};
        return list.toArray(result);
    }
}

