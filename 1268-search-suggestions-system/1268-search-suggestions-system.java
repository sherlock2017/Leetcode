class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeMap<String, List<String>> map = new TreeMap<>();
        
        Arrays.sort(products, (a, b) -> a.compareTo(b));
        
        for(String p : products){
            System.out.print(p+" ");
        }
        System.out.println();
        
        for(int j = 1; j <= searchWord.length(); j++){
            
                String prefix = searchWord.substring(0, j);
                System.out.println(prefix);
                
                List<String> list = new ArrayList<>();
                for(String product: products){
                    if(product.startsWith(prefix)){
                        if(list.size() < 3){
                            list.add(product);   
                        }
                        
                    }
                }

                map.put(prefix, list);
        }
          
        System.out.println(map);
        
        List<List<String>> suggestions = new ArrayList<>();
        for(String prefix : map.keySet()){
            List<String> list = map.get(prefix);
            suggestions.add(list);
        }
        
        return suggestions;
    }
}