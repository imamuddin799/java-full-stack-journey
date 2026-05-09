package collection_13.queue_03.priorityqueue.jan_02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample02 {

	public static void main(String[] args) {
		Comparator<INT> com = (o1, o2) -> {
			if (o1.a % 2 == 0 && o2.a % 2 == 1) {
				return -1;
			}
			if (o1.a % 2 == 1 && o2.a % 2 == 0) {
				return 1;
			}
			return 0;
		};

		PriorityQueue<INT> pq = new PriorityQueue<INT>(com);
		pq.offer(new INT(10));
		pq.offer(new INT(7));
		pq.offer(new INT(3));
		pq.offer(new INT(8));
		pq.offer(new INT(11));
		pq.offer(new INT(6));
		System.out.println(pq);

		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
			System.out.println(pq);
		}
	}
}