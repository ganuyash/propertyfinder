package com.propertyfinder.test.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringHandler {

	public static List<String> getCollection(String value, String seperator) {

		List<String> s = Arrays.asList(value.split(seperator));
		return s;
	}

	public static void main(String[] args) {
		System.out.println(getCollection("daw!1100!fas", "!"));
	}

}
