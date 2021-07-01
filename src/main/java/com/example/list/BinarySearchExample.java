package com.example.list;

public class BinarySearchExample {

	public static int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
		int index = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println("Binary Search for key = 6 is having index = "
				+ runBinarySearchIteratively(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 6, 1, 10));
	}
}
