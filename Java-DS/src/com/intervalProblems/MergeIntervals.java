package com.intervalProblems;

import java.util.*;

public class MergeIntervals {
	public static void main(String[] args) {

	}

	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18]
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start.compareTo(o2.start);
			}
		});

		List<Interval> result = new ArrayList<>();

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {

			Interval curr = intervals.get(i);

			if (prev.end >= curr.start) {
				// overlapping
				Integer start = Math.min(prev.start, curr.start);
				Integer end = Math.max(prev.end, curr.end);
				prev = new Interval(start, end);
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
	}
}
