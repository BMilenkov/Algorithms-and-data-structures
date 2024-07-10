package Labs.Lab7;


import java.util.Scanner;

//class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
//
//    K key;
//    E value;
//    public MapEntry (K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//
//    public int compareTo (K that) {
//        @SuppressWarnings("unchecked")
//        MapEntry<K,E> other = (MapEntry<K,E>) that;
//        return this.key.compareTo(other.key);
//    }
//
//    public String toString () {
//        return "<" + key + "," + value + ">";
//    }
//}
//
//class SLLNode<E> {
//    protected E element;
//    protected SLLNode<E> succ;
//
//    public SLLNode(E elem, SLLNode<E> succ) {
//        this.element = elem;
//        this.succ = succ;
//    }
//
//public E getElement() {
//        return element;
//        }
//
//    @Override
//    public String toString() {
//        return element.toString();
//    }
//}
//
//
//class CBHT<K extends Comparable<K>, E> {
//    private SLLNode<MapEntry<K,E>>[] buckets;
//
//    @SuppressWarnings("unchecked")
//    public CBHT(int m) {
//        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
//    }
//
//    private int hash(K key) {
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public SLLNode<MapEntry<K,E>> search(K targetKey) {
//        int b = hash(targetKey);
//        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
//                return curr;
//        }
//        return null;
//    }
//
//    public void insert(K key, E val) {
//        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
//        int b = hash(key);
//        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
//            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
//                curr.element = newEntry;
//                return;
//            }
//        }
//        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
//    }
//
//
//
//    public void delete(K key) {
//        int b = hash(key);
//        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
//            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
//                if (pred == null)
//                    buckets[b] = curr.succ;
//                else
//                    pred.succ = curr.succ;
//                return;
//            }
//        }
//    }
//
//    public String toString() {
//        String temp = "";
//        for (int i = 0; i < buckets.length; i++) {
//            temp += i + ":";
//            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
//                temp += curr.element.toString() + " ";
//            }
//            temp += "\n";
//        }
//        return temp;
//    }
//}


public class RoutingHashJava {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        CBHT<String, RouterNetworks> table = new CBHT<>(100);

        for (int i = 0; i < n; ++i) {
            String interfaceIP = scan.nextLine();
            String deviceIP = scan.nextLine();
            table.insert(interfaceIP, new RouterNetworks(deviceIP));
        }

        int N = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < N; i++) {
            String interfaceID = scan.nextLine();
            String deviceIP = scan.nextLine();

            if (table.search(interfaceID) == null) {
                System.out.println("ne postoi");
                continue;
            }

            SLLNode<MapEntry<String, RouterNetworks>> temp = table.search(interfaceID);
            boolean hasFound = false;
            while (temp != null) {
                if (temp.getElement().value.knowTheIP(deviceIP)) {
                    hasFound = true;
                    System.out.println("postoi");
                }
                temp = temp.succ;
            }
            if (!hasFound)
                System.out.println("ne postoi");
        }
    }
}

class RouterNetworks {
    String[] DeviceIPs;

    public RouterNetworks(String deviceIPs) {
        String[] parts = deviceIPs.split(",");
        this.DeviceIPs = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            this.DeviceIPs[i] = parts[i];
        }
    }

    public boolean knowTheIP(String DeviceIp) {
        String partsDeviceIP[] = DeviceIp.split("\\.");
        for (int i = 0; i < DeviceIPs.length; i++) {
            String[] r = DeviceIPs[i].split("\\.");
            if (r[0].equals(partsDeviceIP[0]) && r[1].equals(partsDeviceIP[1])
                    && r[2].equals(partsDeviceIP[2]))
                return true;
        }
        return false;
    }
}