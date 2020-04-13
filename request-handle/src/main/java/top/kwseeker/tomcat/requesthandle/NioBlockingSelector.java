package top.kwseeker.tomcat.requesthandle;

import top.kwseeker.tomcat.util.SynchronizedQueue;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class NioBlockingSelector {

    private static int threadCounter = 0;

    protected Selector sharedSelector;
    protected BlockPoller poller;

    public void open(Selector selector) {
        sharedSelector = selector;
        poller = new BlockPoller();
        poller.setDaemon(true);     //主线程退出后且没有用户线程，poller线程随着一起关闭
        poller.setName("NioBlockingSelector.BlockPoller-"+(++threadCounter));
        poller.start();
    }

    public void close() {
        if(poller != null) {
            poller.interrupt();
            poller = null;
        }
    }

    protected static class BlockPoller extends Thread {

        protected volatile boolean run = true;
        protected Selector selector = null;
        //
        protected final SynchronizedQueue<Runnable> events = new SynchronizedQueue<>();
        //
        protected final AtomicInteger wakeupCounter = new AtomicInteger(0);

        /**
         * 循环处理socket事件
         */
        @Override
        public void run() {
            while (run) {
                try {
                    events();
                    int keyCount = 0;
                    int i= wakeupCounter.get();
                    if(i>0) {
                        keyCount = selector.selectNow();
                    } else {
                        wakeupCounter.set(-1);
                        keyCount = selector.select(1000);
                    }
                    wakeupCounter.set(0);
                    if(!run)
                        break;

                    Iterator<SelectionKey> iterator = keyCount > 0 ? selector.selectedKeys().iterator() : null;
                    while (run && iterator != null && iterator.hasNext()) {
                        SelectionKey sk = iterator.next();

                        iterator.remove();
                        sk.interestOps(sk.interestOps() & (~sk.readyOps()));


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            events.clear();
            try {
                if(selector.isOpen()) {
                    selector.selectNow();
                }
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //
        public boolean events() {
            Runnable r = null;
            int size = events.size();
            for (int i = 0; i < size && (r = events.poll()) != null; i++) {
                r.run();
            }
            return (size > 0);
        }
    }
}
