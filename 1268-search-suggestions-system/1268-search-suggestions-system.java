class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestions = new ArrayList<>();
        Arrays.sort(products, (a, b) -> a.compareTo(b));
        for(int j = 1; j <= searchWord.length(); j++){
                String prefix = searchWord.substring(0, j);
                List<String> list = new ArrayList<>();
                for(String product: products){
                    if(product.startsWith(prefix)){
                        if(list.size() < 3){
                            list.add(product);   
                        }  
                    }
                }
                suggestions.add(list);
        }
        return suggestions;
    }
}