// https://leetcode.com/problems/web-crawler/
/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class web-crawler {
    // tc -> n, sc-> n
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> q = new LinkedList<>();
        q.offer(startUrl);
        
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        
        String hostName = getHostName(startUrl);
        
        while(!q.isEmpty()){
            String currentUrl = q.poll();
            for(String url : htmlParser.getUrls(currentUrl)){
                if(url.contains(hostName) && !visited.contains(url)){
                    q.offer(url);
                    visited.add(url);
                }
            }
        }
        
        return new LinkedList<String>(visited);
    }
    
    private String getHostName(String startUrl){
        String[] ss = startUrl.split("/");
        return ss[2];
    }
}
