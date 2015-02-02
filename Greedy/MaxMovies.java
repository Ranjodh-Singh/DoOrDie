package edu.princeton.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author ranjodh_singh. You are given n activities with their start and finish
 *         times. Select the maximum number of activities that can be performed
 *         by a single person, assuming that a person can only work on a single
 *         activity at a time.
 *
 */
public class MaxMovies {

	public static void main(String[] args) throws InterruptedException {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 2, 4, 6, 7, 9, 9 };
		List<Activity> activities = new ArrayList<Activity>();
		for (int i = 0; i < finish.length; i++) {
			Activity activity = new Activity(start[i], finish[i]);
			activities.add(activity);
		}
		Collections.sort(activities);
		for (Activity activity : activities) {
			System.out.println(activity);
		}
		System.out.println("answer\n"+activities.get(0));
		int next=0;
	for (int i = 1; i < activities.size(); i++) {
		if(activities.get(next).finish < activities.get(i).start){
			
			System.out.println(activities.get(i));
			next =i;
		}
	}

	}

	static class Activity implements Comparable<Activity> {
		int start, finish;
		int hours;

		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
			this.hours = finish - start;
		}

		@Override
		public String toString() {
			return "Activity [start=" + start + ", finish=" + finish + ", hours=" + hours + "]";
		}
// trick is to sort by the finish time and pick the first element by default.
		@Override
		public int compareTo(Activity o) {
			if (this.finish < o.finish) {
				return -1;
			} else if (this.finish > o.finish) {
				return 1;
			} else {
				return 0;
			}

		}
	}

}
