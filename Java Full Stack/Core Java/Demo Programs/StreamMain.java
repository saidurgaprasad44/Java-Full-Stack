package javaPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args){
		
		int[] nums = {1,2,3,4,5,6};
		List<Integer> names1 = Arrays.stream(nums)
			.boxed()
			.filter(n -> n%2==0)
			.map(n -> n*2)
			.toList();
		System.out.println(names1);
		
	}

}
