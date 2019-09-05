package com.ac.jvm.gc;

/**
 * FinalizeEscapeDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-28
 */
public class FinalizeEscapeDemo {

    public static FinalizeEscapeDemo SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("i am still alive now");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method is invoked now");
        FinalizeEscapeDemo.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeDemo();
        /**
         * set the instance as null in order to be collected by gc.
         */
        SAVE_HOOK = null;
        /**
         * simulate  execute gc operation manually
         */
        System.gc();

        /**
         * finalize is very low level，so sleep thread for
         * a while to promise it can be executed.
         */
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" i was dead now ");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" i was dead now ");
        }
    }
}
