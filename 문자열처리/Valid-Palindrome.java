class Solution {
    public boolean isPalindrome(String s) {

        s = s.toUpperCase();
        String helper= "";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                helper += String.valueOf(s.charAt(i));
            }
        }
        for(int i=0;i<helper.length()/2;i++){
            if(helper.charAt(i) != helper.charAt(helper.length()-1-i))return false;
        }
        return true;
    }
}