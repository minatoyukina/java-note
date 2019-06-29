package design_pattern.red_write_lock;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReaderWriterLock implements ReadWriteLock {
    private final Object readerMutex = new Object();
    private int currentReaderCount;
    private final Set<Object> globalMutex = new HashSet<>();
    private ReadLock readerLock = new ReadLock();
    private WriteLock writerLock = new WriteLock();

    @Override
    @Nonnull
    public Lock readLock() {
        return readerLock;
    }

    @Override
    @Nonnull
    public Lock writeLock() {
        return writerLock;
    }

    private boolean doesWriterOwnThisLock() {
        return globalMutex.contains(writerLock);
    }

    private boolean doesReaderOwnThisLock() {
        return globalMutex.contains(readerLock);
    }

    private boolean isLockFree() {
        return globalMutex.isEmpty();
    }

    private static void waitUninterruptedly(Object o) {
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ReadLock implements Lock {
        @Override
        public void lock() {
            synchronized (readerMutex) {
                currentReaderCount++;
                if (currentReaderCount == 1) {
                    synchronized (globalMutex) {
                        while (true) {
                            if (isLockFree() || doesReaderOwnThisLock()) {
                                globalMutex.add(this);
                                break;
                            } else {
                                waitUninterruptedly(globalMutex);
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void lockInterruptibly() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock(long time, @Nonnull TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void unlock() {
            synchronized (readerMutex) {
                currentReaderCount--;
                if (currentReaderCount == 0) {
                    synchronized (globalMutex) {
                        globalMutex.remove(this);
                        globalMutex.notifyAll();
                    }
                }
            }
        }

        @Override
        @Nonnull
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }

    private class WriteLock implements Lock {
        @Override
        public void lock() {
            synchronized (globalMutex) {
                while (true) {
                    if (isLockFree()) {
                        globalMutex.add(this);
                        break;
                    } else if (doesWriterOwnThisLock()) {
                        waitUninterruptedly(globalMutex);
                    } else if (doesReaderOwnThisLock()) {
                        waitUninterruptedly(globalMutex);
                    } else {
                        throw new AssertionError("it should never reach here");
                    }
                }
            }
        }

        @Override
        public void lockInterruptibly() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean tryLock(long time, @Nonnull TimeUnit unit) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void unlock() {
            synchronized (globalMutex) {
                globalMutex.remove(this);
                globalMutex.notifyAll();
            }
        }

        @Override
        @Nonnull
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }
}
