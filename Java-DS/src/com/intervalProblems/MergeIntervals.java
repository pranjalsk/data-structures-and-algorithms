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

	/**
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<>();

		for (Interval curr : intervals) {

			if (newInterval.start > curr.end) {
				result.add(curr);
			} else if (newInterval.end < curr.start) {
				result.add(newInterval);
				newInterval = curr;
			} else if (newInterval.start <= curr.end) {
				Integer start = Math.min(newInterval.start, curr.start);
				Integer end = Math.max(newInterval.end, curr.end);
				newInterval = new Interval(start, end);
			}
		}

		result.add(newInterval);
		return result;
	}

}
