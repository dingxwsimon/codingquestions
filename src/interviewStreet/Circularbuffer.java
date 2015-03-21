package interviewStreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Circularbuffer
{

  public static class CircularBuffer<T>
  {

    private T[] buffer;
    private int head;
    private int maxsize;
    private int qsize;

    public CircularBuffer(int n)
    {
      buffer = (T[]) new Object[n];
      head = 0;
      maxsize = n;
      qsize = 0;
    }

    public void append(T toAdd)
    {
      int end = (head + qsize) % maxsize;
      buffer[end] = toAdd;
      if (qsize == maxsize) {
        head = (head + 1) % maxsize;
      }
      else
        qsize++;
    }

    public void remove()
    {
      if (qsize == 0) return;
      head = (head + 1) % maxsize;
      qsize = qsize - 1;
    }

    public ArrayList<T> getALL()
    {
      ArrayList<T> ret = new ArrayList<T>();
      if (qsize == 0) return ret;
      for (int i = 0 ; i < qsize ; i++) {
        ret.add(buffer[(head + i) % maxsize]);
      }
      return ret;
    }

  }

  public static void main(String args[])
      throws Exception
  {
    BufferedReader br = new BufferedReader(new FileReader("./test.txt"));
    String line = br.readLine();
    int N = Integer.parseInt(line);
    CircularBuffer cb = new CircularBuffer<String>(N);
    while (!(line = br.readLine()).equals("Q")) {
      if (line.charAt(0) == 'A') {
        int k = Integer.parseInt(line.split(" ")[1]);
        for (int i = 0 ; i < k ; i++) {
          line = br.readLine();
          cb.append(line);
        }
      }
      else if (line.charAt(0) == 'R') {
        int k = Integer.parseInt(line.split(" ")[1]);
        for (int i = 0 ; i < k ; i++)
          cb.remove();
      }
      else if (line.charAt(0) == 'L') {
        ArrayList<String> list = cb.getALL();
        for (int i = 0 ; i < list.size() ; i++) {
          System.out.println(list.get(i));
        }
      }
    }
  }
}
