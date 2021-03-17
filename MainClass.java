import java.util.*;

class Block{
	private String sender;
	private int transactionAmt;
	private String receiver;

	private long prevHash;   // HASH OF PREV BLOCK => Used in hashCode of current block
	private long currentHash;  // HASH OF CURRENT BLOCK

	String currentTransaction; // CURRENT BLOCK TRANSACTION STRING => Used in hashCode of current block

	public Block(String sender, int amt, String receiver, long hash){
		this.sender = sender;
		this.transactionAmt = amt;
		this.receiver = receiver;
		this.prevHash = hash;
		this.currentTransaction = sender + " sent " + transactionAmt + " bitcoins to " + receiver; 
		Object[] current = {currentTransaction, prevHash};
		this.currentHash = Arrays.hashCode(current);
	}

	public void getTransaction(){
		System.out.println(currentTransaction);
	}

	public void getPrevHash(){
		System.out.println(prevHash);
	}
}


public class MainClass{

	static void transact(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Name of Sender: ");
		System.out.println("Name of Receiver: ");
		System.out.println("Amount sent: ");
	}

	static void showLedger(){
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// genesis transaction => Mayank sent 100 bitcoins to Shubham
		Block genesisBlock = new Block("Mayank", 100, "Shubham", 0);
		genesisBlock.getTransaction();
		genesisBlock.getPrevHash();

		LinkedList<Block> blockChain = new LinkedList<>();
		blockChain.add(genesisBlock);

		while(true){
			System.out.println("Choose Operation: ");
			System.out.println("1: Request Transaction");
			System.out.println("2: Check ledger");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					System.out.println();
					transact();
					break;
				case 2:
					System.out.println();
					showLedger();
					break;
				default:
					System.out.println("Select a valid choice!");
			}
		}
	}
}
