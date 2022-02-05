public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
    int idx = 0;     
    char[] buf4 = new char[4];
    int size = read4(buf4);
    while (size > 0 && idx < n) {
      for (int i = 0; i < size && idx < n; i++) {
        buf[idx] = buf4[i];
        idx++;
      }
      size = read4(buf4);
    }
    return idx;
  }
}
