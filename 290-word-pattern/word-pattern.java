class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        String[] map = new String[26];
        HashMap<String, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (map[ch - 'a'] != null &&
                !map[ch - 'a'].equals(word)) {
                return false;
            }

            if (reverseMap.containsKey(word) &&
                reverseMap.get(word) != ch) {
                return false;
            }

            map[ch - 'a'] = word;
            reverseMap.put(word, ch);
        }

        return true;
    }
}