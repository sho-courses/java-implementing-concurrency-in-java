package io.github.shomeier.module6;

public class Livelock {

    public static void run() {
        PhoneCall buddy1 = new PhoneCall("Patricia");
        PhoneCall buddy2 = new PhoneCall("Patrick");
        HangUp hangUpAction = new HangUp(buddy1);

        new Thread(() -> buddy1.endCallWith(hangUpAction, buddy2)).start();
        new Thread(() -> buddy2.endCallWith(hangUpAction, buddy1)).start();
    }

    static class HangUp {
        private PhoneCall caller;

        public HangUp(PhoneCall caller) {
            this.caller = caller;
        }

        public void setCaller(PhoneCall caller) {
            this.caller = caller;
        }

        public void end() {
            System.out.println(this.caller.name + " has hang up");
        }
    }

    static class PhoneCall {
        private final String name;
        private boolean isDone;

        public PhoneCall(String name) {
            this.name = name;
            this.isDone = false;
        }

        public String getName() {
            return this.name;
        }

        public boolean isDone() {
            return this.isDone;
        }

        public void endCallWith(HangUp hangUp, PhoneCall buddy) {
            while (!isDone) {
                if (hangUp.caller != this) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                if (!buddy.isDone()) {
                    System.out.println(name + ": No you hang up, buddy " + buddy.getName());
                    hangUp.setCaller(buddy);
                    continue;
                }

                hangUp.end();
                buddy.isDone = true;
                isDone = true;
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
