import java.util.*;
class stringWithTransformation{
    String st;
    int tid;
    stringWithTransformation(String st,int tid){
        this.st = st;
        this.tid = tid;
    }
}
public class word_Ladder {
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0; // If endWord is not in the list, no valid transformation exists.
        }
        Queue<stringWithTransformation> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>(wordList);
        q.add(new stringWithTransformation(beginWord, 1));
        while (!q.isEmpty()) {
            String st = q.peek().st;
            int tid = q.peek().tid;
            if (q.peek().st.equals(endWord))return tid;
            q.poll();
            for (int i = 0; i < st.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                   String modified = st.substring(0, i) + ch + st.substring(i + 1);
                   if (hs.contains(modified)){
                       q.add(new stringWithTransformation(modified,tid+1));
                       hs.remove(modified);
                   }
                }
            }
        }
        return 0;
    }

//    chatgpt solution optimized
//class stringWithTransformation {
//    String st;
//    int tid;
//    stringWithTransformation(String st, int tid) {
//        this.st = st;
//        this.tid = tid;
//    }
//}
//
//    class Solution {
//        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            if (!wordList.contains(endWord)) {
//                return 0; // If endWord is not in the list, no valid transformation exists.
//            }
//
//            Queue<stringWithTransformation> q = new LinkedList<>();
//            HashSet<String> hs = new HashSet<>(wordList);
//            q.add(new stringWithTransformation(beginWord, 1));
//
//            while (!q.isEmpty()) {
//                String st = q.peek().st;
//                int tid = q.peek().tid;
//                if (st.equals(endWord)) return tid;
//                q.poll();
//
//                // Use StringBuilder to avoid creating multiple String objects
//                StringBuilder sb = new StringBuilder(st);
//
//                for (int i = 0; i < st.length(); i++) {
//                    char originalChar = sb.charAt(i);
//
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        if (ch == originalChar) continue; // Skip the original character
//
//                        sb.setCharAt(i, ch);
//                        String modified = sb.toString();
//
//                        if (hs.contains(modified)) {
//                            q.add(new stringWithTransformation(modified, tid + 1));
//                            hs.remove(modified); // Remove the word from the set to avoid revisiting
//                        }
//                    }
//
//                    // Restore the original character
//                    sb.setCharAt(i, originalChar);
//                }
//            }
//
//            return 0;
//        }
//    }


        public static void main (String[]args){
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
            System.out.println(list);
            HashSet<String> hs = new HashSet<>(list);
            System.out.println(hs);
            hs.remove("log");
            System.out.println(hs);
            Queue<stringWithTransformation> q = new LinkedList<>();
            q.add(new stringWithTransformation("hot", 1));
            System.out.println(q.peek().tid);
            System.out.println("s".equals("s"));
            String s = "hot";
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            System.out.println(ch + s.substring(1));
//        }
//        for (char ch = 'a'; ch <= 'z' ; ch++) {
//            System.out.println(s.substring(0,1) + ch + s.substring(2));
//        }
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            System.out.println(s.substring(0,2) + ch);
//        }
            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    System.out.println(s.substring(0, i) + ch + s.substring(i + 1));
                }
            }
        }
    }

