package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        Map<String, Integer> map = new HashMap<>();
        for (Info info : list) {
            String key = info.getCity();
            int value = info.getRainfall();
            if (!map.containsKey(key)) {
                map.put(key, value);
            } else {
                map.computeIfPresent(key, (k, v) -> v + value);
            }
        }
        List<Info> rsl = new ArrayList<>();
        for (String key : map.keySet()) {
            rsl.add(new Info(key, map.get(key)));
        }
        return rsl;
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }
    }
}