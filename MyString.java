import java.util.*; 

class StringOp{
    String currentString = new String("");
	
	//Function to append the String
    public void append(String gString) {
		if (currentString.length()>0)       //adding spaces between words
			currentString+=' ';
        currentString+=gString;
    }

	//function to count the words in the string
    public int countWords() {
        List<String> temp = new ArrayList<>();
        String st = new String("");   //temporary string to store the word

        for (char ch : currentString.toCharArray()) {
            if (ch == ' ') {
                if (st.length() > 0) {
                    temp.add(st);     //adding the words to list
                    st="";   //making the string empty
                }
            } else {
                st+=ch;        //adding character in string
            }
        }
        if (st.length() > 0) 
			temp.add(st);        //adding the words to list
        return temp.size();
    }

	//function to reverse the string
	public void reverseString() {
		char[] st = currentString.toCharArray(); // Convert to char array
		char[] reversed = new char[st.length]; // Create array for reversed characters

		for (int i = st.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = st[i]; 
		}

		currentString = new String(reversed);      //converted the char[] in string
	}
	
	//function to replace the character in the string
	public void replaceChar(char a,char b){
		String st=new String("");		//making temp empty string for storing the char
		for (char ch: currentString.toCharArray()){
			if (ch==a){
				st+=b;
			}
			else{
				st+=ch;
			}
		}
		currentString=st;
		System.out.println(currentString);
	}
	//function to delete the substring
	public void stringSlice(int start,int end){
		if (start < 0 || end > currentString.length() || start > end) {   //valid checks befor slicing
			System.out.println("Invalid range");
			return;
		}
		currentString=currentString.substring(0,start)+currentString.substring(end);
		System.out.println("String: " + currentString);
	}
	//function to split string in array
	public void splitString(){
		List<String> temp = new ArrayList<>();
        String st = new String("");     
        for (char ch : currentString.toCharArray()) {
            if (ch == ' ') {
                if (st.length() > 0) {
                    temp.add(st);
                    st="";
                }
            } else {
                st+=ch;
            }
        }
        if (st.length() > 0) 
			temp.add(st);
		System.out.println(temp);
	}
	//function to check the string is pallindrome or not
	public void isPalindrome() {
		char[] st=currentString.toLowerCase().toCharArray(); // Convert to char array
		int left=0;
		int right=st.length-1;
		while(left<=right){
			if (st[left]!=st[right]){
				System.out.println("Not Palindrome");
				return;
			}
			left++;
			right--;
		}
		System.out.println("Palindrome");
	}
	
	//function to shift the char of the string
	public void stringShift(int n){
		if (n<0)
			return;
		int len = currentString.length();
		if (len == 0) return;
		n = n % len; 
		String s = currentString;
		String shifted = s.substring(len - n) + s.substring(0, len - n);
		currentString = new String(shifted);
		System.out.println("After shifting: " + currentString);
		
	}

	//function to find the repeating char in string
    public void maxRepeat() {
		String temp = currentString.toLowerCase();
        int[] freq = new int[256];         //intitalizing the frequency array 
        for (char c : temp.toCharArray()) {
            freq[c]++;
        }

        char maxChar = ' ';
        int maxCount = 0;
        for (char c : temp.toCharArray()) {
			if (c!=' '){
				if (freq[c] > maxCount) {
					maxCount = freq[c];
					maxChar = c;
				}
			}
        }

        System.out.println("Character with maximum occurrence: " + maxChar + " -> " + maxCount);
    }
	
	//function to sort the string
	public void sortString() {
		char[] sstring = currentString.toLowerCase().toCharArray();
		Arrays.sort(sstring);  
		currentString = new String(sstring);
		System.out.println("Sorted string: " + currentString);
	}
    public void display() {
        System.out.println("Current String: " + currentString);
    }
}

class MyString{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        StringOp str = new StringOp();
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
