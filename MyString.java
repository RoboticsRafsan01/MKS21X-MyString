public class MyString implements CharSequence,Comparable<CharSequence>{
// Field(s)
  private char[] data;

// Constructor
  public MyString(CharSequence s) {
    data = new char[s.length()]; // Initialize the char array
    for(int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);  // add chars to the array
    }
  }

// Comparable method required
  public int compareTo(CharSequence object) {
    if(object == null || this == null) {throw new NullPointerException();} // if object or this is null, then output appropriate exception
    if(object.length() != this.length()) {return this.length() - object.length();} // if the lengths are not equal, we can find result here
    for(int i = 0; i < object.length(); i++) {
      if(object.charAt(i) != this.charAt(i)) {return this.charAt(i) - object.charAt(i);} // look for the disimmilar char, then return the difference
    }
    return 0; // return 0 otherwise
  }

  // Methods that must be written

// Returns the length of the Charsequence
  public int length() {
    return this.data.length;
  }

// Returns the char at a specific index
  public char charAt(int index) {
    if(index < 0 || index >= data.length) {
      throw new IndexOutOfBoundsException("Incorrect index input!"); // if index is out of bounds, then output appropriate exception
    }
    return data[index];
  }

// Returns a part of the Charsequence, much like substring
  public CharSequence subSequence(int start, int end) {
    if( (start-end) > 0 || (end - this.length()) > 0) {
      throw new IndexOutOfBoundsException("Incorrect start and/or end input!"); // if start and end index are out of bounds, then output appropriate exception
    }
    if(start < 0 || end < 0) { throw new IndexOutOfBoundsException();}
    String result = "";
    for(int i = start; i < end; i++) {
      result += this.data[i];
    }
    MyString output = new MyString(result);
    return output;
  }

// Standard toString method
  public String toString(){
    String result = "";
    for(int i = 0; i < length(); i++) {
      result += this.charAt(i); // add chars to the result String in sequence
    }
    return result;
  }

}
