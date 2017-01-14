package LeetCode;

public class ReadNCharactersGivenRead4 {

    public int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        char[] buffer4 = new char[4];
        if (n < 1)
            return n;
        int readbytes = 0;
        boolean eof = false;
        while (!eof && readbytes < n) {
            int currentread = read4(buffer4);
            if (currentread < 4)
                eof = true;
            int bytes = Math.min(currentread, n - readbytes);
            System.arraycopy(buffer4, 0, buf, readbytes, bytes);
            readbytes += bytes;
        }
        return readbytes;
    }

    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;

    public int read_multi(char[] buf, int n) {
        boolean eof = false;
        int readbytes = 0;
        while (!eof && readbytes < n) {
            if (bufsize == 0) {
                bufsize = read4(buffer);
                eof = bufsize < 4;
            }
            int sz = Math.min(bufsize, n - readbytes);
            System.arraycopy(buffer, offset, buf, readbytes, sz);
            offset = (offset + sz) % 4;
            bufsize -= sz;
            readbytes += sz;
        }
        return readbytes;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
