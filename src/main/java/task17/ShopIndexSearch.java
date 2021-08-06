package task17;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShopIndexSearch {
    private Map<String, List<Product>> data = new HashMap<>();
    String productIndex;

    public Stream searchWithStream(Product product) {
        productIndex = product.getNameProduct();
        List<String> listWord = Arrays.stream(productIndex.split(" "))
                .collect(Collectors.toList());

        Set<Product> setSearch = new HashSet<>();
        for (String word : listWord) {
            data.entrySet().stream()
                    .filter(s -> s.getValue().stream()
                            .iterator().next().getNameProduct()
                            .contains(word) && word.length() > 2)
                    .forEach(s -> setSearch.add(s.getValue().iterator().next()));
        }

        Map<Product, Integer> tempMap = new HashMap<>();
        int count = 0;
        for (Product p : setSearch) {
            for (String word : listWord) {
                if (p.getNameProduct().contains(word) && word.length() > 2) {
                    count++;
                }
            }
            tempMap.put(p, count);
            count = 0;
        }

        Stream stream = tempMap.entrySet().stream().sorted(Map.Entry.<Product, Integer>comparingByValue().reversed());
        return stream;
    }

    public void addIndex(Product product) {
        productIndex = product.getNameProduct();
        String[] listWords = productIndex.split(" ");

        for (String str : listWords) {
            for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
                if (entry.getKey().equals(str)) {
                    entry.getValue().add(product);
                }
            }
            if (!data.containsKey(str) && str.length() > 2) {
                List<Product> arrayProduct = new ArrayList<>();
                arrayProduct.add(product);
                data.put(str, arrayProduct);
            }
        }
    }

    public void removeIndex(Product product) {
        productIndex = product.getNameProduct();
        String[] listWords = productIndex.split(" ");
        List<String> delList = new ArrayList<>();

        for (String str : listWords) {
            for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
                if (entry.getKey().equals(str)) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (productIndex.equals(entry.getValue().get(i).getNameProduct())) {
                            entry.getValue().remove(entry.getValue().get(i));
                        }
                        if (entry.getValue().isEmpty()) {
                            delList.add(entry.getKey());
                        }
                    }
                }
            }
        }
        for (String s : delList) {
            data.remove(s);
        }
    }

    public void searchWithIndex(String str) {
        productIndex = str;
        String[] listWords = productIndex.split(" ");
        for (String s : listWords) {
            for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
                if (entry.getKey().equals(s)) {
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        if (entry.getValue().get(i).getNameProduct().equals(str)) {
                            System.out.println(entry.getValue().get(i).toString());
                        }
                    }
                    return;
                }
            }
        }
    }

    public void searchWithStars(String str) {
        Predicate<String> isWord = s -> s.endsWith("*");

        if (isWord.test(str)) {
            searchWithPredicate(s -> s.contains(str.substring(0, str.length() - 1)));
        }
    }

    public void searchWithPredicate(Predicate<String> predicate) {

        for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
            if (predicate.test(entry.getKey())) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.println(entry.getValue().get(i));
                }
            }
        }
    }

    public void removeWithPredicate(Predicate<Product> predicate) {
        Product product = null;

        for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (predicate.test(entry.getValue().get(i))) {
                    product = (entry.getValue().get(i));
                }
            }
        }
        removeIndex(product);
    }

    public Map<String, List<Product>> getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Product>> entry : data.entrySet()) {
            sb.append(entry.getKey()).append(":");
            sb.append(entry.getValue().toString());
            sb.append("\n");
            sb.append("\n");
        }
        return "ShopIndexSearch: " + sb;
    }
}
