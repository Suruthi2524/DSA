class Solution {
    public boolean isIsomorphic(String s, String t) {

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        for (int i = 0; i < 256; i++) {
            mapST[i] = -1;
            mapTS[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            // s -> t mapping
            if (mapST[a] != -1 && mapST[a] != b) {
                return false;
            }

            // t -> s mapping
            if (mapTS[b] != -1 && mapTS[b] != a) {
                return false;
            }

            mapST[a] = b;
            mapTS[b] = a;
        }

        return true;
    }
}