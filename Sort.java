package com.kashika.p5;

import java.util.*;

public class Sort {
	public Sort() 
	{
		return;
	}
	public void insertionSort(int[] arr) {
		for(int i =1; i < arr.length; i++) { //for entire array
			if(arr[i] < arr[i-1]) { //if element before it is bigger
				int toInsert = arr[i];
				int j = i;
				while(j > 0 && toInsert < arr[j-1]) { //figure out where it actually goes
					arr[j] = arr[j-1]; //shift everythiing over
					j = j-1;
				}
				arr[j] = toInsert; //insert in right place
			}
		}
	}
	public void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int j = indexSmallest(arr, i, arr.length-1); //finds smallest element in unsorted array
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp; //swap and put into place
		}
	}
	
	public int[] randomArray(int n, int a, int b) {
		int[] array = new int[n];
		Random rand;
		for(int j = 0; j < n; j++) {
			array[j] = (int) ((Math.random() * (b - a)) + a); //generates random number and puts in array location in range
		}
		return array;
	}
	private int indexSmallest(int[] arr, int lower, int upper) {
		int indexMin = lower;
		for(int n = lower+1; n <= upper; n++) { //for the range intended
			if(arr[n] < arr[indexMin]) { //if the element at indexMin is smaller than the one at n
				indexMin = n; //set new indexMin
			}
		}
		return indexMin;
	}
	public void quickSort(int[] arr) {
		qSort(arr, 0, arr.length - 1); 
	}
	private void qSort(int[] arr, int start, int end) { //helper method that sorts the individual partitions
		if(start < end) { //if arr length is more than 1 
		int split = partition(arr, start, end); //finds partition
		 
		qSort(arr, start, split-1); //sort before partition and with it
		qSort(arr, split+1, end); //sort after partition
		}
	}
	private static int partition(int[] arr, int first, int last)
	{
		int pivot = arr[last]; //pivot is the last element
	     
	    int i = (first - 1); //leftmost element and the right position of the partition so far
	 
	    for(int j = first; j <= last - 1; j++) //for the bounds indicated 
	    {
	         
	        if (arr[j] < pivot) //if the element at rn is smaller than pivot
	        {
	             
	            i++; //smaller index (partition) increments
	            int temp = arr[i]; //swap elements
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    int temp2 = arr[i+1]; //swap partition and last element
	    arr[i+1] = arr[last];
	    arr[last] = temp2;
	    return (i + 1); //returns partition
	}
	public void mergeSort(int[] arr) { 
		int[] temp = new int[arr.length]; //creates temp array
		mSort(arr, temp, 0, arr.length-1); //calls private merge sort method
	}
	private void mSort(int[] arr, int[] temp, int start, int end) {
		if(start == end) { //if array is length 1
			return; //return
		}
		int middle = (start+end)/2; //find middle
		mSort(arr, temp, start, middle); //call merge sort for first half
		mSort(arr, temp, middle+1, end);  //call merge sort for second half
		merge(arr, temp, start, middle, middle+1, end); //merge arrays and sort
	}
	private void merge(int[] arr, int[] temp, int start1, int end1, int start2, int end2) {
		int i = start1; //start of first array
		int j = start2; //start of second array
		int k = start1; //starting point for temp array
		while(i <= end1 && j <= end2) { //if not out of bounds for both 
			if(arr[i] < arr[j]) { //if one in first subarray is less than one in second 
				temp[k] = arr[i]; //put it in temp array
				i++; //increment array that was put in
				k++; //incrememnt temp array 
			}
			else {
				temp[k] = arr[j]; //switch the other
				j++;
				k++;
			}
		}
		while(i <= end1) { //if left over put in
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j <= end2) { //if left over put in
			temp[k] = arr[j];
			k++;
			j++;
		}
		for(int n = start1; n <= end2; n++) { //push into real array
			arr[n] = temp[n];
		}
	}
	public static void main(String[] args)
    {
		Sort newSort = new Sort();
		int[] arr1 = newSort.randomArray(10, 1, 100);
		int[] arr2 = newSort.randomArray(20, 1, 100);
		int[] arr3 = newSort.randomArray(50, 1, 100);
		int[] arr4 = newSort.randomArray(100, 1, 100);
		int[] arr5 = newSort.randomArray(200, 1, 100);
		int[] arr6 = newSort.randomArray(500, 1, 100);
		int[] arr7 = newSort.randomArray(1000, 1, 100);
		int[] arr8 = newSort.randomArray(5000, 1, 100);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		newSort.quickSort(arr1);
		
		newSort.insertionSort(arr2);
		newSort.mergeSort(arr3);
		long startTime = System.nanoTime();
		newSort.selectionSort(arr8);
		long endTime = System.nanoTime();
		long runtime = endTime - startTime;
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(runtime);

	}
}
