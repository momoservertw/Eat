import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        setUpFood();
        System.out.print(food());
        setUpWay();
        System.out.print(way());
    }

    private static Map<List<String>, Double> FoodProp;
    private static Map<List<String>, Double> WayProp;

    private static void setUpFood() {
        FoodProp = new HashMap<List<String>, Double>();
        List<String> types = new ArrayList<String>();
        // 貴: 0.2
        types.add("義大利麵");
        types.add("牛排");
        types.add("丼飯");
        types.add("咖哩");
        FoodProp.put(types, 0.2);
        // 普通: 0.4
        types = new ArrayList<String>();
        types.add("麥當當");
        types.add("滷味");
        types.add("炸雞");
        FoodProp.put(types, 0.4);
        // 便宜: 0.4
        types = new ArrayList<String>();
        types.add("泡麵");
        types.add("八方");
        types.add("便當");
        types.add("自助餐");
        types.add("早餐店");
        FoodProp.put(types, 0.4);
    }

    private static String food() {
        if (FoodProp != null) {
            double totalChance = 0;
            for (List<String> key : FoodProp.keySet()) {
                totalChance += FoodProp.get(key);
            }
            double randTotalChance = Math.random() * totalChance;
            double value;
            for (List<String> key : FoodProp.keySet()) {
                value = FoodProp.get(key);
                if (randTotalChance <= value) {
                    return getRandomString(key);
                }
                randTotalChance -= value;
            }
        }
        return "not options";
    }

    private static void setUpWay() {
        WayProp = new HashMap<List<String>, Double>();
        List<String> types = new ArrayList<String>();
        /*
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("hh");
        int time = Integer.parseInt(dateFormat.format(date));
        List<Double> timeChance = new ArrayList<Double>();
         */

        // 外送: 0.3
        types.add("外送");
        WayProp.put(types, 0.3);
        // 外帶: 0.4
        types = new ArrayList<String>();
        types.add("外帶");
        WayProp.put(types, 0.4);
        // 內用: 0.3
        types = new ArrayList<String>();
        types.add("內用");
        WayProp.put(types, 0.3);
    }

    private static String way() {
        if (WayProp != null) {
            double totalChance = 0;
            for (List<String> key : WayProp.keySet()) {
                totalChance += WayProp.get(key);
            }
            double randTotalChance = Math.random() * totalChance;
            double value;
            for (List<String> key : WayProp.keySet()) {
                value = WayProp.get(key);
                if (randTotalChance <= value) {
                    return getRandomString(key);
                }
                randTotalChance -= value;
            }
        }
        return "not options";
    }

    public static String getRandomString(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
