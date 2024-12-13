package com.example.sneakers;

import java.util.*;

public class SneakersApp {
    private List<Sneakers> sneakersList;

    public SneakersApp() {
        sneakersList = new ArrayList<>();
        initSneakers();
    }

    private void initSneakers() {
        sneakersList.add(new FootballSneakers("Nike Mercurial", 120.0, new Producer("Nike", "USA ")));
        sneakersList.add(new FootballSneakers("Adidas Predator", 130.0, new Producer("Adidas", "Germany")));
        sneakersList.add(new BasketballSneakers("Air Jordan 1", 150.0, new Producer("Nike", "USA")));
        sneakersList.add(new BasketballSneakers("Kobe 9", 180.0, new Producer("Nike", "USA")));
        sneakersList.add(new FootballSneakers("Puma Future", 110.0, new Producer("Puma", "Germany")));
        sneakersList.add(new BasketballSneakers("LeBron 17", 200.0, new Producer("Nike", "USA")));
        sneakersList.add(new FootballSneakers("New Balance Furon", 100.0, new Producer("New Balance", "USA")));
        sneakersList.add(new BasketballSneakers("Under Armour Curry", 160.0, new Producer("Under Armour", "USA")));
        sneakersList.add(new FootballSneakers("Mizuno Morelia", 140.0, new Producer("Mizuno", "Japan")));
        sneakersList.add(new BasketballSneakers("Adidas D.O.N. Issue #1", 120.0, new Producer("Adidas", "Germany")));
    }

    public int countProducers() {
        Set<String> producerNames = new HashSet<>();
        for (Sneakers sneakers : sneakersList) {
            producerNames.add(sneakers.getProducer().getName());
        }
        return producerNames.size();
    }

    public Map<String, Double> averageCostByProducer() {
        Map<String, List<Double>> producerCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            String producerName = sneakers.getProducer().getName();
            producerCosts.putIfAbsent(producerName, new ArrayList<>());
            producerCosts.get(producerName).add(sneakers.getCost());
        }

        Map<String, Double> averageCosts = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : producerCosts.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            averageCosts.put(entry.getKey(), average);
        }
        return averageCosts;
    }

    public Map<String, Double> averageCostByType() {
        Map<String, List<Double>> typeCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            String type = sneakers.getType();
            typeCosts.putIfAbsent(type, new ArrayList<>());
            typeCosts.get(type).add(sneakers.getCost());
        }

        Map<String, Double> averageCosts = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : typeCosts.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            averageCosts.put(entry.getKey(), average);
        }
        return averageCosts;
    }

    public static void main(String[] args) {
        SneakersApp app = new SneakersApp();
        System.out.println("Количество производителей: " + app.countProducers());
        System.out.println("Средняя стоимость обуви по производителям: " + app.averageCostByProducer());
        System.out.println("Средняя стоимость обуви по типам: " + app.averageCostByType());
    }
}