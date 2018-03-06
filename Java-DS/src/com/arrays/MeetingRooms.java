package com.arrays;

import java.util.*;

public class MeetingRooms {

	public static void main(String[] args) {

		MeetingRooms m = new MeetingRooms();
		// say input is: [[0, 4],[15, 20],[5, 10]]

		Interval[] intervals = new Interval[] { new Interval(5, 10), new Interval(15, 20), new Interval(0, 4),
				new Interval(22, 26) };

		boolean canAttend = m.canAttendMeetings(intervals);
		System.out.println("Can he attend? " + canAttend);

		Interval[] intervals2 = new Interval[] { new Interval(3, 10), new Interval(11, 20), new Interval(0, 4)};
		int minRoomsReq = m.minMeetingRooms(intervals2);
		System.out.println("Min rooms required "+minRoomsReq);
		
		
	}

	// Meeting room problem 1
	/**
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	 * all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return
	 * false.
	 */

	// If a person can attend all meetings, there must not be any overlaps
	// between any meetings. After sorting the intervals based on start time, we
	// can compare the current end and next start.
	public boolean canAttendMeetings(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start.compareTo(b.start);
			}
		});

		// after sorting: [[0, 4],[5, 10],[15, 20]]
		if (intervals.length <= 1)
			return true;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}

	// Meeting room problem 2
	/**
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms
	 * required.
	 */
	public int minMeetingRooms(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start.compareTo(o2.start);
			}
		});

		PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end.compareTo(o2.end);
			}
		});
		pq.add(intervals[0]);
		int count = 1;
		for(int i=1;i<intervals.length;i++){
			if(intervals[i].start < pq.peek().end){ //overlap condition
				count++;
				pq.add(intervals[i]);
			}
			else{
				//pq.poll(); //not required to poll
				pq.add(intervals[i]);
			}
		}

		return count;
	}

}

class Interval {

	Integer start;
	Integer end;

	public Interval(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}
}
