import java.util.*; 

class StringOp{
    String currentString = new String("");
	StringOp(String s){
		this.currentString=s;
	}
	//Function to append the String
    public String append(String given_String) {
		if (currentString.length()>0)       //adding spaces between words
			currentString+=' ';
        currentString+=given_String;
		return currentString;
    }

	//function to count the words in the string
    public int countWords() {
        String temp_st = new String("");   //temporary string to store the word
		int word_count=0;
        for (char ch : currentString.toCharArray()) {
            if (ch == ' ' || ch==',') {
                if (temp_st.length() > 0) {
                    word_count++;   //adding the word count
                    temp_st="";   //making the string empty
                }
            } else {
                temp_st+=ch;        //adding character in string
            }
        }
        if (temp_st.length() > 0) 
			word_count++;      //adding last word count
        return word_count;
    }

	//function to reverse the string
	public String reverseString() {
		char[] char_array = currentString.toCharArray(); // Convert to char array
		char[] reversed = new char[char_array.length]; // Create array for reversed characters

		for (int i = char_array.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = char_array[i]; 
		}

		currentString = new String(reversed);      //converted the char[] in string
		return currentString;
	}
	
	//function to replace the character in the string
	public String replaceChar(char a,char b){
		String temp_string=new String("");		//making temp empty string for storing the char
		for (char ch: currentString.toCharArray()){
			if (ch==a){
				temp_string+=b;
			}
			else{
				temp_string+=ch;
			}
		}
		currentString=temp_string;
		return currentString;
	}
	//function to delete the substring
	public String stringSlice(int start,int end){
		if (start < 0 || end > currentString.length() || start > end) {   //valid checks befor slicing
			return "0";
		}
		currentString=currentString.substring(0,start)+currentString.substring(end);
		return currentString;
	}
	//function to split string in array
	public List<String> splitString(){
		List<String> word_List = new ArrayList<>();
        String st = new String("");     
        for (char ch : currentString.toCharArray()) {
            if (ch == ' ') {
                if (st.length() > 0) {
                    word_List.add(st);
                    st="";
                }
            } else {
                st+=ch;
            }
        }
        if (st.length() > 0) 
			word_List.add(st);
		return word_List;
	}
	//function to check the string is pallindrome or not
	public boolean isPalindrome() {
		char[] st=currentString.toLowerCase().toCharArray(); // Convert to char array
		int left=0;
		int right=st.length-1;
		while(left<=right){
			if (st[left]!=st[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	//function to shift the char of the string
	public String stringShift(int n){
		if (n<0)
			return currentString ;
		int len = currentString.length();
		if (len == 0) return currentString;
		n = n % len; 
		String s = currentString;
		String shifted = s.substring(len - n) + s.substring(0, len - n);
		currentString = new String(shifted);
		return currentString;
		
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
	public String sortString() {
		char[] sstring = currentString.toLowerCase().toCharArray();
		Arrays.sort(sstring);  
		currentString = new String(sstring);
		return currentString;
	}
}

class MyString{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int option = 0;

        System.out.print("Enter the initial string: ");
		StringOp str = new StringOp(obj.nextLine());
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
                    System.out.println("Appended String: " + str.append(obj.nextLine()));
                    break;
                case 2:
                    System.out.println("Word count: " + str.countWords());
                    break;
				case 3:
					System.out.println("Enter the character to replace :");
					char a=obj.next().charAt(0);
					System.out.println("Enter the character to replace with:");
					char b=obj.next().charAt(0);
					System.out.println("String:"+str.replaceChar(a,b));
					break;
				case 4:
					System.out.println(str.isPalindrome());
					break;
				case 5:
					System.out.println("Enter the start and end (s,e) to delete:");
					int start=obj.nextInt();
					int end=obj.nextInt();
					System.out.println("Sliced String:"+str.stringSlice(start,end));
					break;
				case 6:
					System.out.println("String:"+str.splitString());
					break;
                case 7:
                    str.maxRepeat();
                    break;
				case 8:
					System.out.print("Sorted String:"+str.sortString());
					break;
				case 9:
					System.out.print("Enter shift no: ");
					int n = obj.nextInt();
					System.out.print("String:"+str.stringShift(n));
					break;
                case 10:
					System.out.print("Reverse String:"+ str.reverseString());
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
