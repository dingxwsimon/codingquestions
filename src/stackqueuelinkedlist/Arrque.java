package stackqueuelinkedlist;

import java.util.Random;

public final class Arrque<T> {

    public Arrque(int siz) {
	if (siz < 1) {
	    grow_ = true;
	    siz_ = 32;
	} else
	    siz_ = siz;

	ary_ = (T[]) new Object[siz_];
    }

    /**
     * Circularly increment i.
     */
    final int inc(int i) {
	return (++i == siz_) ? 0 : i;
    }

    public synchronized boolean remove(T obj) {
	if (obj == null)
	    return false;
	int foundAt = -1;
	int count = 0;
	for (int i = readIdx_; ++count <= pop_; i = inc(i)) {
	    if (ary_[i].equals(obj)) {
		foundAt = i;
		break;
	    }
	}
	if (foundAt != -1) {
	    removeAt(foundAt);
	    return true;
	} else {
	    return false;
	}

    }

    public synchronized void removeAt(int i) {
	// if removing front item, just advance
	if (i == readIdx_) {
	    ary_[readIdx_] = null;
	    readIdx_ = inc(readIdx_);
	} else {
	    // slide over all others up through writeIndex.
	    for (;;) {
		int nexti = inc(i);
		if (nexti != writeIdx_) {
		    ary_[i] = ary_[nexti];
		    i = nexti;
		} else {
		    ary_[i] = null;
		    writeIdx_ = i;
		    break;
		}
	    }
	}
	--pop_;
	notify();
    }

    public synchronized void enqueue(T obj) {
	if (pop_ >= siz_)
	    if (grow_)
		grow();
	    else
		try {
		    while (pop_ >= siz_)
			wait();
		} catch (InterruptedException e) {
		    return; // !!! discard obj
		}

	ary_[writeIdx_] = obj;
	writeIdx_ = (writeIdx_ + 1) % siz_;
	++pop_;
	notify();
    }

    public synchronized T dequeue() {
	try {
	    while (pop_ <= 0) {
		wait();
	    }
	} catch (InterruptedException e) {
	    return null; // !!! caller better be ready for null
	}

	T rv = ary_[readIdx_];
	ary_[readIdx_] = null; // enable gc
	readIdx_ = (readIdx_ + 1) % siz_;
	--pop_;
	notify();
	return rv;
    }

    // dequeue with timeout; if the wait timeout expires, NULL is returned
    // rather than waiting again
    public synchronized T dequeue(long timeout) {
	long start = System.currentTimeMillis();
	try {
	    long now = System.currentTimeMillis();
	    while (pop_ <= 0 && now < start + timeout) {
		wait((start + timeout) - now);
		now = System.currentTimeMillis();
	    }
	    if (pop_ <= 0)
		return null;
	} catch (InterruptedException e) {
	    return null; // !!! caller better be ready for null
	}

	T rv = ary_[readIdx_];
	ary_[readIdx_] = null; // enable gc
	readIdx_ = (readIdx_ + 1) % siz_;
	--pop_;
	notify();
	return rv;
    }

    public int getLen() {
	return pop_;
    }

    public void setGrowable() {
	grow_ = true;
    }

    void grow() {
	int newsiz = siz_ * 2;
	T[] newary = (T[]) new Object[newsiz];
	int j = readIdx_;
	for (int i = 0; i < pop_; ++i) {
	    newary[i] = ary_[j];
	    j = (j + 1) % siz_;
	}
	ary_ = newary;
	siz_ = newsiz;
	readIdx_ = 0;
	writeIdx_ = pop_;
    }

    boolean grow_ = false;
    int siz_;
    int pop_ = 0;
    int readIdx_ = 0;
    int writeIdx_ = 0;
    T[] ary_;

    public static void main(String[] argv) {
	try {
	    /*
	     * Arrque queue = new Arrque(0); for (int i = 0; i < 100; ++i) {
	     * Runnable r = new ArrqueTester(i, queue); new Thread(r).start(); }
	     */
	    Arrque queue = new Arrque(10);
	    for (int i = 0; i < 7; i++)
		queue.enqueue(i);
	    for (Object o : queue.ary_)
		System.out.print(o);
	    System.out.println();
	    queue.remove(3);
	    queue.remove(4);
	    for (Object o : queue.ary_)
		System.out.print(o);
	    System.out.println();

	    queue.dequeue();
	    queue.dequeue();

	    for (int i = 0; i < 7; i++)
		queue.enqueue(i);

	    for (Object o : queue.ary_)
		System.out.print(o);
	    System.out.println();

	    queue.remove(3);
	    queue.remove(4);

	    for (Object o : queue.ary_)
		System.out.print(o);
	    System.out.println();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

class ArrqueTester implements Runnable {

    public ArrqueTester(int num, Arrque queue) {
	num_ = num;
	queue_ = queue;
    }

    public void run() {
	try {
	    int i = 0;
	    Random rand = new Random();
	    for (;;) {
		boolean b = rand.nextBoolean();
		if (num_ == 0)
		    b = false;
		if (num_ == 1)
		    b = true;

		if (b)
		    queue_.enqueue(new Integer(i++));
		else
		    System.out.println("got " + queue_.dequeue());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    int num_;
    Arrque queue_;
}