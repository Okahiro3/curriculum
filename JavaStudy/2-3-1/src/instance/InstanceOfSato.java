package instance;

import java.util.Objects;

public class InstanceOfSato {
	
	private int id = 0;
	
	private static int staticVarId = 0;
	
	public void incrementId() {
        this.id++;
        System.out.println("id: var          = " + this.id);
        InstanceOfSato.staticVarId++;
        System.out.println("id: static var   = " + InstanceOfSato.staticVarId);
    }
	
	private String firstName;
	
	public InstanceOfSato(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InstanceOfSato)) {
			return false;
		}
		InstanceOfSato other = (InstanceOfSato) obj;
		return Objects.equals(firstName, other.firstName);
	}
}
