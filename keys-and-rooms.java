// https://leetcode.com/problems/keys-and-rooms/
class keys-and-rooms {
    // tc -> N(Rooms) + K(Keys), sc -> N
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return canVisitAllTheRooms(rooms, new HashSet<>(), 0);
    }
    
    private boolean canVisitAllTheRooms(List<List<Integer>> rooms, 
                                Set<Integer> visited,
                                int key){
        if(visited.contains(key)) return false;
        visited.add(key);
        List<Integer> keys = rooms.get(key);
        for(int k : keys){            
            canVisitAllTheRooms(rooms, visited, k);
        }
        return visited.size()==rooms.size();
    }
}
