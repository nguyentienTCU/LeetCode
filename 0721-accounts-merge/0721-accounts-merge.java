class Solution {
    //implement a union-find class
    static class UnionFind{
        private int[] parent;       //parent[x] stores the root of x
        private int[] size;         //size[x] stores the size of the set in which x is the root (only used with root)

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];

            //default values at first initialization
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            //find the set that x belongs to (return the root of that set)
            //recusively set parent[x] to the root of x every times called
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b){
            //merge 2 sets: set 1 contains a and set 2 contains b
            int rootA = find(a);
            int rootB = find(b);
            if(rootA==rootB) return;    //return if a and b are in the same set

            if(size[rootA]<size[rootB]){
                //keep the root of larger set; set the root of smaller set to be the root of larger set
                parent[rootA] = rootB;
                size[rootB]+=size[rootA];
            }else{
                parent[rootB] = rootA;
                size[rootA]+=size[rootB];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();   //set an id for each email
        Map<String, String> emailToName = new HashMap<>();  //key: email    value: the name of that email's owner
        int id = 0;

        //build up the two maps
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i=1; i<account.size(); i++){
                String email = account.get(i);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email,id);
                    id++;
                }
                emailToName.put(email,name);
            }
        }

        //initialize our UnionFind class
        UnionFind uf = new UnionFind(id);
 
        //apply UnionFind to put each id (representing a specific email) into correct set
        //emails of the same person are in a same set
        for(List<String> account : accounts){
            if(account.size()<=2) continue;
            String firstEmail = account.get(1);
            int firstId = emailToId.get(firstEmail);

            for(int i=2; i<account.size(); i++){
                String email = account.get(i);
                int emailId = emailToId.get(email);
                uf.union(firstId, emailId);
            }
        }

        Map<Integer, List<String>> rootToEmails = new HashMap<>();  //key: root   value: list of emails of that root
        
        //build up the map
        for(String email : emailToId.keySet()){
            int root = uf.find(emailToId.get(email));
            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        //build up the answer list
        List<List<String>> ans = new ArrayList<>();
        for(List<String> emails : rootToEmails.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            ans.add(merged);
        }
        return ans;
    }
}