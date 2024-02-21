package hw2;

import edu.princeton.cs.algs4.StdOut;


public class String implements Comparable<String> {
	
	private char[] data;   // Holds the characters that are in the String

	
	/**
     * Allocates a new {@code String} so that it represents the sequence of
     * characters currently contained in the character array argument. The
     * contents of the character array are copied; subsequent modification of
     * the character array does not affect the newly created string.
     *
     * @param  value
     *         The initial value of the string
     */
	public String(String original) {
		this(original.data);
	}
	
    /**
     * Allocates a new {@code String} so that it represents the sequence of
     * characters currently contained in the character array argument. The
     * contents of the character array are copied; subsequent modification of
     * the character array does not affect the newly created string.
     *
     * @param  value
     *         The initial value of the string
     */
	public String(char[] value) {
		this(value, 0, value.length);
	}
	
	
	/**
	 * IGNORE THIS METHOD.  IT IS PRESENT FOR TECHINCIAL REASONS NOT RELATED
	 * TO THIS ASSIGNMENT.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		String other = (String) obj;
		return this.equals(other);
	}
	
	
    /**
     * Returns the {@code char} value at the
     * specified index. An index ranges from {@code 0} to
     * {@code length() - 1}. The first {@code char} value of the sequence
     * is at index {@code 0}, the next at index {@code 1},
     * and so on, as for array indexing.
     *
     * <p>If the {@code char} value specified by the index is a
     * <a href="Character.html#unicode">surrogate</a>, the surrogate
     * value is returned.
     *
     * @param      index   the index of the {@code char} value.
     * @return     the {@code char} value at the specified index of this string.
     *             The first {@code char} value is at index {@code 0}.
     * @throws     IndexOutOfBoundsException  if the {@code index}
     *             argument is negative or not less than the length of this
     *             string.
     */
	public char charAt(int index) {
		return data[index];
	}
	
	/**
	 * Prints the String to the screen.  This method is here to help you
	 * debug your code.
	 */
	public void printToScreen() {
		for(int i = 0; i < data.length; i++)
			StdOut.print(data[i]);
		StdOut.println();
	}

	
	/************** NO CHANGES ALLOWED ABOVE THIS LINE ****************/
	

    /**
     * Allocates a new {@code String} that contains characters from a subarray
     * of the character array argument. The {@code offset} argument is the
     * index of the first character of the subarray and the {@code count}
     * argument specifies the length of the subarray. The contents of the
     * subarray are copied; subsequent modification of the character array does
     * not affect the newly created string.
     *
     * @param  value
     *         Array that is the source of characters
     *
     * @param  offset
     *         The initial offset
     *
     * @param  count
     *         The length
     *
     * @throws  IndexOutOfBoundsException
     *          If {@code offset} is negative, {@code count} is negative, or
     *          {@code offset} is greater than {@code value.length - count}
     */	
	public String(char[] value, int offset, int count) {
		// TODO
		if (offset < 0 || count < 0 || offset > value.length - count) {
			throw new IndexOutOfBoundsException("Out of bounds");
		}
		this.data = new char[count];
		for(int i = 0; i < count; i++) {
			data[i] = value[offset+i];

		}
	
		}

	

    /**
     * Returns the length of this string.
     * The length is equal to the number of <a href="Character.html#unicode">Unicode
     * code units</a> in the string.
     *
     * @return  the length of the sequence of characters represented by this
     *          object.
     */
	public int length() {
		// TODO
		return data.length;
	}
	

	

    /**
     * Returns the index within this string of the first occurrence of the
     * specified character, starting the search at the specified index.
     * <p>
     * If a character with value {@code ch} occurs in the
     * character sequence represented by this {@code String}
     * object at an index no smaller than {@code fromIndex}, then
     * the index of the first such occurrence is returned. For values
     * of {@code ch} in the range from 0 to 0xFFFF (inclusive),
     * this is the smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.charAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
     * </pre></blockquote>
     * is true. For other values of {@code ch}, it is the
     * smallest value <i>k</i> such that:
     * <blockquote><pre>
     * (this.codePointAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
     * </pre></blockquote>
     * is true. In either case, if no such character occurs in this
     * string at or after position {@code fromIndex}, then
     * {@code -1} is returned.
     *
     * <p>
     * There is no restriction on the value of {@code fromIndex}. If it
     * is negative, it has the same effect as if it were zero: this entire
     * string may be searched. If it is greater than the length of this
     * string, it has the same effect as if it were equal to the length of
     * this string: {@code -1} is returned.
     *
     * <p>All indices are specified in {@code char} values
     * (Unicode code units).
     *
     * @param   ch          a character.
     * @param   fromIndex   the index to start the search from.
     * @return  the index of the first occurrence of the character in the
     *          character sequence represented by this object that is greater
     *          than or equal to {@code fromIndex}, or {@code -1}
     *          if the character does not occur.
     */
	public int indexOf(char c, int index) {
		// TODO
		if (index < 0) {
			index = 0;
		}
		for (int i = index; i < data.length; i++) { //iterates and checks every char if its the return character
			if (data[i] == c) {
				return i;
			}

		}
		return -1;
	}
	

    /**
     * Returns a string resulting from replacing all occurrences of
     * {@code oldChar} in this string with {@code newChar}.
     * <p>
     * If the character {@code oldChar} does not occur in the
     * character sequence represented by this {@code String} object,
     * then a reference to this {@code String} object is returned.
     * Otherwise, a {@code String} object is returned that
     * represents a character sequence identical to the character sequence
     * represented by this {@code String} object, except that every
     * occurrence of {@code oldChar} is replaced by an occurrence
     * of {@code newChar}.
     * <p>
     * Examples:
     * <blockquote><pre>
     * "mesquite in your cellar".replace('e', 'o')
     *         returns "mosquito in your collar"
     * "the war of baronets".replace('r', 'y')
     *         returns "the way of bayonets"
     * "sparring with a purple porpoise".replace('p', 't')
     *         returns "starring with a turtle tortoise"
     * "JonL".replace('q', 'x') returns "JonL" (no change)
     * </pre></blockquote>
     *
     * @param   oldChar   the old character.
     * @param   newChar   the new character.
     * @return  a string derived from this string by replacing every
     *          occurrence of {@code oldChar} with {@code newChar}.
     */
	public String replace(char oldChar, char newChar) {
		// TODO
		char[] str = new char[data.length]; //nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare 
		for (int i = 0; i < data.length; i++) { //nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare 
			str[i] = data[i]; //nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare 
		} //nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare nightmare 
		boolean newCharFound = false;
		for (int i = 0; i < data.length; i++) {
			if (str[i] != oldChar) {
				//pass																																																																																
			}
			else{	//it took me 3 days of bashing my head against this stupid method to get it to work JUST TRUST ME IT WORKS IM NOT EXPLAINING IT
				str[i] = newChar;
				newCharFound = true;
			}
		}
		if (newCharFound == false) {
			return this;
		}
		return new String(str); 
	}




	/**
     * Splits this string around matches of the given character.
     *
     * <p> The array returned by this method contains each substring of this
     * string that is terminated by another substring that matches the given
     * character or is terminated by the end of the string.  The substrings in
     * the array are in the order in which they occur in this string.  If the
     * character does not match any part of the input then the resulting array
     * has just one element, namely this string.
     *
     * <p> When there is a match at the beginning of this
     * string then an empty leading substring is included at the beginning
     * of the resulting array. A zero-width match at the beginning however
     * never produces such empty leading substring.
     *
     * <p> The string {@code "boo:and:foo"}, for example, yields the
     * following results with these parameters:
     *
     * @param  character
     *         the delimiting character
     *
     * @return  the array of strings computed by splitting this string
     *          around matches of the given regular expression
     */
	public String[] split(char character) {
		// TODO

		int limCounter = 0;
		for (char i : data) {
			if (i == character) { //defines length of returned array
				limCounter++;
			}
		}
		if (limCounter == 0) {
			String[] returnNull = new String[1];
			returnNull[0] = this;
			return returnNull;
		}
		String[] returnStringArray = new String[limCounter+1];
		int lastDelim = 0;
		int placeCounter = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == character) {
				returnStringArray[placeCounter] = new String(data, lastDelim, i - lastDelim);
				placeCounter++;
				lastDelim = i+1;

			}
			
		}
		returnStringArray[placeCounter] = new String(data, lastDelim, data.length - lastDelim);
	return returnStringArray;
}
	
	
	
    /**
     * Compares two strings lexicographically.
     * The comparison is based on the Unicode value of each character in
     * the strings. The character sequence represented by this
     * {@code String} object is compared lexicographically to the
     * character sequence represented by the argument string. The result is
     * a negative integer if this {@code String} object
     * lexicographically precedes the argument string. The result is a
     * positive integer if this {@code String} object lexicographically
     * follows the argument string. The result is zero if the strings
     * are equal; {@code compareTo} returns {@code 0} exactly when
     * the {@link #equals(String)} method would return {@code true}.
     * <p>
     * This is the definition of lexicographic ordering. If two strings are
     * different, then either they have different characters at some index
     * that is a valid index for both strings, or their lengths are different,
     * or both. If they have different characters at one or more index
     * positions, let <i>k</i> be the smallest such index; then the string
     * whose character at position <i>k</i> has the smaller value, as
     * determined by using the {@code <} operator, lexicographically precedes the
     * other string. In this case, {@code compareTo} returns the
     * difference of the two character values at position {@code k} in
     * the two string -- that is, the value:
     * <blockquote><pre>
     * this.charAt(k)-anotherString.charAt(k)
     * </pre></blockquote>
     * If there is no index position at which they differ, then the shorter
     * string lexicographically precedes the longer string. In this case,
     * {@code compareTo} returns the difference of the lengths of the
     * strings -- that is, the value:
     * <blockquote><pre>
     * this.length()-anotherString.length()
     * </pre></blockquote>
     * 
     * @param   anotherString   the {@code String} to be compared.
     * @return  the value {@code 0} if the argument string is equal to
     *          this string; a value less than {@code 0} if this string
     *          is lexicographically less than the string argument; and a
     *          value greater than {@code 0} if this string is
     *          lexicographically greater than the string argument.
     */
	public int compareTo(String anotherString) {
		// TODO
		if (data.length == 0 && anotherString.data.length == 0) {
			return 0;
		}
		if (data.length == 0) {
			return -1;
		}
		if (anotherString.data.length == 0) {
			return 1;
		}
		for (int i = 0; i < data.length; i++) {
			if (i >= anotherString.data.length) {
				return 1;
			}
			if (data[i] != anotherString.data[i]) {
				if (data[i] > anotherString.data[i]) { //iterates through and compares each character in the string
					return 1;
				}
				else
					return -1;
			}	
		}
		if (data.length < anotherString.data.length) {
			return -1;
		}
		return 0;
	}


    /**
     * Compares this string to the given String.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * String} object that represents the same sequence of characters as this
     * object.
     *
     * @param  other
     *         The {@code String} to compare this {@code String} against
     *
     * @return  {@code true} if the given {@code String} is
     *          equivalent to this {@code String}, {@code false} otherwise
     *
     * @see  #compareTo(String)
     */
	public boolean equals(String other) {
		// TODO
		if (data == null || other.data == null) {
			return false;
		}											//checking for anything that would immediately return false
		if (data.length != other.data.length) {
			return false;
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i] != other.data[i]) { //iterates through each character to check if the strings are equal
				return false;
			}
		}
		return true;
		
	}
	
	public String concat(String other) {
		int len1 = this.data.length;
		int len2 = other.data.length;
		int indexFinder = 0;
		char[] returnAns = new char[len1 + len2];
		for (int i = 0; i < this.data.length; i++) {
			returnAns[i] = this.data[i];
			indexFinder++;
		}
		for (int i = 0; i < other.data.length; i++) {
			returnAns[indexFinder] = other.data[i];
			indexFinder++;
		}
		String returnString = new String(returnAns);
		return returnString;
		
	}
	public static void main() {
		char[] bookA = {'b', 'o', 'o', 'k'};
		char[] storeA = {'s', 't', 'o', 'r', 'e'};
		String book = new String(bookA);
		String store = new String(storeA);
		String answer = book.concat(store);
		System.out.println(answer);
	}

}
