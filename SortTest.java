package com.kashika.p5;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

	@Test
	public void testInsertionSort() {
		Sort newSort = new Sort();
		int[] arr1 = new int[] {5, 4 , 3, 6, 2, 1, 8, 7, 10, 9};
		newSort.insertionSort(arr1);
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr1));
	}

	@Test
	public void testSelectionSort() {
		Sort newSort = new Sort();
		int[] arr1 = new int[] {5, 4 , 3, 6, 2, 1, 8, 7, 10, 9};
		newSort.selectionSort(arr1);
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr1));
		}
	
	@Test
	public void testQuickSort() {
		Sort newSort = new Sort();
		int[] arr1 = new int[] {5, 4 , 3, 6, 2, 1, 8, 7, 10, 9};
		newSort.quickSort(arr1);
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr1));
		}

	@Test
	public void testMergeSort() {
		Sort newSort = new Sort();
		int[] arr1 = new int[] {5, 4 , 3, 6, 2, 1, 8, 7, 10, 9};
		newSort.mergeSort(arr1);
		Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", Arrays.toString(arr1));
		}

}
