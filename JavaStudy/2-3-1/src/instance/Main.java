package instance;

public class Main {
	
	public static void main(String[] args) {
		InstanceOfSato sato1 = new InstanceOfSato("祐希");
		InstanceOfSato sato2 = new InstanceOfSato("奈々");
		InstanceOfSato sato3 = new InstanceOfSato("愛菜");
		
		System.out.println("--- インスタンスごとのハッシュコード ---");
	    System.out.println("sato1のハッシュコード: " + sato1.hashCode());
	    System.out.println("sato2のハッシュコード: " + sato2.hashCode());
	    System.out.println("sato3のハッシュコード: " + sato3.hashCode());

	    System.out.println("--- 「sato1 と sato2」のインスタンスが同一かのチェック ---");
	    System.out.println("参照先インスタンスの比較　　: " + (sato1 == sato2));
	    System.out.println("参照先インスタンスの値の比較: " + (sato1.equals(sato2)));

	    System.out.println("--- 「sato1 と sato3」のインスタンスが同一かのチェック ---");
	    System.out.println("参照先インスタンスの比較　　: " + (sato1 == sato3));
	    System.out.println("参照先インスタンスの値の比較: " + (sato1.equals(sato3)));
	    
	    System.out.println("--- incrementId() ---");
        System.out.println("sato1:");
        sato1.incrementId();
        System.out.println("sato2:");
        sato2.incrementId();
        System.out.println("sato3:");
        sato3.incrementId();
	}

}
