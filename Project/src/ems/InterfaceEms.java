package ems;

public interface InterfaceEms {

	default void classInfo() {
		System.out.println("method not overriden hence no info about this class/Interface");
	}
}
