class Solution {
  public String add36Strings(String num1, String num2) {
      int carry = 0;
      int i = num1.length() - 1;
      int j = num2.length() - 1;
      StringBuilder res = new StringBuilder();
      while (i >= 0 || j >= 0 || carry > 0) {
          int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
          int y = j >= 0 ? getInt(num2.charAt(j)) - '0' : 0;
          int temp = x + y + carry;
          res.append(getChar(temp % 36));
          carry = temp / 36;
          i--;
          j--;
      }
      return res.reverse().toString();
  }

  private Character getChar(int n) {
    if (n <= 9) {
      return (char)(n + '0');
    } else {
      return (char)(n - 10 + 'a');
    }
  }

  private int getInt(Character ch) {
    if ('0' <= ch && ch <= '9') {
      return ch - '0';
    } else {
      return ch - 'a' + 10;
    }
  }
}
