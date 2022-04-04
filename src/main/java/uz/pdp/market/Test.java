package uz.pdp.market;

import java.util.*;

public class Test {
/*    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        List<String> l = Collections.synchronizedList(al);

        List<Integer> synList = Collections.synchronizedList(new ArrayList<>());

        Set<String> stringSet = new HashSet<>();

        stringSet.add(null);
        stringSet.add("Hello");
        stringSet.add("World");


        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }


        System.out.println("stringSet = " + stringSet);


//        LinkedHashSet<Object> objects = new LinkedHashSet<>();
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            integerSet.add(i);
        }
        System.out.println("integerSet = " + integerSet);
        integerSet.remove(1);
        System.out.println("integerSet = " + integerSet);
        System.out.println("integerSet.size() = " + integerSet.size());
        System.out.println("integerSet.hashCode() = " + integerSet.hashCode());

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Hello");
        arrayList.add("Hello");
        arrayList.add("Hello");

        HashSet<String> hashSet = new HashSet<>();
        System.out.println("hashSet.addAll(arrayList) = " + hashSet.addAll(arrayList));
        System.out.println("hashSet = " + hashSet);

        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add(null);
        strings.add(null);
        strings.add("Salom");
        strings.add("SalomA");
        strings.add("SalomB");
        System.out.println("strings = " + strings);

        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println("next = " + next);
        }

    }*/

/*    public static void main(String[] args) {
        TreeSet<String> strings = new TreeSet<>();
//        strings.add("Hello");
//        strings.add(null);
//        strings.add("World");

        System.out.println("strings = " + strings);

*//*        for (int i = 20; i > 10; i--) {
            strings.add("" + i);
        }*//*
        strings.add("B");
        strings.add("A");
        strings.add("a");
        strings.add("C");
        System.out.println("strings = " + strings);
        System.out.println("strings.first() = " + strings.first());
        System.out.println("strings.last() = " + strings.last());

        System.out.println("strings.descendingSet() = " + strings.descendingSet());
    }*/

    public static void main(String[] args) {
        Map<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "Bir");
        integerStringHashMap.put(2, "Ikki");
        integerStringHashMap.put(3, "Uch");
        integerStringHashMap.put(4, "To'rt");
        integerStringHashMap.put(5, "Besh");
        integerStringHashMap.put(6, "Olti");

        System.out.println("integerStringHashMap = " + integerStringHashMap);


        Map<Integer, String> hashMap = new HashMap<>() {{
            put(10, "bir");
            put(14, "bir");
            put(4, "to'rt");
            put(6, "uch");
            put(2, "ikki");
        }};

        System.out.println("hashMap = " + hashMap);

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "bir");
        linkedHashMap.put(22, "gfhjk");
        linkedHashMap.put(4, "to'rt");
        linkedHashMap.put(6, "uch");
        linkedHashMap.put(2, "ikki");

        linkedHashMap.putIfAbsent(1, "sas2");

        System.out.println("linkedHashMap = " + linkedHashMap);

        System.out.println("linkedHashMap.hashCode() = " + linkedHashMap.hashCode());

        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());

        linkedHashMap.replace(1, "ddsdadasdad");
        System.out.println("linkedHashMap = " + linkedHashMap);

/*        String str = "a#bb#ccc#dddd";

        String[] test = new String[4];
        int k = 0;
        String a = "";
        for (int i = 0; i < str.length(); i++) {
            a = a + str.charAt(i);
            if (str.charAt(i) == '#') {
                test[k] = a.substring(0, a.length() - 1);
                k++;
                a = "";
            }
            test[k] = a;
        }
        System.out.println("test = " + Arrays.toString(test));*/

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.put(1, "bir");
        hashMap1.put(2, "ikki");
        hashMap1.put(3, "uch");
        hashMap1.put(4, "to'rt");

        System.out.println("hashMap1.getOrDefault(22,\"salom\") = " + hashMap1.getOrDefault(22, "salom"));

        System.out.println("hashMap1.entrySet() = " + hashMap1.entrySet());

        /*for (Map.Entry<Integer, String> next : hashMap1.entrySet()) {
            System.out.println("next.getValue() = " + next.getValue());
        }*/

        Iterator<Map.Entry<Integer, String>> iterator = hashMap1.entrySet().iterator();
        /*while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("object = " + object);
        }*/

/*        hashMap1.forEach((k, v) -> {
            System.out.println("key : " + k + ", value : " + v);
        });*/

        LinkedHashMap<Integer, String > linkedHashMap1 = new LinkedHashMap<Integer, String>(16,0.75F,false);
        linkedHashMap1.put(1,"bir");
        linkedHashMap1.put(2,"ikki");
        linkedHashMap1.put(3,"uch");

        System.out.println("linkedHashMap1 = " + linkedHashMap1);


    }
}