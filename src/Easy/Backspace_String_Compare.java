package Easy;
//Question 844
//Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//Note that after backspacing an empty text, the text will continue empty.
//        Example 1:
//        Input: s = "ab#c", t = "ad#c"
//        Output: true
//        Explanation: Both s and t become "ac".


public class Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '#'){
                if(!sBuilder.isEmpty())
                    sBuilder.deleteCharAt(sBuilder.length() -1);
            }else {
                sBuilder.append(s.charAt(i));
            }
        }
        for(int j = 0; j < t.length(); ++j){
            if(t.charAt(j) == '#'){
                if(!tBuilder.isEmpty())
                    tBuilder.deleteCharAt(tBuilder.length() -1);
            }else{
                tBuilder.append(t.charAt(j));
            }
        }
        return tBuilder.toString().equals(sBuilder.toString());
    }

    public static void main(String[] args) {
        Backspace_String_Compare solution = new Backspace_String_Compare();
        System.out.println(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
