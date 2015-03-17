package lab_2;


import java.io.*;
import java.util.*; 

public class Lab2 {
    Tree theTree = new Tree();
    //public Map<Integer, tree> table = new Hashtable<Integer, tree>();
    public static int index = 0;

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.print("Enter size: ");
        Scanner size = new Scanner(System.in);
        index = size.nextInt();
        System.out.print("Enter first letter of ");
        System.out.print("insert, show, find, or end: ");
        char choice = (char) System.in.read();
        switch(choice){
            case 's':
                break;
            case 'f':
                break;
            case 'i':
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter the variables, max of 15: ");
                int input = keyboard.nextInt();
                insert(input);
                break;
            case 'e':
                System.exit(0);
                break;
            default:
                System.out.print("Invalid entry\n");
            
        }
    }
    
    public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
        public static void insert(int input){
        System.out.println(input);
    }
    public void search(int key){
        
    }
    public void show(){
        
    }

    private static class Tree {

        class Node {

            public int iData; // data item (key)
            public double dData; // data item 
            public String code;//huffman code
            public Node leftChild; // this node's left child
            public Node rightChild; // this node's right child

            public void displayNode() // display ourself
            {
                System.out.print('{');
                System.out.print(iData);
                System.out.print(", ");
                System.out.print(dData);
                System.out.print("} ");
            }
        } // end class Node
        Node root;

        public Tree() // constructor
        {
            root = null;
        }
        public void insert(int id, double dd) {
            Node newNode = new Node(); // make new node
            newNode.iData = id; // insert data
            newNode.dData = dd;
            if (root == null) // no node in root
            {
                root = newNode;
            } else // root occupied
            {
                Node current = root; // start at root
                Node parent;
                while (true) // (exits internally)
                {
                    parent = current;
                    if (id < current.iData) // go left?
                    {
                        current = current.leftChild;
                        if (current == null) // if end of the line,
                        { // insert on left
                            parent.leftChild = newNode;
                            return;
                        }
                    } // end if go left
                    else // or go right?
                    {
                        current = current.rightChild;
                        if (current == null) // if end of the line
                        { // insert on right
                            parent.rightChild = newNode;
                            return;
                        }
                    } // end else go right
                } // end while
            } // end else not root
        } // end insert()

        public Node find(int key) // find node with given key
        { // (assumes non-empty tree)
            Node current = root; // start at root
            //System.out.println(current.iData);
            while (current.iData != key) // while no match,
            {
                if (current.leftChild.iData == key) // go left?
                {
                    current = current.leftChild;
                } else // or go right?
                {
                    current = current.rightChild;
                }
                if (current == null) // if no child,
                {
                    return null; // didn't find it
                }
            }
            return current; // found it
        } // end find()

    }

}
