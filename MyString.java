import java.util.*; 

class MyString {
    StringBuilder currentString = new StringBuilder("");

    public void append(String gString) {
		if (currentString.length()>0)
			currentString.append(" ");
        currentString.append(gString);
    }

    public int countWords() {
        List<String> temp = new ArrayList<>();
        StringBuilder st = new StringBuilder("");

        for (char ch : currentString.toString().toCharArray()) {
            if (ch == ' ') {
                if (st.length() > 0) {
                    temp.add(st.toString());
                    st.setLength(0);
                }
            } else {
                st.append(ch);
            }
        }
        if (st.length() > 0) 
			temp.add(st.toString());
        return temp.size();
    }

    public void reverseString() {
        currentString.reverse();
    }
	public void replaceChar(char a,char b){
		StringBuilder st=new StringBuilder("");
		for (char ch: currentString.toString().toCharArray()){
			if (ch==a){
				st.append(b);
			}
			else{
				st.append(ch);
			}
		}
		currentString=st;
		System.out.println(currentString);
	}
	public void stringSlice(int start,int end){
		
		currentString.delete(start,end);
		System.out.println("String:"+currentString);
	}
	public void splitString(){
		List<String> temp = new ArrayList<>();
        StringBuilder st = new StringBuilder("");
        for (char ch : currentString.toString().toCharArray()) {
            if (ch == ' ') {
                if (st.length() > 0) {
                    temp.add(st.toString());
                    st.setLength(0);
                }
            } else {
                st.append(ch);
            }
        }
        if (st.length() > 0) 
			temp.add(st.toString());
		System.out.println(temp);
	}
	public void isPalindrome() {
		StringBuilder rev = new StringBuilder(currentString);
		rev.reverse();
		if (currentString.toString().equals(rev.toString())) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
	public void stringShift(int n){
		int len = currentString.length();
		if (len == 0) return;
		n = n % len; 
		String s = currentString.toString();
		String shifted = s.substring(len - n) + s.substring(0, len - n);
		currentString = new StringBuilder(shifted);
		System.out.println("After shifting: " + currentString);
}

    public void maxRepeat() {
		String temp = currentString.toString().toLowerCase();
        int[] freq = new int[256];
        for (char c : temp.toCharArray()) {
            freq[c]++;
        }

        char maxChar = ' ';
        int maxCount = 0;
        for (char c : temp.toCharArray()) {
            if (freq[c] > maxCount) {
                maxCount = freq[c];
                maxChar = c;
            }
        }

        System.out.println("Character with maximum occurrence: " + maxChar + " -> " + maxCount);
    }
	public void sortString() {
		char[] sstring = currentString.toString().toCharArray();
		Arrays.sort(sstring);  
		currentString = new StringBuilder(new String(sstring));
		System.out.println("Sorted string: " + currentString);
	}
    public void display() {
        System.out.println("Current String: " + currentString);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        MyString str = new MyString();
        int option = 0;

        System.out.print("Enter the initial string: ");
        str.append(obj.nextLine());

        while (option != 11) {
            System.out.println("\nSelect the Operation:");
            System.out.println("1. Append the string");
            System.out.println("2. Count the words");
            System.out.println("3. Replace the character");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Slicing the string");
            System.out.println("6. Split the String");
            System.out.println("7. Maximum Repeating Character");
            System.out.println("8. Sort the String");
            System.out.println("9. Shift character in string");
            System.out.println("10. Reverse the string");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            option = obj.nextInt();
            obj.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter the string to append: ");
                    str.append(obj.nextLine());
                    str.display();
                    break;
                case 2:
                    System.out.println("Word count: " + str.countWords());
                    break;
				case 3:
					System.out.println("Enter the character to replace :");
					char a=obj.next().charAt(0);
					System.out.println("Enter the character to replace with:");
					char b=obj.next().charAt(0);
					str.replaceChar(a,b);
					break;
				case 4:
					str.isPalindrome();
					break;
				case 5:
					System.out.println("Enter the start and end (s,e) to delete:");
					int start=obj.nextInt();
					int end=obj.nextInt();
					str.stringSlice(start,end);
					break;
				case 6:
					str.splitString();
					break;
                case 7:
                    str.maxRepeat();
                    break;
				case 8:
					str.sortString();
					break;
				case 9:
					System.out.print("Enter shift no: ");
					int n = obj.nextInt();
					str.stringShift(n);
					break;
                case 10:
                    str.reverseString();
                    str.display();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Incorrect option!");
            }
        }
        obj.close();
    }
}
