
public class StringOperations {

	public static void main(String[] args) 
	{
		String s = "  Hello Java World  ";

        System.out.println("Original: " + s);
        System.out.println("Trimmed: " + s.trim());
        System.out.println("Length: " + s.length());
        System.out.println("CharAt(4): " + s.charAt(4));
        System.out.println("Substring(2,7): " + s.substring(2,7));
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Lowercase: " + s.toLowerCase());
        System.out.println("Contains 'Java': " + s.contains("Java"));
        System.out.println("Replace 'Java' with 'Code': " + s.replace("Java","Code"));
        
        String[] words = s.trim().split(" ");
        System.out.println("Split words:");
        for(String w : words) System.out.println(w);

        String joined = String.join("-", words);
        System.out.println("Joined: " + joined);
    }
}
