package com.RichFloyd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String a = "hi he2llo";
        int ind = 0;

        System.out.println(xyzThere("abc.xyzxyz") );
        System.out.println(catDog("catcat"));
        System.out.println(doubleChar("The"));
        System.out.println(ind = a.indexOf(33));
        System.out.println(ind = a.indexOf("e"));
        System.out.println(ind = a.indexOf("o"));
        System.out.println(startHi(a));
        //String b = (a.charAt(0)=='o') ? "o" : "";
        //System.out.println(a.charAt(0));
        //System.out.println(hasTeen(20, 19, 10));
        //System.out.println(a.charAt(1));
        //System.out.println(a.substring(0,3).equals("not"));
        //HashMap<String, String> map = new HashMap<>();
        //map.put("a", "aaa");
        //map.put("b", "bbb");
        //map.put("c", "cake");
        //System.out.println(mapAB2(map));
        //map.get("a").length();


    }

    public static String lcs(String a, String b) {
        String res = "";
        int aLen = a.length();
        int bLen = b.length();
        int[] lowX = new int[aLen];
        for (int i = 0; i< aLen; i++) {
            lowX[i] = -1;
            for (int j=0; j<bLen; j++) {
                if (b.charAt(j) == a.charAt(i)) {
                    lowX[i] = j;
                }
            }
        }
        String currMaxRes = "";
        int count= 0;
        int pos = 0;
        for (int i = 0; i< aLen; i++) {
            if (lowX[i] != -1) {
                pos = lowX[i];
                count++;
                currMaxRes = currMaxRes + b.charAt(lowX[i]);
                for (int j=i+1;j<aLen;j++) {
                    if (lowX[j] > pos) {
                        count++;
                        currMaxRes = currMaxRes + b.charAt(lowX[j]);
                    }
                }
            }
        }
        return res;
    }

    public static String starOut(String str) {
        String res = "";
        int strLen = str.length();

        if (strLen == 0) {return res;}
        if (strLen == 1) {return (str.charAt(0) == '*') ? res : str;}

        String start = (str.charAt(0) == '*' || str.charAt(1) == '*') ? "" : Character.toString(str.charAt(0));

        for (int i = 1;i<strLen-1; i++) {
            if (str.charAt(i-1) != '*' && str.charAt(i) != '*' && str.charAt(i+1) != '*')  {
                res += Character.toString(str.charAt(i));
            }
        }

        String end = (str.charAt(strLen-2) == '*' || str.charAt(strLen-1) == '*' ) ? "" : Character.toString(str.charAt(strLen-1));
        return start + res + end;
    }

    public static boolean xyzThere(String str) {
        for (int i = 0 ; i< str.length()-2;i++) {
            String a = str.substring(i,i+3);
            System.out.println(a);
            if (a.equals("xyz")) {
                if (i==0) {return true;}
                if (str.charAt(i-1) != '.') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean catDog(String str) {
        int countCat = 0;
        int countDog = 0;
        for (int i = 0; i < str.length()-2; i++) {
            System.out.println(str.substring(i,i+3));
            if (str.substring(i,i+3).equals("cat")) {
                countCat++;
            }
            if (str.substring(i,i+3).equals("dog")) {
                countDog++;
            }
        }
        System.out.println(countCat + ":" + countDog);
        return (countCat == countDog);
    }

    public static String doubleChar(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            ret += Character.toString(str.charAt(i)) + Character.toString(str.charAt(i));
            String.valueOf(str.charAt(i));
        }
        return ret;
    }

    public static boolean evenlySpaced(int a, int b, int c) {
        ArrayList<Integer> z = new ArrayList<>();
        z.add(a);
        z.add(b);
        z.add(c);
        Collections.sort(z);
        int firstDiff = z.get(1)-z.get(0);
        int secDiff = z.get(2)-z.get(1);
        return firstDiff == secDiff;
    }


    public static Map<String, String> mapAB2(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b") && (map.get("a") == map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }

    public static Map<String, String> mapBully(Map<String, String> map) {
        String a = "";
        if (map.containsKey("a")) {
            a = map.get("a");
            map.put("a","");
        }
        map.put("b",a);
        return map;
    }


    public static String notString(String str) {
        int myLen = str.length();
        if (myLen < 3) {
            return "not " + str;
        } else if (str.substring(0,3).equals("not")) {
            return str;
        }
        return "not " + str;

    }

    public static boolean startHi(String str) {
        System.out.println(str.substring(0,2) == "hi");
        return ((str.length() >= 2) && (str.substring(0,2) == "hi"));
    }

    public static boolean hasTeen(int a, int b, int c) {
        int[] x = {13,14,15,16,17,18,19};
        for (int i=0; i <= x.length; i++) {
            System.out.println(x[i]);
            if ((a == x[i]) || (b == x[i]) || (c == x[i]) ) {
                return true;
            }
        }
        return false;
    }

}
