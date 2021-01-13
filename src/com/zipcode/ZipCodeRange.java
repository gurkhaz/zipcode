package com.zipcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZipCodeRange {

	public static void main(String[] args) {
		 Range p1 = new Range(49679, 52015);
		 Range p2 = new Range(49800, 50000);
		 Range p3 = new Range(51500, 53479);
		 Range p4 = new Range(45012, 46937);
		 Range p5 = new Range(54012, 59607);
		 Range p6 = new Range(45500, 45590);
		 Range p7 = new Range(45999, 47900);
		 Range p8 = new Range(44000, 45000);
		 Range p9 = new Range(43012, 45950);
		 
		 List<Range> list = new ArrayList<>();
			list.add(p1);
			list.add(p2);
			list.add(p3);
			list.add(p4);
			list.add(p5);
			list.add(p6);
			list.add(p7);
			list.add(p8);
			list.add(p9);
			
			
			
			System.out.println("------input---------");
			List<Range> zipList = list.stream().sorted((x,y)->x.getX().compareTo(y.getX()))
					.collect(Collectors.toList());	

			for (Range Range : zipList) {
				System.out.println("[" + Range.getX() + ", " + Range.getY() + "]");

			}

			List<Range> listOutput = new ArrayList<>();
			Range firstRange = zipList.get(0);

			for (int i = 0; i < zipList.size(); i++) {

				firstRange = getRange(firstRange, zipList.get(i), listOutput);

			}
			listOutput.add(firstRange);

			System.out.println("------output---------");

			for (Range Range : listOutput) {
				System.out.println("[" + Range.getX() + ", " + Range.getY() + "]");
			}

		}
		
					

		private static Range getRange(Range firstRange, Range secondRange, List<Range> listOutput) {
			int firstX = firstRange.getX();
			int firstY = firstRange.getY();
			int secondX = secondRange.getX();
			int secondY = secondRange.getY();
			if (secondX - 1 <= firstY) {
				if (firstY > secondY) {
					return new Range(firstX, firstY);
				} else {
					return new Range(firstX, secondY);

				}
			}
			System.out.println("adding  Range  to listOutput "+ firstRange.getX() +" "+firstRange.getY());
			listOutput.add(firstRange);
			return secondRange;
			

	}


}
