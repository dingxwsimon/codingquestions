package stringoperation;

public class CamelCaseToSnakeCase {
    private static String camelToSnake(final String camelString) {
	// if null return null
	// that can be discussed
	if (camelString == null) {
	    return camelString;
	}
	// if given a blank string return an empty one
	String trimmedCamel = camelString.trim();
	if (trimmedCamel.isEmpty()) {
	    return trimmedCamel;
	}
	// a buffer for the snake case result
	StringBuilder snakeCase = new StringBuilder();
	char snakeSeparator = '_';
	// iterate over code points
	int codePointCount = trimmedCamel.codePointCount(0,
		trimmedCamel.length());
	System.out.println("codePointCount " + codePointCount);
	for (int i = 0; i < codePointCount; i++) {
	    int codePoint = trimmedCamel.codePointAt(i);
	    // if the current code point is in upper case and not the first
	    if (Character.isUpperCase(codePoint) && i != 0) {
		snakeCase.append(snakeSeparator);
	    }
	    // append lower case code point to the buffer
	    snakeCase.appendCodePoint(Character.toLowerCase(codePoint));
	}
	// convert the buffer to a string
	return snakeCase.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(camelToSnake("SomeGoodName"));
    }

}
